package com.tfl.utilitymethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tfl.common.library.BaseClass;

import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.Scenario;

public class Utilities extends BaseClass {

	public static WebElement checkVisibilityOfElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void takeScreenshots() throws IOException {
		Date currentdate = new Date();
		String filename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(".//screenshot//" + filename + ".png"));
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void SendKeys(String xPath, String txtToEnter) {
		WebElement ele;
		try {
			ele = checkVisibilityOfElement(xPath);
			ele.sendKeys(txtToEnter);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void click(String xPath) {
		WebElement ele;
		ele = checkVisibilityOfElement(xPath);
		ele.click();
	}

	public static void actionClassClick(String xPath) {
		Actions action = new Actions(driver);
		WebElement ele = checkVisibilityOfElement(xPath);
		action.moveToElement(ele).click().build().perform();
	}

	public static boolean displayofanElement(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			ele.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
