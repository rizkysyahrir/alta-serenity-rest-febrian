Feature: Testing create user with Reqres API
  As a user want to create user

  @Tugas @PositiveCase
  Scenario Outline: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "<name>" and job "<job>"
    And Validate json schema create user
    Examples:
      | name            | job       |
      | Febrian Syahrir | QA Leader |

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400