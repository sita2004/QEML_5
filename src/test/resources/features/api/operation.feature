Feature: Operation API

  Scenario: Successful retrieval of operations
    Given the API endpoint "/api/operations" is up and running
    When I send a GET request to "/api/operations"
    Then the response should be status code of 200
  Scenario: Successful creation of new operation
    Given the API endpoint "/api/operations" is up and running
    When I send a POST request with amount "200" description "My Account", and today's date and time to to "/api/operations"
    Then the response should be status code of 201
