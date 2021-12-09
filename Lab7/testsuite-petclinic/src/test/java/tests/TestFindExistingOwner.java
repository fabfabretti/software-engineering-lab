package tests;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestFindExistingOwner  extends BaseTest {

	@Test
	public void testFindExistingOwner() {
		// fail("to do");  //see TestCasesFinal.pdf in package aTestDescription


		// Find owner page
		WebElement linkFindOwner = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a"));
		linkFindOwner.click();

		// Check if I'm on owner page
		WebElement ownerPageTitle = driver.findElement(By.tagName("h2"));
		Assert.assertEquals("Find Owners",ownerPageTitle.getText());

		// Find Last Name field and write a present name
		WebElement lastNameField = driver.findElement(By.id("lastname"));
		lastNameField.sendKeys("Franklin");
		lastNameField.submit();

		// Find the button and click
		WebElement button = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
		button.click();

		// Check if I'm on result page and look for Franklin
		WebElement ownerPageTitle2 = driver.findElement(By.xpath("/html/body/div/div/h2[1]"));
		Assert.assertEquals("Owner Information",ownerPageTitle2.getText());

		// Check that Franklin was found
		WebElement ownerName = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));
		Assert.assertEquals("George Franklin",ownerName.getText());



	}
		
	
}
