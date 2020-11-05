@PayBills
Feature: Add new payee under pay bills

  Background: Common Steps
    Given the user is logged in

  Scenario: Add a new payee
    And user click on "Pay Bills" module
    Then user clicks on "Add New Payee" sub module
    And creates new payee using following information

      |Payee Name    | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001        |
      |Account       | Checking                                |
      |Payee details | XYZ account                             |


    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

