package ru.task1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SteamPage {
    public WebDriver driver;

    public SteamPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='menuitem' and contains(@href, 'about')]")
    private WebElement _aboutBtn;

    @FindBy(xpath = "//div[@id='noteworthy_tab']")
    private WebElement _noteworthyBtn;

    @FindBy(xpath = "//a[@class='popup_menu_item' and contains(@href, 'filter=topsellers')]")
    private WebElement _topSellersBtn;

    public void clickTopSellersBtn(){
        _topSellersBtn.click();
    }

    public void actionNoteworthyBtn(){
        Actions actions = new Actions(driver);
        actions.moveToElement(_noteworthyBtn).perform();
    }

    public void clickAboutBtn(){
        _aboutBtn.click();
    }

}
