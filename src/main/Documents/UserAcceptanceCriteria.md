#Acceptance Criteria - CUSTOMERS
###Scenario: As a customer, I want to login to add products to my cart so that I can purchase products.
- GIVEN: I am on the Alpha Organics home page,
- WHEN: I enter my username,
- WHEN: I enter my password,
- WHEN: I click the Login button,
- THEN: I can view the products on that page.
###Scenario: As a customer, I want to log in BUT I mess up my username and/or password.
- GIVEN: I am on the Aalpha Organics home page,
- WHEN: I enter my username,
- WHEN: I enter my password but incorrectly,
- WHEN: I click the Login button,
- THEN: I get a popup that tells me my username and/or password is incorrect.
###Scenario: As a customer, I want to log out once I am done shopping.
- GIVEN: I am on the shopping home page,
- WHEN: I click the Logout button,
- THEN: I am directed to the site home page.
###Scenario: As a customer, I want to view items in the shopping home page.
- GIVEN: I am successfully logged in,
- WHEN: I am on the customer home page,
- THEN: I can view all the items available.
###Scenario: As a customer, I want to add items into the cart.
- GIVEN: I am successfully logged in,
- WHEN: I am on the customer home page,
- WHEN: I can view all the items,
- WHEN: I can select the item that I want,
- WHEN: I click add to cart,
- THEN: I can see the item in the cart.
###Scenario: As a Customer, I want to remove items from the cart.
- GIVEN: I am on  the shopping home page,
- WHEN: I am successfully logged in,
- WHEN: I can view all the items,
- WHEN: I can select the item that I want,
- WHEN: I click add to cart,
- WHEN: I see the item in the cart,
- WHEN: I click the remove button near the item,
- THEN: I can remove that item.
