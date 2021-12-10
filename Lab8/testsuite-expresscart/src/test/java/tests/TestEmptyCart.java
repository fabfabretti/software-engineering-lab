package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestEmptyCart extends BaseTest {

  @Test
  public void testEmptyCart() {

    WebElement greenJacketLink = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[2]/div/div/a/h3"));
    greenJacketLink.click();
    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[2]/button"));
    increaseQuantityButton.click();
    WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[3]/button"));
    addToCartButton.click();
    WebElement notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));
    assertEquals("Cart successfully updated", notificationMessage.getText());
    WebElement cartCount = driver.findElement(By.xpath("//*[@id=\"cart-count\"]"));
    assertEquals(2, Integer.parseInt(cartCount.getText()));

    WebElement cartIcon = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a"));
    cartIcon.click();

    WebElement emptyCartButton = driver.findElement(By.xpath("//*[@id=\"empty-cart\"]"));
    emptyCartButton.click();
    WebElement closeWindowButton = driver.findElement(By.xpath("//button[contains(text(),'X')]"));
    closeWindowButton.click();

    cartCount = driver.findElement(By.xpath("//*[@id=\"cart-count\"]"));
    assertEquals(0, Integer.parseInt(cartCount.getText()));
  }
}
