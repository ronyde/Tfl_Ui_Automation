Feature: TFL able to see journeys in recent journeys section

  Scenario Outline: TFL able to see journeys in recent journeys section
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
    Then I click on recents tab
    And I verify recent journey details using "<first from location>" and "<first to location>"
    And I close the browser

    Examples: 
      | test_type | first from location              | first to location |
      | tfl       | Wembley Park UnderGround Station | Wembley Central   |
