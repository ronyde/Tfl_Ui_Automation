Feature: TFL able to plan journey with valid input

  
  #We can have multiple data set here under examples to run the scripts
  Scenario Outline: Plan your journey with valid input
    Given I launch TFL Plan a journey Widget
    When I click on "Accept all cookies" on the cookies pop up screen
    Then I can able to view "Plan a journey" screen
    And I select from destination as "<first from location>"
    And I select to destination as "<first to location>"
    When I click on below element
      | Plan my journey | Button |
    Then I can able to view "Journey results" screen
    And I verify journey details have been shown
    When i click on plan a journey on journey details screen
    Then I can able to view "Plan a journey" screen
    And I select from destination as "<second from location>"
    And I select to destination as "<second to location>"
    When I click on below element
      | Plan my journey | Button |
    Then I can able to view "Journey results" screen
    And I verify journey details have been shown

    Examples: 
      | test_type | first from location              | first to location | second from location             | second to location |
      | tfl       | Wembley Park UnderGround Station | Wembley Central   | Wembley Park UnderGround Station | Chiswell Street    |
