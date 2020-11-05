package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User on login page")
    public void user_on_login_page() {
        Driver.getDriver().get("http://zero.webappsecurity.com/login.html");
    }

    @When("User login with {string} and {string}")
    public void user_login_with_and(String string, String string2) {
        loginPage.createUsername(string);
        loginPage.createPassword(string2);
        loginPage.clickOnSignInButton();
    }

    @Then("user should be on {string}")
    public void user_should_be_on_main_page(String string) {
        loginPage.verifyTitle(string);
    }

}
