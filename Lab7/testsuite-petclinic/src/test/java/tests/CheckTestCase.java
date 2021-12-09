package tests;

import utils.BaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class CheckTestCase extends BaseTest {
	
	@Test
	public void checkEverythingWorks() {
		String expectedValue = "Welcome";
		String currentValue = driver.findElement(By.xpath("//div[@class=\"container xd-container\"]/h2")).getText();
		assertEquals(expectedValue, currentValue);
	}
	

}
