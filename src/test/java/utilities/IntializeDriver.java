package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IntializeDriver {

	public static IntializeDriver driverObject;
	public WebDriver driver;

	public static IntializeDriver getChromeDriverObject() {

		if (driverObject == null) {
			driverObject = new IntializeDriver();
		}
		return driverObject;

	}

	public WebDriver initilize_driver() {

		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		//ops.setHeadless(true);
		ops.addArguments("--window-size=1920x1080"); // if we don't set this then cart wont get located and number format exception will occur
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, ops);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Terry\\Documents\\chromedrivernew.exe");
		driver = new ChromeDriver(ops);
		return driver;
	}

}
