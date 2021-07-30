package com.Indx.qa.Base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class IndxBase {


    public static WebDriver driver;
    public static Properties prop;
public static WebDriverWait wait;

    public void start()  {
        prop= new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\IndxJobApplication\\src\\main\\java\\com\\Indx\\qa\\Config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialization(){

        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait= new WebDriverWait(driver,20);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)   ;

        driver.get(prop.getProperty("url"));




    }






    JavascriptExecutor js = (JavascriptExecutor) driver;



    public void uploadImage(By locator,String s) {

        getElement(locator).sendKeys(s);
    }



    public void clickSafelyJS(By locator){
    js.executeScript("arguments[0].click();",getElement(locator));
    }


    public  WebElement getElement(By locator){
        return wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply( WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });
    }

  public Boolean isWebElementPresent(By locator){
        try{
            return  getElement(locator).isDisplayed();
        }
        catch (Throwable e){
            return false;
        }
  }
    public void selectSubjectinContactForm(By locator,String s){
        Select sel = new Select(getElement(locator));
        sel.selectByValue(s);
    }

    public List<WebElement> getMultipleElements(By locator){
        return wait.ignoring(StaleElementReferenceException.class)
                .until(new ExpectedCondition<List<WebElement>>() {
                    @Override
                    public List<WebElement> apply( WebDriver webDriver) {
                        return driver.findElements(locator);
                    }
                });

    }

    public void clickOnElement(WebDriver driver,WebElement locator, String message){

        WebDriverWait wait= new WebDriverWait(driver,50);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();

    }



    public void sendKeysInTextBox(By locator, String value){
        //WebDriverWait wait= new WebDriverWait(driver,50);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .sendKeys(value);


    }

    public void endSession(){
        driver.quit();
    }














}
