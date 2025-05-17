Feature: Bank Account API Testing

  Scenario: Get all bank accounts with valid Bearer token
    Given the API endpoint "/api/bank-accounts" is up and running
    When I send a GET request to "/api/bank-accounts"
    Then the response should be status code of 200

  Scenario: Create a new bank account
    Given the API endpoint "/api/bank-accounts" is up and running
    When I send a POST request to "/api/bank-accounts" with name "sita" and balance 1500
    Then the response status code of 201


  Scenario: Delete a bank account by ID
    Given the API endpoint "/api/bank-accounts" is up and running
    When I send a DELETE request to "/api/bank-accounts/1068"
    Then the response status code of 204
