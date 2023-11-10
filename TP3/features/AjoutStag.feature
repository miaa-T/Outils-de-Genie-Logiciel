Feature: AjoutStagiaire
  Background:
    Given User is on Home page
    When User clicks on "Nouveau Stagiaire"
  Scenario: Fill all the form
    And User enters the stagiaire details
    And User submits the form
    Then User sees the "Modifier" link indicating successful addition
  Scenario: Fill al the form except firstname and lastname
    And User enters the stagiaire details except firstname and lastname
    And User submits the form
    Then User sees two error messages