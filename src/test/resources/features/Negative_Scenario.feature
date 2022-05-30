@UnAuthorized_SCENARIO
Feature: When we dont pass JWT token in any request
Description: The purpose of this test is to test negative flow without passing jwt token

  Scenario: the Authorized user can add word and get count.

    When I add word list without passing jwt

    Then Unauthorized exception will occur

    When I want to know count of any word without pass jwt

    Then Unauthorized exception will occur



