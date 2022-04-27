Feature: As a Producer, I want to login to add products so that I can sell products
  Scenario: As a Producer, I want to login to add products so that I can sell products
  GIVEN I am on the Alpha Organics home page
  WHEN I click on Producers Login link
  WHEN I enter my username
  WHEN I enter my password
  WHEN I click the Login button
  THEN I am redirected to the Producers page

Feature: As a Producer, I want to add items to my inventory
  Scenario: As a Producer, I want to add items to my inventory
  GIVEN I am on Producers home page
  WHEN I enter the item id in to the item id field
  WHEN I enter the item description in to the item description field
  WHEN I enter a price in to the price field
  WHEN I click the item submit button
  THEN I can post an item to sell


Feature:   As a Producer, I want to delete an item
  Scenario: As a Producer, I want to delete an item
  GIVEN I am on Producers home page
  WHEN I enter a valid item number in to the cancel item field
  WHEN I click the delete button
  THEN I can delete the item


Feature: As a Producer, I want to log out of my account
  Scenario: As a Producer, I want to log out so that my account is secure
  GIVEN I am on the Alpha Organics Producers home page
  WHEN I click on Log out button
  THEN I am redirected to the Producers Login page