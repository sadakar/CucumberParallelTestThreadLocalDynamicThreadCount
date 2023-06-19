#Author: Sadakar Pochampalli
@LoginFeature
Feature: Login page validations

  Background: 
    Given User is on login page

  @Login
  Scenario: Login to Orange HRM
    When User enters username "Admin"
    And User enters password "admin123"
    And User clicks on Login button
    Then User should navigate to Orange HRM home page

  @ForgotPassword
  Scenario: Forgot password link verification
    Then User verifies Forgot password link display
