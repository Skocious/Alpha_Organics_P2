Feature: Customer can purchase the item and from the item list.

  Scenario Outline: Customer can purchase the item and from the item list.
    Given I am on customer home page
    When I enter the "<ItemID>" into the ItemId input bar
    When I click the buy now button
    Then I bought an item



    Examples:
      | ItemID |
      | 10 |


  Scenario: As a Customer, I want to log out of my account
    When I click the logout button
    Then I logout successfully and got back to the Login page