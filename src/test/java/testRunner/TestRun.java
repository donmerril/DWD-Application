package testRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions

(
	features="src/test/resources/Features/WordPress.feature", 
	glue = "stepDefinitions", 
	monochrome = true, // this makes the results in console more readable
	dryRun = false, // this will execute the steps rather than checking each step in feature file has a step definition
	plugin= {"pretty","html:target/cucumber-report/cucumber.html","json:target/cucumber-report/Ccucumber.json"}, //displays scenarios , steps in console and generate a report
	stepNotifications = true, // this will show steps in the junit bar
	tags = "@SmokeTest1"
	
)

public class TestRun {


}

