package com.tfl.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.tfl.common.library.BaseClass;
import com.tfl.objects.PageObjects;
import com.tfl.utilitymethods.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {

	@Given("I launch TFL Plan a journey Widget")
	public void i_launch_TFL_Plan_a_journey_Widget() throws IOException {
		BaseClass ob = new BaseClass();
	}

	@When("I click on {string} on the cookies pop up screen")
	public void i_click_on_cookies_pop_up(String text) {
		try {
			Assert.assertTrue(PageObjects.clickonAcceptCookies(text));
			System.out.println("Cookies are accepted");
		} catch (AssertionError e) {
			System.out.println("Cookies are not accepted due to::" + e.getMessage());
		}
	}

	@Then("I can able to view {string} screen")
	public void i_can_view_plan_a_journey_screen(String text) {
		try {
			Assert.assertTrue(PageObjects.checkPlanJourneyVisibiltiy(text));
			System.out.println("Plan a Journey Screen is visible");
		} catch (AssertionError e) {
			System.out.println("Plan a Journey Screen is not visible due to::" + e.getMessage());
		}
	}

}
