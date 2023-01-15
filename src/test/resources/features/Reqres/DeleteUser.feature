Feature: Testing delete user Reqres API
  As a user i want delete user

  @Tugas @PositiveCase
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
    | id |
    | 1  |
    | 2  |