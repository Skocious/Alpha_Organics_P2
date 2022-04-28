Feature: Customer can purchase the item and from the item list.

  Scenario Outline:
    Given I am on customer home page
    When I enter the "<ItemID>" into the ItemId input bar
    When I click the buy now button
    When I click the logout button
    Then I logout successfully and got back to the Login page

    Examples:
      | ItemID |
      | 10 |