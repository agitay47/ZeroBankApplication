package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_login")
    private WebElement usernameInput;

    @FindBy(id = "user_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@value='Sign in']")
    private WebElement signInButton;

    public void createUsername(String string) {
        BrowserUtils.enterText(usernameInput, ConfigurationReader.getProperty("onlineBankUsername"));
    }

    public void createPassword(String string) {
        BrowserUtils.enterText(passwordInput, ConfigurationReader.getProperty("onlineBankPassword"));
    }

    public void clickOnSignInButton() {
        BrowserUtils.clickOnElement(signInButton);
    }

    public void login(){
        usernameInput.sendKeys(ConfigurationReader.getProperty("onlineBankUsername"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("onlineBankPassword")+ Keys.ENTER);
    }

    public void verifyTitle(String string){
        String expectedTitle = "Zero Bank";
        String actualTitle = Driver.getDriver().findElement(By.xpath("//*[.='Zero Bank']")).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


}
