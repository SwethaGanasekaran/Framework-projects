#Author: swetha.domain.com

@tag
Feature: MobilePurchase
  I want to use this template for my feature file

  @tag1
  Scenario: MobilePurchase
    Given user to launch flipkart app
    And user able to login with credentials
    When user searching mobiles and choose one
    And add to cart the mobile and doing payment
    Then I validate the confirmation message
    
    