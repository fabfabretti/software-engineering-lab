package tests;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestFindNotExistingOwner  extends BaseTest {

	@Test
	public void testFindNotExistingOwner() {
		// Find owner page
		WebElement linkFindOwner = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a"));
		linkFindOwner.click();

		// Check if I'm on owner page
		WebElement ownerPageTitle = driver.findElement(By.tagName("h2"));
		Assert.assertEquals("Find Owners",ownerPageTitle.getText());

		// Find Last Name field and write a present name
		WebElement lastNameField = driver.findElement(By.id("lastname"));
		lastNameField.sendKeys("qwertyuiop");
		lastNameField.submit();

		// Find the button and click
		WebElement button = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
		button.click();

		// Check that
		WebElement notFoundLabel = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/div/div/span/div/p"));
		Assert.assertEquals("has not been found",notFoundLabel.getText());


	}
		
	
}
