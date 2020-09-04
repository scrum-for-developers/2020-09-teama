Feature: Adding a new book to the library

  Scenario Outline: Adding a new book

    Given an empty library

    When a librarian adds a book with "<title>", "<author>", <edition>, "<year>", "<description>" and "<isbn>"
    And a librarian adds a book with "<title2>", "<author2>", <edition>, "<year>", "<description>" and "<isbn>"
    
    Then the booklist contains a book with "<title>", "<author>", "<year>", <edition>, "<description>" and "<isbn>"
    And the library contains <nr> copies of the book with "<isbn>"

    Examples:

      | isbn       | author          | title    | description        | edition | year | author2         | title2   | nr     |
      | 0552131075 | Terry Pratchett | Sourcery | Test Description 1 | 1       | 1989 | Jerry Pratchett | Sourcery | 1      |
      | 0552131075 | Terry Pratchett | Sourcery | Test Description 2 | 1       | 1989 |                 |          | 1      |
      | 0552131075 | Terry Pratchett | Sourcery | Test Description 3 | 1       | 1989 | Terry Pratchett | Sourcery | 2      |
      | 0552131075 | Terry Pratchett | Sourcery |                    | 1       | 1989 | Terry Pratchett | Mastery  | 1      |






