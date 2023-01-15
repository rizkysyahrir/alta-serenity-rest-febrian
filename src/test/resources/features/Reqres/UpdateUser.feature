Feature: Testing update user Reqres API
  As a user i can update user with method put

  @Tugas @PositveCase
  Scenario: Put update user with valid json
    Given PUT update user with valid json with id 2
    When Send request PUT update user
    Then Should return status code 200
    And Response body name should be "Febrian Syahrir" and job "QA Leader"

  @Tugas @PositveCase
  Scenario: Patch update user with valid json
    Given PATCH update user with valid json with id 2
    When Send request PATCH update user
    Then Should return status code 200
    And Response body name should be "Febrian Syahrir" and job "QA Leader"