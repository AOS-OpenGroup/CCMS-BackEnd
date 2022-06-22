Feature: Studio Adding
  As a Developer
  I want to add an Studio through API
  So that it can be available to applications.

  Background:
    Given The Endpoint "http://localhost:%d/api/v1/studios" is available

  @studio-adding
  Scenario: Add Studio
    When a Post Request is sent with values "Studio 214 UPC", "La Molina", "jbond@gmail.com", "This studio is considered as one of the best in our city"
    Then A Response with Status 200 is received
    And an Studio Resource with values 1, "Studio 214 UPC", "La Molina", "jbond@gmail.com", "This studio is considered as one of the best in our city" is included in Response Body

  @studio-duplicated
  Scenario: Add Studio with existing Name
    Given an Studio Resource with values "Studio 214 UPC", "La Molina", "jbond@gmail.com", "This studio is considered as one of the best in our city" is already stored
    When A Post Request is sent with values "Studio 214 UPC", "La Molina", "jbond@gmail.com", "This studio is considered as one of the best in our city"
    Then A Response with Status 400 is received
    And A Message with value "An Studio with the same Name already exists." is included in Response Body
