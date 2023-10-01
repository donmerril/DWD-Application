package com.AutomationAnywhere;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Program3 {

	@Test
	public void implementProgram3() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Terry\\Documents\\chromedrivernew.exe");

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();

		// Create an instance of the Actions class for mouse actions
		Actions actions = new Actions(driver);

		// Find the "Products" menu item and perform a mouseover
		WebElement productsMenuItem = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[1]/a"));
		actions.moveToElement(productsMenuItem).build().perform();

		// Find and click the "Process Discovery" link
		WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[@title=\"Process Discovery\"]"));
		processDiscoveryLink.click();

		String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Page navigation failed.");
      
	}

}
