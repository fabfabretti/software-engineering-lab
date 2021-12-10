package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestGoToTShirtCategory extends BaseTest {

  @Test
  public void testGoToTShirtCategory() {

    WebElement tShirtNavbarLink = driver.findElement(By.xpath("/html/body/div[3]/div/nav/div/div/ul/li[2]/a"));
    tShirtNavbarLink.click();

    WebElement firstResult = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/a/h3"));
    WebElement secondResult = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div/div/a/h3"));
    assertEquals("Blue T-shirt", firstResult.getText());
    assertEquals("Black T-shirt", secondResult.getText());
  }
}
