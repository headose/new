package ru.task1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_1 {

    public static WebDriver driver;
    public static Dimension dimension = new Dimension(1024,768);
    public static SteamPage steamPage;
    public static AboutPage aboutPage;
    public static TopSellersPage topSellersPage;


    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();

        driver = SingleWebDriver.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        driver.manage().window().setSize(dimension);

        steamPage = new SteamPage(driver);
        aboutPage = new AboutPage(driver);
        topSellersPage = new TopSellersPage(driver);

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void case_1(){
        driver.get(ConfProperties.getProperty("steampage"));
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("steampage"));

        steamPage.clickAboutBtn();
        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("aboutpage"));

        aboutPage.compareUsers();
        Assert.assertTrue(aboutPage.compareUsers());

        aboutPage.clickMarketBtn();
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("storepage"));
    }

    @Test
    public void case_2(){

        driver.get(ConfProperties.getProperty("steampage"));
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("steampage"));

        steamPage.actionNoteworthyBtn();

        steamPage.clickTopSellersBtn();
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("topsellerspage"));

        topSellersPage.clickLinuxCheckbox();
        Assert.assertTrue(topSellersPage.checkLinux());

        topSellersPage.clickNumbOfPlayersBtn();

        topSellersPage.clickCoopCheckbox();
        Assert.assertTrue(topSellersPage.checkCoop());

        topSellersPage.clickSeeAllExpanderBtn();

        topSellersPage.getActionValue();

        topSellersPage.clickActionCheckbox();
        Assert.assertTrue(topSellersPage.checkAction());

        topSellersPage.compareSearchResults();


        topSellersPage.getPriceGame();
        topSellersPage.getDataGame();
        topSellersPage.getNameGame();

        topSellersPage.clickFirstGame();
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("firstpage"));

        topSellersPage.compareTwoPage();
        Assert.assertTrue(topSellersPage.compareTwoPage());

    }

}
