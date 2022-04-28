Feature: Producer can login into the Alpha Organics Website.

  Scenario Outline:
    Given I am on the Producer login home page
    When I enter "<loginName>" into the producer login input bar
    When I type out "<password>" into the producer password input bar
    When I click the producer login button
    Then I should be on producer home page

    Examples:
      | loginName | password |
      | producer1 | 111one |