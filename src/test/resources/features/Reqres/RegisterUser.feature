Feature: Testing Register Users Reqres API
  As a user i can register with post method

  @Tugas @PositiveCase
  Scenario: Post register users with valid parameter page reqres API
    Given Register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register user

  @Tugas @NegativeCase
  Scenario: Post register user with invalid json reqres API
    Given Register user with invalid json
    When Send request post register user
    Then Should return status code 400
    And Response body error should be "Missing password"
    And Validate json schema failed register user