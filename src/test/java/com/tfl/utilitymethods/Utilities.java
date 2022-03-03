package com.tfl.utilitymethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tfl.common.library.BaseClass;

public class Utilities extends BaseClass {

	public static WebElement checkVisibilityOfElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void takeScreenshots() throws IOException {
		Date currentdate=new Date();
		String filename=currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(".//screenshot//"+filename+".png"));
	}

}
