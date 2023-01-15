Feature: Testing List Users Reqres API
  @Tugas @PositiveCase
  Scenario Outline: Get list users with valid parameter page reqres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |
      | 6    |
      | 7    |
      | 8    |
      | 9    |
      | 10   |
      | 11   |
      | 12   |

  @Tugas @PositiveCase
  Scenario Outline: Get single user with valid parameter id reqres API
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 200
    And Validate json schema single user
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
      | 5  |

#    get single user not found

  @Tugas @NegativeCase
  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid page "<page>"
    When Send request get list user
    Then Should return status code 404
    Examples:
      | page  |
      | 1$##$ |
      | @@&#^ |

  @Tugas @NegativeCase
  Scenario Outline: Get list single user not found
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 404
    And Validate json schema single user not found
    Examples:
      | id |
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
