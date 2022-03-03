package com.tfl.common.library;

import io.cucumber.java.After;

public class Hooks extends BaseClass {
	@After(order = 0)
	public void afterScenario() {
		driver.quit();
		System.out.println("In am in hooks");
	}
}
