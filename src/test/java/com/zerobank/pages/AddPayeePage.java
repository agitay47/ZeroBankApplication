package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPayeePage extends BasePage{

    public AddPayeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[.='Pay Bills'])[1]")
    private WebElement payBills;

    @FindBy(xpath = "(//*[.='Add New Payee'])[1]")
    private WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement account;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement AddButton;

    @FindBy(id="alert_content")
    private WebElement verifyTitle;



    public void clickOnPayBills(){
        BrowserUtils.clickOnElement(payBills);
    }

    public void clickOnAddNewPayee(){
        BrowserUtils.clickOnElement(addNewPayee);
    }

    public void createPayeeName(String string){
        BrowserUtils.enterText(payeeName,string);
    }

    public void createPayeeAddress(String string){
        BrowserUtils.enterText(payeeAddress,string);
    }

    public void createAccount(String string){
        BrowserUtils.enterText(account,string);
    }

    public void createPayeeDetails(String string){
        BrowserUtils.enterText(payeeDetails,string);
    }

    public void clickOnAddButton(){
        BrowserUtils.clickOnElement(AddButton);
    }

    public void verifyTitle(String string){
        String expectedMessage = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actualMessage=Driver.getDriver().findElement(By.id("alert_content")).getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
