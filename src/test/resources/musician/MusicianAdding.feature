Feature: Musician Adding
  As a Developer
  I want to add a Musician through API
  So that it can be available to applications.

  Background:
    Given The Endpoint "http://localhost:%d/api/v1/musicians" is available

  @musician-adding
  Scenario: Add Musician
    When a Post Request is sent with values "James Bond", "jamesb@gmail.com", 965745321.
    Then A Response with Status 200 is received
    And an Musician Resource with values 1, "James Bond", "jamesb@gmail.com", 965745321 is included in Response Body

  @musician-duplicated
  Scenario: Add Musician with existing Email
    Given a Musician Resource with values "James Bond", "jamesb@gmail.com", 965745321 is already stored
    When A Post Request is sent with values "James Bond", "jamesb@gmail.com", 965745321
    Then A Response with Status 400 is received
    And A Message with value "A Musician with the same Email already exists." is included in Response Body
