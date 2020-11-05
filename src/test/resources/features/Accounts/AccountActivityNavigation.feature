@Account_Activity
Feature:Navigating to specific accounts in	Accounts Activity

  Background: Common Steps
    Given the user is logged in

  @AC1
  Scenario: Savings account redirect

    When the user clicks on "Savings" link on the Account Summary page
    Then the "Account Activity" should be displayed
    And Account drop down should have "Savings" selected

  @AC2
  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on Account Summary page
    Then the "Account Activity" should be displayed
    And Account drop down should have "Brokerage" selected now

  @AC3
  Scenario:Checking account redirect
    When the user clicks on	"Checking" link on the Account Summary page
    Then the "Account Activity" should be displayed
    And Account drop down should have "Checking" be selected

  @AC4
  Scenario: Credit card account redirect
    When the user clicks on	"Credit" card link on the Account Summary page
    Then the "Account Activity" should be displayed
    And Account drop down should have "Credit Card" should be selected

  @AC5
  Scenario: Loan Account redirect
    When the user clicks on	"Loan Link" on the Account Summary page
    Then the "Account Activity" should be displayed
    And Account drop down should have "Loan" should selected