package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddPayeePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class AddNewPayee_StepDefinitions {

    AddPayeePage payeePage = new AddPayeePage();

    @Given("user click on {string} module")
    public void user_click_on_module(String string) {
        payeePage.clickOnPayBills();
    }

    @Then("user clicks on {string} sub module")
    public void user_clicks_on_sub_module(String string) {
        payeePage.clickOnAddNewPayee();
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        payeePage.createPayeeName(dataTable.get("Payee Name"));
        payeePage.createPayeeAddress(dataTable.get("Payee Address"));
        payeePage.createAccount(dataTable.get("Account"));
        payeePage.createPayeeDetails(dataTable.get("Payee details"));
        payeePage.clickOnAddButton();


    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        payeePage.verifyTitle(string);

    }
}