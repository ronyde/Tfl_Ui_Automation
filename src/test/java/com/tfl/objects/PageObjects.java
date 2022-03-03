package com.tfl.objects;

import org.openqa.selenium.WebElement;

import com.tfl.utilitymethods.Utilities;

public class PageObjects extends Utilities {

	public static String doneXpath = "//strong[text()='Done']/parent::button";

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

	public static boolean checkPlanJourneyVisibiltiy(String text) {
		String xpath = "//*[text()='" + text + "']/parent::h1";// this is done so in future if the header changes we just
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
	
	public static boolean validateFromErrorMsg(String text) {
		//this is written in this way so in future if only error message changes then we just need to update feature file without
		//changing the code
		String xpath ="//span[@id='InputFrom-error'][text()='"+text+"']";
		return checkVisibilityOfElement(xpath).isDisplayed();
	}
	
	public static boolean validateToErrorMsg(String text) {
		//this is written in this way so in future if only error message changes then we just need to update feature file without
		//changing the code
		String xpath ="//span[@id='InputTo-error'][text()='"+text+"']";
		return checkVisibilityOfElement(xpath).isDisplayed();
	}

}
