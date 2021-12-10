package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.FunctionalUtilities;

public class TestValidUserRegistration extends BaseTest {

  @Test
  public void testValidUserRegistration() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue T-shirt')]"));
    blueTShirtLink.click();

    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[2]/button"));
    increaseQuantityButton.click();
    increaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[1]/div[3]/label/input"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[3]/button"));
    addToCartButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a"));
    cartIcon.click();

    WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/a"));
    checkoutButton.click();

    WebElement payNowButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div[2]/a"));
    payNowButton.click();

    String randomEmail = FunctionalUtilities.getRandomEmail();
    String firstName = "firstName";
    String lastName = "lastName";
    String firstAddress = "addr";
    String country = "country";
    String state = "state";
    String postCode = "1234";
    String phoneNumber = "123456789";
    String password = "password";

    WebElement newCustomerEmailAddressInput = driver.findElement(By.xpath("//*[@id=\"shipEmail\"]"));
    WebElement newCustomerFirstNameInput = driver.findElement(By.xpath("//*[@id=\"shipFirstname\"]"));
    WebElement newCustomerLastNameInput = driver.findElement(By.xpath("//*[@id=\"shipLastname\"]"));
    WebElement newCustomerAddress1Input = driver.findElement(By.xpath("//*[@id=\"shipAddr1\"]"));
    WebElement newCustomerCountryInput = driver.findElement(By.xpath("//*[@id=\"shipCountry\"]"));
    WebElement newCustomerStateInput = driver.findElement(By.xpath("//*[@id=\"shipState\"]"));
    WebElement newCustomerPostCodeInput = driver.findElement(By.xpath("//*[@id=\"shipPostcode\"]"));
    WebElement newCustomerPasswordInput = driver.findElement(By.xpath("//*[@id=\"newCustomerPassword\"]"));
    WebElement newCustomerPhoneNumberInput = driver.findElement(By.xpath("//*[@id=\"shipPhoneNumber\"]"));
    WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"createCustomerAccount\"]"));

    newCustomerEmailAddressInput.sendKeys(randomEmail);
    newCustomerFirstNameInput.sendKeys(firstName);
    newCustomerLastNameInput.sendKeys(lastName);
    newCustomerAddress1Input.sendKeys(firstAddress);
    newCustomerCountryInput.sendKeys(country);
    newCustomerStateInput.sendKeys(state);
    newCustomerPostCodeInput.sendKeys(postCode);
    newCustomerPasswordInput.sendKeys(password);
    newCustomerPhoneNumberInput.sendKeys(phoneNumber);
    createAccountButton.click();

    newCustomerEmailAddressInput = driver.findElement(By.xpath("//*[@id=\"shipEmail\"]"));
    newCustomerFirstNameInput = driver.findElement(By.xpath("//*[@id=\"shipFirstname\"]"));
    newCustomerLastNameInput = driver.findElement(By.xpath("//*[@id=\"shipLastname\"]"));
    newCustomerAddress1Input = driver.findElement(By.xpath("//*[@id=\"shipAddr1\"]"));
    newCustomerCountryInput = driver.findElement(By.xpath("//*[@id=\"shipCountry\"]"));
    newCustomerStateInput = driver.findElement(By.xpath("//*[@id=\"shipState\"]"));
    newCustomerPostCodeInput = driver.findElement(By.xpath("//*[@id=\"shipPostcode\"]"));
    newCustomerPhoneNumberInput = driver.findElement(By.xpath("//*[@id=\"shipPhoneNumber\"]"));

    assertEquals(randomEmail, newCustomerEmailAddressInput.getAttribute("value"));
    assertEquals(firstName, newCustomerFirstNameInput.getAttribute("value"));
    assertEquals(lastName, newCustomerLastNameInput.getAttribute("value"));
    assertEquals(firstAddress, newCustomerAddress1Input.getAttribute("value"));
    assertEquals(firstAddress, newCustomerAddress1Input.getAttribute("value"));
    assertEquals(country, newCustomerCountryInput.getAttribute("value"));
    assertEquals(state, newCustomerStateInput.getAttribute("value"));
    assertEquals(postCode, newCustomerPostCodeInput.getAttribute("value"));
    assertEquals(phoneNumber, newCustomerPhoneNumberInput.getAttribute("value"));
  }
}
