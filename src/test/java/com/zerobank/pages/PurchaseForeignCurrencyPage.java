package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage {

    public PurchaseForeignCurrencyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[.='Purchase Foreign Currency'])[1]")
    private WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//select[@id='pc_currency']//option")
    private List<WebElement> currencyList;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCostsButton;

    @FindBy(id = "purchase_cash")
    private WebElement purchaseButton;


    public void clickOnPurchaseForeignCurrency() {
        BrowserUtils.clickOnElement(purchaseForeignCurrency);
    }

    public ArrayList<String> currencyList(){
        List<WebElement> list = currencyList;
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement each :list){
            arrayList.add(each.getText());
        }
        System.out.println("arrayList = " + arrayList);
        return arrayList;
    }

    public void clickOnCalculateCostButton(){
        BrowserUtils.clickOnElement(calculateCostsButton);
    }

    public void clickOnPurchaseButton(){
        BrowserUtils.clickOnElement(purchaseButton);
    }

    public boolean isAlarDisplay(){
        Alert alert = Driver.getDriver().switchTo().alert();
        String errorMessage=alert.getText();

        return !errorMessage.isEmpty();

    }
}
