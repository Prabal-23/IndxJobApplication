package com.Indx.qa.PO;
import com.Indx.qa.Base.IndxBase;
import org.openqa.selenium.By;

public class INdxContactFormPO extends  IndxBase{


    private By contactus =By.xpath("(//a[contains(text(),'Contact Us')])[1]");

    private By contactformfirstname = By.xpath("//input[@name='your-name']");

    private By companycontactform = By.xpath("//input[@name='your-company']");

    private By emailcontactform = By.xpath("//input[@name='your-email']");

    private By mobielnocontactform = By.xpath("//input[@name='your-phone']");

    private By designationcontactform = By.xpath("//input[@name='your-designation']");

    private By subjectdropdowncontactform= By.xpath("//select[@name='options']");

    private By messagecontactform = By.xpath("//textarea[@name='your-message']");

    private By checkboxcontactform =By.xpath("(//input[@type='checkbox'])[1]");

    private By submitbuttoncontactform = By.xpath("//input[@value='SUBMIT']");



    public void fillDetaisslContactForm(){
        clickSafelyJS(contactus);
        sendKeysInTextBox(contactformfirstname,prop.getProperty("firstnametextbox"));
        sendKeysInTextBox(companycontactform,prop.getProperty("companyname"));
        sendKeysInTextBox(designationcontactform,prop.getProperty("Designation"));
        sendKeysInTextBox(emailcontactform,prop.getProperty("emailtextbox"));
        sendKeysInTextBox(mobielnocontactform,prop.getProperty("mobilenumber"));
        sendKeysInTextBox(messagecontactform,prop.getProperty("additionalinfo"));
        clickSafelyJS(checkboxcontactform);
        selectSubjectinContactForm(subjectdropdowncontactform,prop.getProperty("Subject"));
        clickSafelyJS(submitbuttoncontactform);
    }

    public void selectSubjectinContactForm(By locator,String s){
        selectFromDropdownByvalue(locator,s);
    }




}
