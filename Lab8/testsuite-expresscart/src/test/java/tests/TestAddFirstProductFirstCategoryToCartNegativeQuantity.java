package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCartNegativeQuantity extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCartNegativeQuantity() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue T-shirt')]"));
    blueTShirtLink.click();

    WebElement decreaseQuantityButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div/span[1]/button"));
    decreaseQuantityButton.click();
    decreaseQuantityButton.click();
    decreaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[1]/div[3]/label/input"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[3]/button"));
    addToCartButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartCount = driver.findElement(By.xpath("//*[@id=\"cart-count\"]"));
    assertEquals(0, Integer.parseInt(cartCount.getText()));
  }
}
