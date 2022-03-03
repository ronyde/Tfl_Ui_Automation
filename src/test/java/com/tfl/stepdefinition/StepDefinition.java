package com.tfl.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.tfl.common.library.BaseClass;
import com.tfl.objects.PageObjects;
import com.tfl.utilitymethods.Utilities;

import io.cucumber.datatable.DataTable;
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

	@When("I click on below element")
	public void i_click_on_below_element(DataTable datatable) {
		for (int i = 0; i < datatable.height(); i++) {
			switch (datatable.cell(i, 1)) {
			case "Button":
				try {
					Assert.assertTrue(PageObjects.clickOnButton(datatable.cell(i, 0)));
					System.out.println(datatable.cell(i, 0) + " " + "clicked");
				} catch (AssertionError e) {
					System.out.println(datatable.cell(i, 0) + " " + "is not clicked" + e.getMessage());
					Assert.fail();
				}
			}
		}
	}

	@Then("I get below error message")
	public void i_got_below_error_message(DataTable datatable) {
		String passedFields = "", failedFields = "";
		boolean flag = false;
		for (int i = 0; i < datatable.height(); i++) {
			if (datatable.cell(i, 1).equalsIgnoreCase("From field error")) {
				try {
					Assert.assertTrue(PageObjects.validateFromErrorMsg(datatable.cell(i, 0)));

					passedFields += datatable.cell(i, 1)+"\n";

				} catch (AssertionError e) {
					failedFields += datatable.cell(i, 1)+"\n";
					flag = true;
				}

			} else if (datatable.cell(i, 1).equalsIgnoreCase("To field error")) {
				try {
					Assert.assertTrue(PageObjects.validateToErrorMsg(datatable.cell(i, 0)));

					passedFields += datatable.cell(i, 1)+"\n";

				} catch (AssertionError e) {
					failedFields += datatable.cell(i, 1)+"\n";
					flag = true;
				}

			}
		}
		if (!(passedFields.isEmpty())) {
			System.out.println("Error messages are displaying correctly for below fields");
			System.out.println(passedFields);
		}
		if (flag) {
			System.out.println("Error messages are not displaying correctly for below fields");
			System.out.println(failedFields);
			Assert.fail();
		}
	}

}
