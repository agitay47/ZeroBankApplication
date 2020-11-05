package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrency_StepDefinitions {

    PurchaseForeignCurrencyPage currency = new PurchaseForeignCurrencyPage();

    @Given("user clicks on {string}")
    public void user_clicks_on(String string) {
        currency.clickOnPurchaseForeignCurrency();
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {
        currency.currencyList();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {

        ArrayList<String> arrayList = currency.currencyList();

        System.out.println("arrayList = " + arrayList);
        for (String each : dataTable) {
            System.out.println("arrayList.contains(each) = " + each);
            Assert.assertTrue(arrayList.contains(each));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        currency.clickOnCalculateCostButton();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(currency.isAlarDisplay());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        currency.clickOnCalculateCostButton();
    }


}
