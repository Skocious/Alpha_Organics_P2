Feature: Customer can purchase the item and from the item list.

  Scenario:
    Given I am on customer home page
    When I enter the <ItemId> into the ItemId input bar
    When I see the item in the item added to the cart
    When I click the buy now button
    When I see an alert item bought successfully
    When I click the logout button
    Then I logout successfully and got back to the Login page
