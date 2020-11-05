package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountsActivity_Steps {

    AccountActivityPage account = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_account_summary_page(String string) {

        account.clickOnSavings(string);
    }

    @Then("the {string} should be displayed")
    public void the_page_should_be_displayed(String string) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }

    @When("the user clicks on {string} link on Account Summary page")
    public void the_user_clicks_on_link_on_account_summary_page(String string) {
        account.clickOnBrokerage(string);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {

        Assert.assertEquals(string, account.getFirstSelected());

    }


    @Then("Account drop down should have {string} selected now")
    public void account_drop_down_should_have_selected_now(String string) {

        Assert.assertEquals(string, account.brokerageSelected());

    }

    @When("the user clicks on	{string} link on the Account Summary page")
    public void the_user_clicks_on_checking_link_on_the_account_summary_page(String string) {
        account.clickOnChecking(string);
    }

    @Then("Account drop down should have {string} be selected")
    public void account_drop_down_should_have_be_selected(String checking) {

        Assert.assertEquals(checking, account.checkingSelected());
    }

    @When("the user clicks on	{string} card link on the Account Summary page")
    public void the_user_clicks_on_card_link_on_the_account_summary_page(String string) {
        account.clickOnCreditCard(string);
    }

    @Then("Account drop down should have {string} should be selected")
    public void account_drop_down_should_have_should_be_selected(String CreditCard) {
        Assert.assertEquals(CreditCard, account.creditCardSelected());
    }

    @When("the user clicks on	{string} on the Account Summary page")
    public void the_user_clicks_on_the_account_summary_page(String loan) {
        account.clickOnLoan(loan);
    }

    @Then("Account drop down should have {string} should selected")
    public void account_drop_down_should_have_should_selected(String Loan) {
        Assert.assertEquals(Loan, account.loanSelected());
    }
}
