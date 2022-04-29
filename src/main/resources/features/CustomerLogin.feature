Feature: Customer can login into the Alpha Organics website.

  Scenario Outline: Customer can login into the Alpha Organics website.
    Given I am on the Login home page
    When I enter "<loginName>" into the customer login input bar
    When I type out "<password>" into the customer password input bar
    When I click the login button
    Then I should be on customer home page

    Examples:
      | loginName | password |
      | customer1 | one111 |