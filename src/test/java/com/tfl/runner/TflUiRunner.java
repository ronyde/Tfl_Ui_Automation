package com.tfl.runner;

import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(strict = true, features = "src/test/resources/features/Test2.feature", glue = "com.tfl.stepdefinition")
public class TflUiRunner {

}
