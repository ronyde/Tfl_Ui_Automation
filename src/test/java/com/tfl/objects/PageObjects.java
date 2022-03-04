package com.tfl.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tfl.utilitymethods.Utilities;

public class PageObjects extends Utilities {

	public static String doneXpath = "//strong[text()='Done']/parent::button";
	public static String destFrom = "//input[@data-val-required='The From field is required.']";
	public static String destFromSel = "//span[@id='stop-points-search-suggestion-0']/parent::div";
	public static String destTo = "//input[@data-val-required='The To field is required.']";
	public static String journeyDetailsContainer = "//div[@class='to-results disambiguation-wrapper clearfix']";
	public static String journeyContainer = "//div[@class='disambiguation-box']//following-sibling::li/a";
	public static String verifyMsg = "//*[contains(text(),'Discover quieter times to travel.')]";
	public static String planaJourney = "(//a[text()='Plan a journey'])[1]/parent::li";
	

	public static boolean clickonAcceptCookies(String text) {
		// have done this so in future if the text(accept my cookies) changes we just
		// need to update the feature file and not the code
		String xpath = "//strong[text()='" + text + "']/parent::button";
		WebElement ele = checkVisibilityOfElement(xpath);
		if (ele.isDisplayed()) {
			ele.click();
			WebElement doneEle = checkVisibilityOfElement(doneXpath);
			if (doneEle.isDisplayed()) {
				doneEle.click();
				return true;
			} else {
				return false;
			}

		} else
			return false;
	}

	public static boolean checkPageHeaderVisibiltiy(String text) {
		String xpath = "//*[text()='" + text + "']/parent::h1";// this is done so in future if the header changes we
																// just
																// need to update feature file
		return checkVisibilityOfElement(xpath).isDisplayed();
	}

	public static boolean clickOnButton(String text) {
		String xpath = "(//input[@value='" + text + "'])[1]";
		WebElement ele = checkVisibilityOfElement(xpath);
		if (ele.isEnabled()) {
			ele.click();
			return true;
		} else {
			return false;
		}

	}

	public static boolean javaScriptClick(String text) {
		String xpath = "(//input[@value='" + text + "'])[1]";
		WebElement ele = checkVisibilityOfElement(xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();", ele);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validateFromErrorMsg(String text) {
		// this is written in this way so in future if only error message changes then
		// we just need to update feature file without
		// changing the code
		String xpath = "//span[@id='InputFrom-error'][text()='" + text + "']";
		return checkVisibilityOfElement(xpath).isDisplayed();
	}

	public static boolean validateToErrorMsg(String text) {
		// this is written in this way so in future if only error message changes then
		// we just need to update feature file without
		// changing the code
		String xpath = "//span[@id='InputTo-error'][text()='" + text + "']";
		return checkVisibilityOfElement(xpath).isDisplayed();
	}

	public static void selectFromDestination(String destToSel) {
		Utilities.SendKeys(destFrom, destToSel);
		// Utilities.click(destFromSel);
		// Utilities.actionClassClick(destFromSel);

	}

	public static void selectToDestination(String destToSel) {
		Utilities.SendKeys(destTo, destToSel);
		// Utilities.click(destFromSel);
		// Utilities.actionClassClick(destFromSel);

	}

	public static boolean verifyJourneyDetailsContainer() {

		if (Utilities.checkVisibilityOfElement(journeyDetailsContainer).isDisplayed()) {
			Utilities.click(journeyContainer);
			if (Utilities.checkVisibilityOfElement(verifyMsg).isDisplayed()) {
				return true;
			} else
				return false;
		} else
			return false;

	}

	public static void clickOnPlanAJourney() {
		/*
		 * WebElement ele=checkVisibilityOfElement(planaJourney); JavascriptExecutor js=
		 * (JavascriptExecutor) driver; js.executeScript("arguments[0].click();", ele);
		 */
		Utilities.click(planaJourney);
	}

	public static boolean verifyPageTitleNotVisible(String title) {
		String xPath = "//*[text()='" + title + "']/parent::h1";
		return Utilities.displayofanElement(xPath);
	}

	public static boolean validateRecentJourney(String text1, String text2) {
		String xPath="//*[contains(text(),'"+text1+" "+"to"+" "+ text2+"')]";
		System.out.println(xPath);
		return Utilities.displayofanElement(xPath);
	}
	
	public static boolean valiDateErrMsg(String msg) {
		String xPath="//*[text()=\""+msg+"\"]";
		return Utilities.displayofanElement(xPath);
	}
}
