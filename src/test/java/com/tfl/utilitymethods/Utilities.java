package com.tfl.utilitymethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tfl.common.library.BaseClass;

public class Utilities extends BaseClass {
	
	public static WebElement checkVisibilityOfElement(String xpath) {
		WebDriverWait wait =new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	 
}
