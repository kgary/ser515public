Feature: Compute a Square Root
  As a user
  I want to compute a square root
  So that I can get my ICA credit!

  Scenario: Compute a value when both operands are positive
    Given I have an integer "3"
    When I compute the square root
    Then I should return a positive number

