package stepDefinitions;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WordPress_HomePage;
import utilities.IntializeDriver;

public class WordPress_StepDefinitions {

	public WordPress_StepDefinitions() {
		// Default constructor with no arguments
	}

	WebDriver wordPress_driver = IntializeDriver.getChromeDriverObject().initilize_driver();
	WordPress_HomePage wpObject = new WordPress_HomePage(wordPress_driver);

	@Given("I am on the WordPress website {string}")
	public void openWordPressWebsite(String url) {
		wordPress_driver.manage().window().maximize();
		wordPress_driver.get(url);

	}

	@Then("I verify the title of the page is as expected")
	public void verifyPageTitle() {
		wpObject.verifyTheTileOfThePage();
	}

	@When("I hover over Download & Extend and click Get WordPress")
	public void i_hover_over_and_click() throws InterruptedException {
		wpObject.hoverOverMenuAndClick();
	}

	@Then("I verify the text {string} is displayed")
	public void i_verify_the_text_is_displayed(String expectedText) {
		wpObject.verifyTheTextIsDisplayed(expectedText);

	}
	
	@And("I click on Community and click on Photo Directory")
	public void i_click_community_and_photodirectory() throws InterruptedException {
		wpObject.clickCommunityAndPhotoDirectory();

	}
	
	@And("I search for a picture and verify the pictures are displayed")
	public void i_search_picture_and_verify() throws InterruptedException {
		wpObject.searchPhotosAndVerifyDisplay();

	}
}
