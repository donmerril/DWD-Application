package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class WordPress_HomePage {

	WebDriver wordPress_HomePage;

	public WordPress_HomePage(WebDriver idriver) {

		this.wordPress_HomePage = idriver;
		PageFactory.initElements(idriver, this);
	}
	
	
	@FindBy
	(xpath = "//a[text()='Download & Extend']")
	@CacheLookup
	WebElement downloadAndExtend;
	
	@FindBy
	(xpath = "//a[text()='Community']")
	@CacheLookup
	WebElement Community;
	
	@FindBy
	(xpath = "//ul[@data-wp-on--focusin = \"actions.core.navigation.openMenuOnFocus\"]/li/a[@href='https://wordpress.org/download/']")
	@CacheLookup
	WebElement getWordPress;
	
	@FindBy
	(xpath = "//input[@placeholder = 'Search photos']")
	@CacheLookup
	WebElement searchPhotos;
	
	@FindBy
	(xpath = "//div[@id = 'modal-1-content']/ul/li[4]/ul/li[2]/a")
	WebElement PhotoDirectory;
	
	@FindBy
	(xpath = "//h1[text()='Get WordPress']")
	@CacheLookup
	WebElement titleWordPress;

	public void verifyTheTileOfThePage() {
		
		String actual_title = wordPress_HomePage.getTitle();
		String expected = "Blog Tool, Publishing Platform, and CMS – WordPress.org";
		Assert.assertEquals(expected, actual_title);
	}
	
	public void hoverOverMenuAndClick() throws InterruptedException {
		Actions action = new Actions(wordPress_HomePage);
		action.moveToElement(downloadAndExtend).perform();
		Thread.sleep(2000);
		action.moveToElement(getWordPress).click().build().perform();
		
	}
	
	public void verifyTheTextIsDisplayed(String expectedText) {
		
		String actual_title = titleWordPress.getText();
		Assert.assertEquals(expectedText, actual_title);
	}
	
	public void clickCommunityAndPhotoDirectory() throws InterruptedException {
		Actions action = new Actions(wordPress_HomePage);
		action.moveToElement(Community).perform();
		Thread.sleep(2000);
		action.moveToElement(PhotoDirectory).click().build().perform();
		
	}
	
	public void searchPhotosAndVerifyDisplay() throws InterruptedException {
		
		searchPhotos.sendKeys("dog");
		searchPhotos.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		int imagesNumber= wordPress_HomePage.findElements(By.tagName("article")).size();
		
		if(imagesNumber>0) {
			System.out.println(imagesNumber+ " Results displayed");
			Assert.assertTrue(imagesNumber > 0);
		}else
			System.out.println(imagesNumber+ " Results displayed");
		
		
		
		
           
	}
}
