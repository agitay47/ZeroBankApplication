package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.TransactionPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactions_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    TransactionPage findTransactionsPage = new TransactionPage();


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("onlineBankURL"));
        loginPage.login();
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Account Summary");

        findTransactionsPage.click_topTab_accountActivityTab();
        findTransactionsPage.clickfindTransactions();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTransactionsPage.enter_formAndToDate(fromDate,toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.clickFindButton();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String beggingDate, String endDate) {
        Assert.assertTrue( findTransactionsPage.firstAndLastDate(beggingDate, endDate));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        System.out.println("loginPage = " + findTransactionsPage.isSort());
        Assert.assertTrue(findTransactionsPage.isSort());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String str) {
        Assert.assertTrue(findTransactionsPage.firstAndLastDate().size()>1);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        findTransactionsPage.enter_description(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(findTransactionsPage.isContainOnly(string));
    }

    @Then("results table should not show descriptions that not containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        Assert.assertTrue(findTransactionsPage.isContainOnly(string));
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_deposit() {
        System.out.println("findTransactionsPage.listOfDepositResult().size() = " + findTransactionsPage.listOfDepositResult().size());
        Assert.assertTrue(findTransactionsPage.listOfDepositResult().size()>0); }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_withdrawal() {
        System.out.println("findTransactionsPage.listOfWithdrawalResult().size() = " + findTransactionsPage.listOfWithdrawalResult().size());
        Assert.assertTrue(findTransactionsPage.listOfWithdrawalResult().size()>0);

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        findTransactionsPage.typeSelector(type);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_withdrawal() {
        Assert.assertTrue(findTransactionsPage.listOfWithdrawalResult().size()==0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        Assert.assertTrue(findTransactionsPage.listOfDepositResult().size()==0);
    }

}
