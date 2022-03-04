Feature: TFL unable to plan journey with invalid details

  Scenario Outline: TFL unable to plan journey with invalid details
    Given I launch TFL Plan a journey Widget
    When I click on "Accept all cookies" on the cookies pop up screen
    Then I can able to view "Plan a journey" screen
    And I select from destination as "<first from location>"
    And I select to destination as "<first to location>"
    When I click on below element
      | Plan my journey | Button |
    Then I can see "Sorry, we can't find a journey matching your criteria" error message
    And I close the browser

    Examples: 
      | test_type | first from location | first to location |
      | tfl       | zzzzzzzzzzz         | zzzzzzzzzzzzzzz   |
