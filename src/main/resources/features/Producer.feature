Feature: As a Producer, I want to add items to my inventory

  Scenario Outline: As a Producer, I want to add items to my inventory
    Given I am on Producers home page
    When I enter the "<itemId>" in to the item id field
    When I enter the "<itemDescription>" in to the item description field
    When I enter a "<price>" in to the price field
    When I click the item submit button
    Then I can post an item to sell

    Examples:
      | itemId | itemDescription | price | deleteField |
      | 1 | a | 10 | -3 |

  Scenario Outline: As a Producer, I want to delete an item
    When I enter a valid "<deleteField>" in to the cancel item field
    When I click the delete button
    Then I can delete the item

    Examples:
      | deleteField |
      | -3 |

  Scenario: As a Producer, I want to log out of my account
    When I click on producer Log out button
    Then I producer logout successfully and got back to the Login page

