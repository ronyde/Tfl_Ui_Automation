package com.tfl.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,features="src/test/resources/features",glue="com.tfl.stepdefinition")
public class TflUiRunner {

}
