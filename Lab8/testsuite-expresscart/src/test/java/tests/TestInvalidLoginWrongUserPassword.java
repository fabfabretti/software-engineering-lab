package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestInvalidLoginWrongUserPassword extends BaseTest {

  @Test
  public void testInvalidLoginWrongUserPassword() {

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

    WebElement existingCustomerEmailAddressInput = driver.findElement(By.xpath("//*[@id=\"customerLoginEmail\"]"));
    existingCustomerEmailAddressInput.sendKeys("test@test.it");
    WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"customerLoginPassword\"]"));
    passwordInput.sendKeys("wrong");
    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"customerLogin\"]"));
    loginButton.click();

    notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));

    assertEquals(
            "Access denied. Check password and try again.", notificationMessage.getText());
  }
}
