Feature: Vrify Books API

  @AddBook
  Scenario Outline: Verify add book API
    Given Add book api payload with "<name>" "<isbn>" "<aisle>" "<author>"
    When The user executes "AddBookAPI" with "POST" request
    Then the user is returned with status code 200
    And the "Msg" in response body is "successfully added"

    Examples: 
      | name  | isbn  | aisle | author |
      | Book1 | mntd5 |     1 | manish |
      | Book2 | mntd5 |     2 | manish |
      | Book3 | mntd5 |     3 | manish |

  @DeleteBook
  Scenario Outline: Verify delete book API
    Given Delete book api payload
    When The user executes "DeleteBookAPI" with "POST" request
    Then the user is returned with status code 200
    And the "msg" in response body is "book is successfully deleted"
