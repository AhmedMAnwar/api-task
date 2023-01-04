Feature: product feature
  I want to use this template for testing the product endpoint

  Scenario: I want to get the whole product records
    Given The base URL is invoked
    When Request a GET method to return full product record
    Then I verify the status code is 200

  Scenario: I want to get the prodcut called <Bamboo Thermal Ski Coat>
    Given The base URL is invoked
    When Request a GET method to search for id number 1
    Then I verify the product name is "Bamboo Thermal Ski Coat"

  Scenario: I want to create a new prodcut called <Water Bottle>
    Given The base URL is invoked
    When Request a POST method to creat product with data
    | name | description | price | category_id |
    | Water Bottle | Water Bottle. New Porduct for clients | 12 | 3 |
    Then I verify the responce message is "Product was created."

  Scenario: I want to update the prodcut id equals <18>
    Given The base URL is invoked
    When Request a PUT method to update product with data
    | id | name | description | price | category_id |
    | 18 | Water Bottle_1 | Water Bottle. New update in the Porcut for | 12 | 3 |
    Then I verify the responce message of update is "Product updated"

    Scenario: I want to delete the prodcut id equals <18>
    Given The base URL is invoked
    When Request a DELETE method to delete product with id 28
    Then I verify the responce message of deletion is "Product was deleted."