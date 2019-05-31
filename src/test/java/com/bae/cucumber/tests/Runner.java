package com.bae.cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\eclipse-workspace\\BDDPassionateTea\\src\\test\\java\\Parametisation.feature", glue = ("com.bae.cucumber.tests"))

public class Runner {

}
