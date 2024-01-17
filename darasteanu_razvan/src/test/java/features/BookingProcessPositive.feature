Feature: Booking Process

  Background: Precondition to be on Login page and having a valid account
#    Given Be on Login Page

  Scenario: Complete Booking Process
    Given Be on Login Page
    When I enter username "BookingLoginTest@yahoo.com"
    And I enter password "7hkSG7RERiZ2neK"
    And I click on the login button
    And I click on the "Hotel Iasi" image
    And I click on the room "dubla" image
    And I select "Darasteanu Razvan" as the main contact person
    And I click on the first "Next step" button
    And I select room "dubla"
    And I enter check-in date "01/05/2024"
    And I enter check-out date "01/06/2024"
    And I click on the second "Next step" button
    And I enter 0 in the field "What is the number of people eating breakfast?"
    And I enter 0 in the second field "What is the number of pets?"
    And I click on the third "Next step" button
    When I select "credit card" as the payment option
    And I click on the fourth "Next step" button
    And I click on the "Book holiday" button
    Then I should see the booking message!


  Scenario Outline: Booking a Hotel Room using DataTables
    Given User is on Login Page
    When Enter username "<username>"
    And Enter password "<password>"
    And Click on the Login button
    And Click on hotel image with map
      | hotelName | Hotel Iasi |
    And Click on room image with map
      | roomName | dubla |
    And Select main contact person
      | Field             | Value |
      | mainContactPerson | Darasteanu Razvan |
    And Click on first next step button
    And Fill the second booking form with map
      | roomType     | dubla      |
      | checkInDate  | 01/05/2024 |
      | checkOutDate | 01/06/2024 |
    And Click on second next step button
    And Fill People eating breakfast and number of pets with map
      | breakfastsPerDay | 1 |
      | numberOfPets     | 1 |
    And Click on third next step button
    And I select payment option from list
      | <payment option> |
    And Click on fourth next step button
    And Click on book holiday button with map
      | buttonName | Book holiday |
    And Check if booking message is displayed
    Then The booking message should be displayed!

    Examples:
      | username  | password  | payment option      |
      | default   | default   | bank transfer       |
      | default   | default   | credit card         |
      | user3     | pass3     | pay at the property |


  @OneStep
  Scenario: Booking in one step
    When Making the booking process in one step
    Then I should see the booking message!

