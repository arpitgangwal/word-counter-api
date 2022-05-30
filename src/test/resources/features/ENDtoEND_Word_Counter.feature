@HAPPY_SCENARIO
Feature: End to End Word Counter Flow
Description: The purpose of this test is to test happy flow of Word Counter Api
  
  Background: User generates token for Authorisation
    Given I am an authorized user "user1"

  Scenario: the Authorized user can add word and get count.

    When I add word list

    Then word is added

    When I want to know count of word "abc"

    Then result contain more then one word count for alphabetic word "abc"

    When I want to know count of word "$abc"

    Then result don't contain any count for non alphabetic word "$abc"


