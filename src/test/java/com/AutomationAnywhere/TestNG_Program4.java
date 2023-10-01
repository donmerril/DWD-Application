package com.AutomationAnywhere;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Program4 {

	@Test
	public void implementProgram4() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Terry\\Documents\\chromedrivernew.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.automationanywhere.com/");

		WebElement acceptCookieButton = driver
				.findElement(By.xpath("//div[@id='onetrust-button-group']//button[@id='onetrust-accept-btn-handler']"));

		if (acceptCookieButton.isDisplayed()) {
			acceptCookieButton.click();
		}
		// a. Click on Request Demo button
		WebElement requestDemoButton = driver
				.findElement(By.xpath(("//a[@class=\"coh-link utility-nav-link coh-style-solid-orange-button\"]")));
		requestDemoButton.click();

		// b. Verify that the page is navigated to
		// https://www.automationanywhere.com/request-live-demo
		String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equals(expectedUrl)) {
			System.out.println("Page has navigated to the correct URL: " + actualUrl);
		} else {
			System.out.println("Page has landed to an incorrect URL. Actual URL is : " + actualUrl);
		}

		// c. Verify the Label Names for First Name and Last Name
		WebElement firstNameLabel = driver.findElement(By.xpath(("//label[@id=\"LblFirstName\"]")));
		WebElement lastNameLabel = driver.findElement(By.xpath("//label[@id=\"LblLastName\"]"));

		Assert.assertEquals(firstNameLabel.getText(), "First Name", "First Name label does not match expected.");
		Assert.assertEquals(lastNameLabel.getText(), "Last Name", "Last Name label does not match expected.");
	}
}
