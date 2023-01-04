Feature: Category feature
  I want to use this template testing category endpoint

  @tag1
  Scenario: I want to get the whole category records
    Given The category base URL is invoked
    When Request a GET method to return full category record
    Then The status code should be 200 to read all ctegory

