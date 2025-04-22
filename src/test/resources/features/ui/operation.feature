Feature: Operation Page UI Functionality

  Background:
    Given I login with valid credentials in login page

  Scenario: Create a new operation
    When I navigate to the Operation Page
    And I click on the Create button
    Then the form should be visible

  Scenario: Enter details and save the operation
    When I navigate to the Operation Page
    And I click on the Create button
    And I enter amount "1000"
    And I enter description "Salary Credit"
    And I click the Save button
    Then I should be redirected to the Operation listing page

  Scenario: Cancel the operation form
    When I navigate to the Operation Page
    And I click on the Create button
    And I enter amount "200"
    And I enter description "Cancel Test"
    And I click the Cancel button
    Then I should be redirected to the Operation listing page

  Scenario: Check visibility of action buttons
    When I navigate to the Operation Page
    Then the View button should be visible
    And the Edit button should be visible
    And the Delete button should be visible
