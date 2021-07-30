package com.Indx.qa.PO;

import com.Indx.qa.Base.IndxBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class INdxCurrentOpeningPO extends IndxBase {





 private  By currentopenings= By.xpath("//span[@class='vc_tta-title-text']");

 private By activepositionexpand= By.xpath("//div[@class='vc_tta-panel vc_active']");

 private By applybutton = By.xpath("//div[@class='vc_tta-panel vc_active']//span[ contains(text(),'APPLY NOW')]");

 private By closeicon = By.xpath("//*[@class='sgpb-popup-close-button-6']");

 private By firstnametextbox = By.xpath("//input[@name='fname']");

 private By lastnametextbox = By.xpath("//input[@name='lname']");

 private By mobilenumber = By.xpath("//input[@name='contact-number']");

 private By emailtextbox = By.xpath("//input[@name='emailid']");

 private By positiondropdown =By.xpath("//select[@name='position']");

 private By choosefile = By.xpath("//input[@type='file']");

 private By additionalinfo = By.xpath("//textarea[@name='moreinfo']");

 private By submitbutton = By.xpath("//input[@value='SUBMIT']");


 private By firstnameerrormsg = By.xpath("//input[@name='fname']//following-sibling::span");

 private By lastnameerrormsg = By.xpath("//input[@name='lname']//following-sibling::span");

 private By emailerrormsg = By.xpath("//input[@name='emailid']//following-sibling::span");

 private By mobileerrormsg = By.xpath("//input[@name='contact-number']//following-sibling::span");

 private By addinfoerrormsg = By.xpath("//textarea[@name='moreinfo']//following-sibling::span");





/*    public INdxCurrentOpeningPO() {
        PageFactory.initElements(driver, this);

    }*/




    public List<String> getCurrentOpeningsAndApplyJob(){

        ArrayList<String> openingsList = new ArrayList<String>();
        List<WebElement> e1= getMultipleElements(currentopenings);

        for(int i=0;i<e1.size();i++){
            openingsList.add(e1.get(i).getText());
            String availablepos = openingsList.get(i);
            clickOpeningsAndFillForm(availablepos);

        }
         System.out.println("Caurrently available openings are"+openingsList);
        return  openingsList;
    }

    public void clickOpeningsAndFillForm(String availableposition){

if (isWebElementPresent(activepositionexpand)==true){
clickSafelyJS(applybutton);
    verifyErrorMsgManadatoryField();
    fillDetailsJobApplication();
    clickSafelyJS(submitbutton);
    clickSafelyJS(closeicon);
    clickOnElement(driver,driver.findElement(By.xpath("//span[contains(text(),'"+availableposition+"')]")),"Apply button is clicked successfully");

}

else{
    clickOnElement(driver,driver.findElement(By.xpath("//span[contains(text(),'"+availableposition+"')]")),"Apply button is clicked successfully");
    clickSafelyJS(applybutton);
    verifyErrorMsgManadatoryField();
    fillDetailsJobApplication();
    clickSafelyJS(submitbutton);
    clickSafelyJS(closeicon);
    clickOnElement(driver,driver.findElement(By.xpath("//span[contains(text(),'"+availableposition+"')]")),"Apply button is clicked successfully");


}
    }


    public void fillDetailsJobApplication(){
        sendKeysInTextBox(firstnametextbox, prop.getProperty("firstnametextbox"));
         sendKeysInTextBox(lastnametextbox, prop.getProperty("lastnametextbox"));
         sendKeysInTextBox(emailtextbox, prop.getProperty("emailtextbox"));
         sendKeysInTextBox(mobilenumber,prop.getProperty("mobilenumber"));
         sendKeysInTextBox(additionalinfo, prop.getProperty("additionalinfo"));
         uploadImage(choosefile,"C:\\Users\\Lucky\\Documents\\Resume\\General\\Prabal Pratap Singh_CV.pdf");
    }


    public void verifyErrorMsgManadatoryField(){
        clickSafelyJS(submitbutton);
        Assert.assertEquals(getElement(firstnameerrormsg).getText(),prop.getProperty("errormessage"));
        Assert.assertEquals(getElement(lastnameerrormsg).getText(),prop.getProperty("errormessage"));
        Assert.assertEquals(getElement(emailerrormsg).getText(),prop.getProperty("errormessage"));
        Assert.assertEquals(getElement(mobileerrormsg).getText(),prop.getProperty("errormessage"));
        Assert.assertEquals(getElement(addinfoerrormsg).getText(),prop.getProperty("errormessage"));

    }


}
