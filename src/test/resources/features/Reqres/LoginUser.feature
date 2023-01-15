Feature: Testing Login User Reqres API
  As a User i want to login
  @Tugas @PostiveCase
  Scenario: Post login users with valid email and password
    Given Post login user with valid json
    When Send request post login user
    And Response body token should be "QpwL5tke4Pnpja7X4"
    Then Should return status code 200
    And Validate json schema login user

  @Tugas @NegativeCase
  Scenario: Post login user with invalid email
    Given Post login user with invalid json
    When Send request post login user
    Then Should return status code bad request 400
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate json schema login user

  @Tugas @NegativeCase
  Scenario: Post login user with invalid json schema
    Given Post login user without pass invalid json
    When Send request post login user
    Then Should return status code bad request 400
    And Response body error should be "Missing password"
    And Validate json schema login unsuccessfully