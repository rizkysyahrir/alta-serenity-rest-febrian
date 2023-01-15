Feature: Testing Reqres API ALTA QE8

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Febrian Syahrir" and job "QA Leader"

  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Febrian Syahrir" and job "QA Leader"
