package com.tfl.common.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	public static WebDriver driver;

	public BaseClass() {

		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\testproperties\\pGlobalSettings.properties");
			Properties prop = new Properties();
			prop.load(file);

			switch (prop.getProperty("BROWSER"))

			{
			case "Chrome":
				System.out.println("Chrome driver creation progress starts");
				if (prop.getProperty("OS").equalsIgnoreCase("windows")) {
					System.setProperty("webdriver.chrome.driver", prop.getProperty("WIN_CHROME_DRIVER_PATH"));
				} else {
					// We can also do the same using property file for mac but as i dont have a
					// macbook hence not able to complete that
				}
				driver = new ChromeDriver();
				driver.get(prop.getProperty("URL_TO_LAUNCH"));
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				break;

			case "edge":
				System.out.println("Edge driver creation progress starts");
				if (prop.getProperty("OS").equalsIgnoreCase("windows")) {
					System.setProperty("webdriver.edge.driver", prop.getProperty("WIN_EDGE_DRIVER_PATH"));
				} else {
					// We can also do the same using property file for mac but as i dont have a
					// macbook hence not able to complete that
				}
				driver = new EdgeDriver();
				driver.get(prop.getProperty("URL_TO_LAUNCH"));
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				break;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}

}
