Feature: Login API Authentication

  Scenario: Successful login with valid credentials
    Given the API endpoint "/api/authenticate" is available
    When I send a POST request with username "admin" and password "admin"
    Then the response status code should be 200
    And the response should contain an authentication token

  Scenario: Login fails with invalid password
    Given the API endpoint "/api/authenticate" is available
    When I send a POST request with username "admin" and password "wrongpass"
    Then the response status code should be 401
    And the response should contain "Bad credentials"

  Scenario: Login fails with empty payload
    Given the API endpoint "/api/authenticate" is available
    When I send a POST request with empty credentials
    Then the response status code should be 400
    And the response should contain "error.validation"

  Scenario: Login with SQL Injection attempt
    Given the API endpoint "/api/authenticate" is available
    When I send a POST request with username "' OR '1'='1" and password "admin"
    Then the response status code should be 401
    And the response should contain "Bad credentials"
