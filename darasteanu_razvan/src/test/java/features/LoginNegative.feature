Feature: Login negative tests scenarios

  Background: Precondition to be on Login Page and have am valid account
    Given User is on the Login Page

  @Negative
  Scenario: New login scenario with wrong username and correct password
    When User enters username "BookingLoginTest@yahoo.comm"
    And User enters password "7hkSG7RERiZ2neK"
    And User clicks on Login Button

    Then Error message is displayed

  @Negative
  Scenario: New login scenario with correct username and wrong password
    When User enters username "BookingLoginTest@yahoo.com"
    And User enters password "7hkSG7RERiZ2neKK"
    And User clicks on Login Button

    Then Error message is displayed

  @Negative
  Scenario: New login scenario with wrong username and wrong password
    When User enters username "BookingLoginTest@yahoo.comm"
    And User enters password "7hkSG7RERiZ2neKK"
    And User clicks on Login Button

    Then Error message is displayed

