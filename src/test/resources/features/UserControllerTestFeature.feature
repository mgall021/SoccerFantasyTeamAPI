
Feature: Rest API functionalities

  Scenario: User is manage account
    When I create an account
    Then I get a user account
    When I update the user account
    Then The user account is updated
    When I delete the user
    Then The user gets deleted

