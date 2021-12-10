package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestSearchValidProduct extends BaseTest {

  @Test
  public void testSearchValidProduct() {
    WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"frm_search\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"btn_search\"]"));

    searchInput.sendKeys("jacket");
    searchButton.click();

    WebElement firstResult = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[1]/div/div/a/h3"));
    WebElement secondResult = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div/div/a/h3"));
    assertEquals("Green Jacket", firstResult.getText());
    assertEquals("Orange Jacket", secondResult.getText());
  }
}
