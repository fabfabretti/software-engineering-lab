package tests;

import utils.BaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class CheckTestCase extends BaseTest {
	
	@Test
	public void checkEverythingWorks() {
		String expectedValue = "cloth";
		String currentValue = driver.findElement(By.xpath("//a[@class='navbar-brand']")).getText().toLowerCase();
		// first argument is the expected value, second argument is the dynamic value that has to be checked
		assertEquals(expectedValue, currentValue);
	}
	

}
