package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCart extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCart() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue T-shirt')]"));
    blueTShirtLink.click();

    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[2]/button"));
    increaseQuantityButton.click();
    increaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[1]/div[3]/label/input"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[3]/button"));
    addToCartButton.click();

    WebElement productPrice = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/h4[1]"));
    double price = Double.parseDouble(productPrice.getText().substring(1));

    WebElement notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a"));
    cartIcon.click();

    WebElement firstProductName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/p[1]/a"));
    WebElement firstProductSize = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/p[2]"));
    WebElement firstProductQuantity = driver.findElement(By.xpath("//*[@id=\"0\"]"));

    assertEquals("Blue T-shirt", firstProductName.getText());
    assertEquals("L", firstProductSize.getText().trim());
    assertEquals(3, Integer.parseInt(firstProductQuantity.getAttribute("value")));

    WebElement shippingPriceElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/strong"));
    WebElement totalPriceElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/strong"));

    double shippingPrice = Double.parseDouble(shippingPriceElement.getText().substring(1));
    double totalPrice = Double.parseDouble(totalPriceElement.getText().substring(1));

    assertEquals(price * Integer.parseInt(firstProductQuantity.getAttribute("value")) + shippingPrice,
            totalPrice, 0.001);
  }
}
