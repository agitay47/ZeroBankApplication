@Currency
Feature: Purchase Foreign Currency

  Background: Common Steps
    Given the user is logged in
    And user click on "Pay Bills" module
    And user clicks on "Purchase Foreign Currency"

  @AC1
  Scenario: Available currencies
    And the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @AC2
  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @AC3
  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed