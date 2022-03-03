$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Test2.feature");
formatter.feature({
  "name": "TFL unable to plan journey with no location input",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "I launch TFL Plan a journey Widget",
  "keyword": "Given "
});
formatter.match({
  "location": "com.tfl.stepdefinition.StepDefinition.i_launch_TFL_Plan_a_journey_Widget()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Accept all cookies\" on the cookies pop up screen",
  "keyword": "When "
});
formatter.match({
  "location": "com.tfl.stepdefinition.StepDefinition.i_click_on_cookies_pop_up(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can able to view \"Plan a journey\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "com.tfl.stepdefinition.StepDefinition.i_can_view_plan_a_journey_screen(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on below element",
  "rows": [
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.tfl.stepdefinition.StepDefinition.i_click_on_below_element(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get below error message",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.tfl.stepdefinition.StepDefinition.i_got_below_error_message(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
});