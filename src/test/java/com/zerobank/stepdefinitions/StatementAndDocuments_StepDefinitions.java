package com.zerobank.stepdefinitions;

import com.zerobank.pages.StatementsAndDocumentsDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementAndDocuments_StepDefinitions {

    StatementsAndDocumentsDetailsPage document = new StatementsAndDocumentsDetailsPage();

    @Then("user clicks on the {string}")
    public void user_clicks_on_the(String string) {
        document.click_onlineStatementsTab();
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_recent_statements_year(Integer int1) {
        document.click_year(int1);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int numberOfRecord) {
        Assert.assertEquals(numberOfRecord, document.statementsListNumber());
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String string) {
        document.click_statement(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        System.out.println("statementsAndDocumentsDetailsPage.lastFileName() = " + document.lastFileName());
        System.out.println("string = " + string);
        Assert.assertTrue(document.lastFileName().contains(string));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(document.lastFileName().contains("pdf"));
    }


}
