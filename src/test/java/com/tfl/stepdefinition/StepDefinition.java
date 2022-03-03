package com.tfl.stepdefinition;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Assert;

import com.tfl.common.library.BaseClass;
import com.tfl.objects.PageObjects;
import com.tfl.utilitymethods.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {

	@Given("I launch TFL Plan a journey Widget")
	public void i_launch_TFL_Plan_a_journey_Widget() throws IOException {
		BaseClass ob = new BaseClass();
	}

	@When("I click on {string} on the cookies pop up screen")
	public void i_click_on_cookies_pop_up(String text) throws IOException {
		try {
			Utilities.takeScreenshots();
			Assert.assertTrue(PageObjects.clickonAcceptCookies(text));
			System.out.println("Cookies are accepted");
		} catch (AssertionError e) {
			System.out.println("Cookies are not accepted due to::" + e.getMessage());
		}
	}

	@Then("I can able to view {string} screen")
	public void i_can_view_screen(String text) throws IOException {
		try {
			Assert.assertTrue(PageObjects.checkPageHeaderVisibiltiy(text));
			Utilities.takeScreenshots();
			System.out.println(text + " " + "Screen is visible");
		} catch (AssertionError e) {
			Utilities.takeScreenshots();
			System.out.println(text + " " + "Screen is not visible" + e.getMessage());
		}
	}

	@When("I click on below element")
	public void i_click_on_below_element(DataTable datatable) throws IOException {
		for (int i = 0; i < datatable.height(); i++) {
			switch (datatable.cell(i, 1)) {
			case "Button":
				try {
					Assert.assertTrue(PageObjects.javaScriptClick(datatable.cell(i, 0)));
					Utilities.takeScreenshots();
					System.out.println(datatable.cell(i, 0) + " " + "clicked");
				} catch (AssertionError e) {
					Utilities.takeScreenshots();
					System.out.println(datatable.cell(i, 0) + " " + "is not clicked" + e.getMessage());
					Assert.fail();
				}
			}
		}
	}

	@Then("I get below error message")
	public void i_got_below_error_message(DataTable datatable) throws IOException {
		String passedFields = "", failedFields = "";
		boolean flag = false;
		for (int i = 0; i < datatable.height(); i++) {
			if (datatable.cell(i, 1).equalsIgnoreCase("From field error")) {
				try {

					Assert.assertTrue(PageObjects.validateFromErrorMsg(datatable.cell(i, 0)));
					Utilities.takeScreenshots();

					passedFields += datatable.cell(i, 1) + "\n";

				} catch (AssertionError e) {
					failedFields += datatable.cell(i, 1) + "\n";
					Utilities.takeScreenshots();
					flag = true;
				}

			} else if (datatable.cell(i, 1).equalsIgnoreCase("To field error")) {
				try {
					Assert.assertTrue(PageObjects.validateToErrorMsg(datatable.cell(i, 0)));
					Utilities.takeScreenshots();
					passedFields += datatable.cell(i, 1) + "\n";

				} catch (AssertionError e) {
					failedFields += datatable.cell(i, 1) + "\n";
					Utilities.takeScreenshots();
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

	@And("I close the browser")
	public void i_close_the_browser() {
		Utilities.closeBrowser();
	}

	@And("I select from destination as {string}")
	public void i_select_from_destination(String destToSel) {

		PageObjects.selectFromDestination(destToSel);
	}

	@Then("I select to destination as {string}")
	public void i_select_to_destination_as(String destToSel) {
		PageObjects.selectToDestination(destToSel);
	}

	@And("I verify journey details have been shown")
	public void i_verify_journey_details_have_been_shown() {
		if (PageObjects.verifyJourneyDetailsContainer()) {
			System.out.println("Journey is planned successfully");
		} else {
			System.out.println("Journey is not planned successfully");
			Assert.fail();
		}
	}

	@When("i click on plan a journey on journey details screen")
	public void i_click_on_plan_a_journey() {
		PageObjects.clickOnPlanAJourney();
	}

	@Then("I am not able to view {string} screen")
	public void i_am_not_able_to_view_screen(String headerName) {
		if(PageObjects.verifyPageTitleNotVisible(headerName)) {
			System.out.println("Journey Details page is getting displayed");
			Assert.fail();
		}
		else
			System.out.println("Journey Details page is not getting displayed");
	}

}
