@cc
Feature: Calculator

  @C1 @Kalkulator
  Scenario: Add two numbers
    Given I have two numbers 5 and 3
    When I add them
    Then the result should be 8

  @C2
  Scenario: Subtract two numbers
    Given I have two numbers 10 and 4
    When I subtract them
    Then the result should be 6

  @C3
  Scenario: Multiply two numbers
    Given I have two numbers 6 and 7
    When I multiply them
    Then the result should be 42

  @C4
  Scenario: Divide two numbers
    Given I have two numbers 20 and 5
    When I divide them
    Then the result should be 4

  @C5
  Scenario: Division by zero
    Given I have two numbers 10 and 0
    When I divide them
    Then the result should be "undefined"
