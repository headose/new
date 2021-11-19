package ru.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopSellersPage {
    public WebDriver driver;
    public WebDriverWait wait;
    private int actionValue;
    private int searchResultCount;
    private int priceGame;
    private String dataGame;
    private String nameGame;

    public TopSellersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//span[@data-value='linux']")
    private WebElement _linuxCheckbox;

    @FindBy(xpath = "//div[@data-collapse-name='category3']//div[@class='block_header']")
    private WebElement _numberOfPlayers;

    @FindBy(xpath = "//div[@data-param='category3'  and @data-value='48']")
    private WebElement _cooperativeCheckbox;

    @FindBy(xpath = "//div[@data-value='19']//span[contains(@class, 'count')]")
    private WebElement _actionValue;

    @FindBy(xpath = "//div[@class='block search_collapse_block']//a[@class='see_all_expander']")
    private WebElement _seeAllExpanderBtn;

    @FindBy(xpath = "//span[@data-value='19' and @data-param='tags']")
    private WebElement _actionCheckbox;

    @FindBy(xpath = "//div[@class='search_results_count']")
    private WebElement _searchResultCount;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]")
    private WebElement _firstGameResultRows;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='title']")
    private WebElement _getFirstNameGame;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'search_released')]")
    private WebElement _getDateOfGame;

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[1]/div[2]/div[4]/div[2]")
    private WebElement _getPriceOfGame;

    @FindBy(xpath = "//div[@id='search_result_container']//a[1]")
    private WebElement _getFirstLinkGame;

    @FindBy(xpath = "//div[@id='game_area_purchase_section_add_to_cart_68179']//div[@class='discount_final_price']")
    private WebElement _getFgamePagePrice;

    @FindBy(xpath = "//div[@id='appHubAppName']")
    private WebElement _getFgamePageName;

    @FindBy(xpath = "//div[@class='date']")
    private WebElement _getFgamePageData;

    public boolean compareTwoPage(){
        return (dataGame.equals(getFirstGamePageData()) &&
                nameGame.equals(getFirstGamePageName()) && priceGame == getFirstGamePagePrice());
    }

    public String getFirstGamePageName(){
        return _getFgamePageName.getText();
    }

    public String getFirstGamePageData(){
        return _getFgamePageData.getText();
    }

    public int getFirstGamePagePrice(){
        return Integer.parseInt(_getFgamePagePrice.getText().replaceAll("[^\\p{N}]", ""));
    }

    public void clickFirstGame(){
        _getFirstLinkGame.click();
    }

    public String getNameGame(){
        nameGame = _getFirstNameGame.getText();
        return nameGame;
    }

    public String getDataGame(){
        dataGame = _getDateOfGame.getText();
        return dataGame;
    }

    public int getPriceGame(){

        String[]a = _getPriceOfGame.getText().split("\n");
        priceGame = Integer.parseInt(a[1].replaceAll("[^\\p{N}]", ""));
        return priceGame;
    }

    public boolean compareSearchResults(){
        return actionValue == getSearchResultCount();
    }

    public int getSearchResultCount(){
          searchResultCount = Integer.parseInt(_searchResultCount.getText().replaceAll("[^\\p{N}]", ""));
        return searchResultCount;
    }

    public void clickActionCheckbox(){
        _actionCheckbox.click();
    }

    public void clickSeeAllExpanderBtn(){
        _seeAllExpanderBtn.click();

    }

    public boolean checkAction(){
        return _actionCheckbox.getAttribute("class").contains("checked");
    }

    public boolean checkCoop(){
        return _cooperativeCheckbox.getAttribute("class").contains("checked");
    }

    public boolean checkLinux(){
        return _linuxCheckbox.getAttribute("class").contains("checked");
    }

    public int getActionValue(){

        actionValue = Integer.parseInt(_actionValue.getText().replaceAll("[^\\p{N}]", ""));
        return actionValue;
    }

    public void clickCoopCheckbox(){
        _cooperativeCheckbox.click();
    }

    public void clickNumbOfPlayersBtn(){
        _numberOfPlayers.click();
    }

    public void clickLinuxCheckbox(){
        _linuxCheckbox.click();
    }



}
