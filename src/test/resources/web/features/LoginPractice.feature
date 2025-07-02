@Login
Feature: Login

  Background:
    Given The client is on automation practice page
    And user clicks on "My Account Menu"

#  @SuccessfulLogin
#  Scenario Outline: Successful Login
#    Given user enters as username <username>
#    And user enters as login password <password>
#    And user clicks on "Login" button
#    Then user will login successfully
#
#    Examples:
#      | username                      | password      |
#      | francoasplanatti57@gmail.com  | prueba4860    |

  @FailedLogin
#  Scenario Outline: Failed Login
#    Given user enters as username <username>
#    And user enters as login password <password>
#    And user clicks on "Login" button
#    Then login must fail with a warning message <error>
#
#    Examples:
#      | username                      | password   | error                  |
#      | fff@fff.com                   | prueba4860 | Error: A user could not be found with this email address.    |
#      |                               | prueba4860 | Error: Username is required.  |
#      | francoasplanatti57@gmail.com  |            | Error: The password field is empty.       |
#      |                               |            | Error: Username is required. |
#      | FRANCOASPLANATTI57@GMAIL.COM  | PRUEBA4860 | Error: The password you entered for the username FRANCOASPLANATTI57@GMAIL.COM is incorrect. Lost your password?  |

#    @Logout
#    Scenario Outline: Authentication fails after logout
#    Given user enters as username <username>
#    And user enters as login password <password>
#    And user clicks on "Login" button
#    Then user will login successfully
#      When user clicks on "Logout" link
#      And user navigates back
#      Then user should see the account login page
#
#    Examples:
#      | username                      | password   |
#      | francoasplanatti57@gmail.com  | prueba4860 |

    @AccountDetails
    Scenario Outline: View account details
      Given user enters as username <username>
      And user enters as login password <password>
      And user clicks on "Login" button
      Then user will login successfully
      When user clicks on "Account Details"
      Then user should see the account details
    Examples:
      | username                      | password   |
      | francoasplanatti57@gmail.com  | prueba4860 |
