@Smoke
Feature: Database Operations

  Scenario: Create a hotel
    Given I create a hotel
    Then the hotel should be created!

  Scenario: Read a hotel
    When I read the hotel
    Then the hotel should be found!

  Scenario: Update a hotel
    When I update the hotel
    Then the hotel should be updated!

  Scenario: Delete a hotel
    When I delete the hotel
    Then the hotel should be deleted!

  @DatabaseCaller
  Scenario: Using Database Caller
    When I execute a SQL query
    Then I receive a result from that query


