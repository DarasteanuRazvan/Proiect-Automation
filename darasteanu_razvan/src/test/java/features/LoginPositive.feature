@UI
Feature: Login Positive Tests Scenarios

    Background: User is on Login Page and has a valid account
        Given User is on Login Page


    @Positive
    Scenario: Login with Required Fields on the Login Page
        When Enter username "default"
        And Enter password "default"
        And Click on the Login button
        Then Logout Button is displayed

    @Positive
    Scenario Outline: Login with Required Fields on the Login Page from Table
        When Enter username "<username>"
        And Enter password "<password>"
        And Click on the Login button
        Then Logout Button is displayed
        Examples:
            | username    | password  |
            | default     | default   |

    @Positive
    Scenario Outline: Login with Required Fields on the Login Page from DataTable
        When User puts credentials from list
            | <username> |
            | <password> |
        And Click on the Login button
        Then Logout Button is displayed

        Examples:
            | username   | password |
            | default    | default  |

    @Positive
    Scenario: Log in in single step
        When Login with username "default" and password "default"
        Then Logout Button is displayed



