Feature: Mailchimp test
  In order to sign up different user i want to everything to run smooth.

  @mytag
  Scenario: Sign up account
    Given I have entered my <email>
    Given I have also selected a <username>
    And I have also selected a <password>
    When I press sign up
    Then the <result> should be on the screen