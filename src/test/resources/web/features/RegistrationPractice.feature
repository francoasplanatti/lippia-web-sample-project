@Smoke
@Registration
Feature: Registration

  Background:
    Given The client is on automation practice page
    And user clicks on "My Account Menu"

  @SuccessfulRegistration
  Scenario Outline: Successful Registration
    Given user enters as email <email>
    And user enters registration password <password>
    And user clicks on "Register" button
    Then user will be registered successfully
    And user will be navigated to the Home Page

    Examples:
      | email                           | password   |
      | franco.asplanatti@gmail.com     | prueba4860 |
      | franco.asplanatti@uner.edu.ar   | prueba4860 |

  @FailedRegistration
  Scenario Outline: Failed Registration
    Given user enters as email <email>
    And user enters registration password <password>
    And user clicks on "Register" button
    Then user will fail registration with <error>

    Examples:
      | email                           | password   | error                                        |
      | francoasplanatti@hotmail.com    |            | Error: Please enter an account password.     |
      |                                 |            | Error: Please provide a valid email address. |