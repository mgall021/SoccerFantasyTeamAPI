Feature: Rest API functionalities
  Scenario: User able to get a list of soccer players
    Given A list of soccer players are available in the database
    When The user requests to get a list of soccer players
    Then The system should respond with a list of soccer players
    When The user requests to get soccer players by name
    Then The system should return a list of soccer players with the matching name
    When The user requests to get a soccer player by ID
    Then The system should return the soccer player with the specified ID
    When The user requests to get soccer players by position
    Then The system should return a list of soccer players by position
    When The user requests to get soccer players by team
    Then The system should return a list of soccer players by team
    When The user requests to get soccer players by country
    Then The system should return a list of soccer players by country
