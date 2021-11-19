package ru.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    public WebDriver driver;

    public AboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='about_greeting']/div[3]/div[2]")
    private WebElement _gamersInGame;

    @FindBy(xpath = "//*[@id='about_greeting']/div[3]/div[1]")
    private WebElement _gamersIsOnline;

    @FindBy(xpath = "//a[@href='https://store.steampowered.com/']")
    private WebElement _marketBtn;

    public void clickMarketBtn(){
        _marketBtn.click();
    }

    public int getInGameNumber(){

        String nInG = _gamersInGame.getText().replaceAll("[^\\p{N}]", "");
        return Integer.parseInt(nInG);
    }

    public int getOnlineNumber(){

        String nOnl = _gamersIsOnline.getText().replaceAll("[^\\p{N}]", "");
        return Integer.parseInt(nOnl);
    }

    public boolean compareUsers(){
        return getOnlineNumber() > getInGameNumber();
    }
}