package ru.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleWebDriver {

    private static WebDriver _driver = null;

    private SingleWebDriver() {}

    public static ChromeDriver getChromeDriver(){
        if (_driver == null){
            _driver = new ChromeDriver();
        }
        return (ChromeDriver) _driver;
    }
}
