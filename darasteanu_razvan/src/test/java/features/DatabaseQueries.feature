@Database
Feature: Database Testing

  @Positive
  Scenario: Insert a new hotel into the database
    Given The hotel must be deleted from the database
    When I execute the insert query for a new hotel
    Then The new hotel should be inserted into the database
