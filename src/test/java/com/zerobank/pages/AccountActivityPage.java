package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Savings']")
    private WebElement savings;

    @FindBy(id = "aa_accountId")
    private WebElement accountDropdownSelector;

    @FindBy(xpath = "//a[.='Brokerage']")
    private WebElement brokerage;

    @FindBy(xpath = "//a[.='Checking']")
    private WebElement checking;

    @FindBy(xpath = "//a[.='Credit Card']")
    private WebElement creditCard;

    @FindBy(xpath = "//a[.='Loan']")
    private WebElement loan;


    public void clickOnSavings(String string) {
        BrowserUtils.clickOnElement(savings);
    }

    public void clickOnBrokerage(String string) {
        BrowserUtils.clickOnElement(brokerage);
    }

    public void clickOnChecking(String string){BrowserUtils.clickOnElement(checking);}

    public void clickOnCreditCard(String string){BrowserUtils.clickOnElement(creditCard);}
    public void clickOnLoan(String string){BrowserUtils.clickOnElement(loan);}

    public void verifyAccountsActivity(String type) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + type + "']"));
        BrowserUtils.scrollTo(element);
        BrowserUtils.clickOnElement(element);
    }


    public String getFirstSelected() {
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }

    public String brokerageSelected() {
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }

    public String checkingSelected() {
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }

    public String creditCardSelected() {
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }

    public String loanSelected() {
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }




}
