Feature: Login Page
  Background:
    Given User is on Login page
  Scenario: Login with valid credentials
    When User enters valid credentials the username "nabil" and the password "test"
    Then The main page is displayed
  Scenario: Login with invalid credentials
    When User enters invalid credentials the username "aaa" and the password "bbb"
    Then The Login screen should display "Les identifications sont erronées"