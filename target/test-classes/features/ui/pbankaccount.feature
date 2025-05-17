Feature: Bank Account Page UI Tests

  Scenario: Login and navigate to Bank Account page
    Given I login with valid credentials and navigate to the Bank Account Page

  Scenario: Create a new Bank Account
    Given I login with valid credentials and navigate to the Bank Account Page
    When I click on the Create button on the Bank Account page
    Then the Bank Account form should be visible
    And I enter name "John Doe" and balance "1000"
    And I click the Save button on the Bank Account form
    Then I should be redirected to the Bank Account listing page

  Scenario: Cancel creating a new Bank Account
    Given I login with valid credentials and navigate to the Bank Account Page
    When I click on the Create button on the Bank Account page
    Then the Bank Account form should be visible
    And I enter name "Jane Doe" and balance "2000"
    And I click the Cancel button on the Bank Account form
    Then I should be redirected to the Bank Account listing page

  Scenario: View, Edit, and Delete Bank Account
    Given I login with valid credentials and navigate to the Bank Account Page
    And I click on the Create button on the Bank Account page
    And I enter name "Account1" and balance "5000"
    And I click the Save button on the Bank Account form
    Then I should be redirected to the Bank Account listing page
    And I should see the View button for the Bank Account
    And I should see the Edit button for the Bank Account
    And I should see the Delete button for the Bank Account
    When I click the Delete button for the Bank Account
    Then the Bank Account should be deleted and no longer visible in the listing
