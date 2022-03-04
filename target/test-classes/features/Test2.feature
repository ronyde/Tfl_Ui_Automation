Feature: TFL unable to plan journey with no location input
  I want to use this template for my feature file

  Scenario: TFL unable to plan journey with no location input
    Given I launch TFL Plan a journey Widget
    When I click on "Accept all cookies" on the cookies pop up screen
    Then I can able to view "Plan a journey" screen
    When I click on below element
      | Plan my journey | Button |
    Then I get below error message
      | The From field is required. | From field error |
      | The To field is required.   | To field error   |
    Then I am not able to view "Journey results" screen
    And I close the browser
