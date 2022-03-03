Feature: TFL unable to plan journey with no location input
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I launch TFL Plan a journey Widget
    When I click on "Accept all cookies" on the cookies pop up screen
    Then I can able to view "Plan a journey" screen
    When I click on below element
      | Plan my journey | Button |
    Then I get below error message
      | The From field is required. | From field error |
      | The To field is required.   | To field error   |
