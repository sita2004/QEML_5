Feature: Login Page UI Testing

  Scenario: Login page loads successfully
    Given I open the login page
    Then I should see the login form with username and password fields
    And I should see the "Sign in" button

  Scenario: User logs in with valid credentials
    Given I open the login page
    When I enter username "admin" and password "admin"
    And I click on the "Sign in" button
    Then I should see a login success message "You are logged in as user \"admin\"."

  Scenario: User submits empty form
    Given I open the login page
    When I click on the "Sign in" button
    Then I should remain on the login page
#    And I should see a validation message "Please check your credentials and try again."

  Scenario: User enters invalid credentials
    Given I open the login page
    When I enter username "admin" and password "wrongpass"
    And I click on the "Sign in" button
    Then I should remain on the login page
#    And I should see an error message "Please check your credentials and try again."
  Scenario: Password is hidden by default
    Given I open the login page
    Then the password field should be of type "password"

  Scenario: "Remember Me" checkbox works
    Given I open the login page
    When I select the "Remember me" checkbox
    Then the checkbox should be selected
