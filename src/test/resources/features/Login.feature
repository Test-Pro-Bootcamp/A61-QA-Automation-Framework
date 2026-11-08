Feature: Login feature

  Scenario: Login Scenario
    Given I open Login page
    When I enter email "elena.dorogaia@testpro.io"
    And I enter password "te$terthegreat"
    And I submit
    Then I'm logged in


  Scenario Outline: Negative Login Scenario
    Given I open Login page
    When I enter email "<email>"
    And I enter password "<password>"
    And I submit
    Then I should not get logged in
    Examples:
      | email              | password       |
      | invalid@testpro.io | te$terthegreat |
      | valid@testpro.io   | invalidPass    |
      | valid@testpro.io   |                |
      |                    | te$terthegreat |