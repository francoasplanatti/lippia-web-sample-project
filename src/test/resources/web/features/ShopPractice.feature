@Smoke
@Shop
Feature: Shop

  Background:
    Given The client is on automation practice page
    And user clicks on "Shop"

  @DefaultSorting
  Scenario Outline: Sort by <sorting>
    Given user selects <sorting>
    Then user must see the top element <top>

    Examples:
      | sorting             | top                               |
      | popularity          | Android Quick Start Guide         |
      | average rating      | Selenium Ruby                     |
      | newness             | HTML5 WebApp Develpment           |
      | price: low to high  | JS Data Structures and Algorithm  |

  @Purchase
  Scenario: Item purchase and checkout
    When user clicks on "Shop" menu
    And user clicks on "Add to basket"
    Then the book should appear in cart with price
    When user clicks on "View Basket"
    Then verify subtotal is less than total
    When user clicks on "Proceed to Checkout"
    Then user should see the billing details
    When user fills billing details
    And user chooses "Direct Bank Transfer" as payment method
    And user clicks on "Place order"
    Then order confirmation page should be displayed

  @TaxVerification
  Scenario Outline: Verify tax functionality based on country
    When user clicks on "Add to basket"
    And user clicks on "View Basket"
    Then verify subtotal is less than total
    And user clicks on "Proceed to Checkout"
    When user enters in the "Billing Country" field <Country>
    Then the tax rate should be 2% for India or 5% for other country
    Examples:
      | Country    |
      | India      |
      | Argentina  |
      | France     |