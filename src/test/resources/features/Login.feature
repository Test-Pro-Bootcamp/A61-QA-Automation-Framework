Feature:Login feature

  Scenario: Login Scenario to the Application
    Given I open the Login Page
    When   I Enter the Email "Shuban.laddu@gmail.com"
    And    I Enter the Password "Pavani@10"
    And    I click the Submit
    Then   I Logged in to the Application

  Scenario: Negative  Login Scenario to the Application
    Given I open the Login Page
    When   I Enter the Email "<email>"
    And    I Enter the Password "<password>"
    And    I click the Submit
    Then   I should not get  Logged in to the Application
             |email      | password|
             |invalid@gmail.com|Pavani@10|
             |valid@gmail.com  |         |
             |                 | Pavani@10|
             |Shuban.laddu@gmail.com|invalid@12|

