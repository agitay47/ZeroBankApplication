@Login
Feature: As I user I should be able to login vith valid credentials

  Scenario Outline: Login with username and password
    Given User on login page
    When User login with '<username>' and '<password>'
    Then user should be on "main page"
    Examples:
      | username | password |
      | username | password |
