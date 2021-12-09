package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class BaseTest {

	protected static WebDriver driver;
	protected static String URL = "http://localhost:3000";

	@Before
	public void setUp() throws InterruptedException {

		driver = getDriver();
		driver.get(URL);
	}

	@After
	public void tearDown() {
		//driver.quit();
		driver = null;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			firefoxOptions.setProfile(profile);
			// firefoxOptions.setHeadless(true);

			driver = new FirefoxDriver(firefoxOptions);
			// driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}

}
