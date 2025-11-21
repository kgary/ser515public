Feature: Compute a Square
  As a user
  I want to compute a square
  So that I can get my ICA credit!

  Scenario: Compute a value when both operands are negative
    Given I have an integer "-33"
    When I compute the square
    Then I should return a positive number

