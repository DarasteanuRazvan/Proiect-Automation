@API
Feature: API Booking Process

  Background: Precondition to have a base URI and a valid account

    Given I have a base URI "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi"

  @APIPositive
  Scenario: Login Step using POST request

    When I set the login URL as "/auth/login"
    And I set the request body as "{ \"email\": \"BookingLoginTest@yahoo.com\", \"password\": \"7hkSG7RERiZ2neK\" }"
    And I send a POST request to the login URL
    And the first response status code should be 200
    Then I extract the access token

  @APIPositive
  Scenario: Click on Hotel Iasi Image Step using GET request

    When I set the hotel URL as "/hotels/4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"
    And  I set the access token header
    When I send a GET request to the hotel URL
    And  the second response status code should be 200
    Then the first response body should have property "id" with value "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"

  @APIPositive
  Scenario: Click on Room "tripla" Step using GET request

    When I set the room URL as "/_next/data/vnIJtE9hmxKQH6ElLfLkx/reserve-room/4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a.json"
    And I set the parameter "id" as "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"
    And I send a GET request to the room URL
    And the third response status code should be 200
    Then the second response body should have property "pageProps.id" with value "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"

  @APIPositive
  Scenario: Logout Step using POST request

    When I set the logout URL as "/auth/logout"
    And I send a POST request to the logout URL
    Then the fourth response status code should be 200

  @ApiCaller
  Scenario: Bonus: Api Caller in one step

    When I make an API request
    Then I should receive a response from the server!
