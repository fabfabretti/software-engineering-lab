package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestSearchProductNotPresent extends BaseTest {

  @Test
  public void testSearchProductNotPresent() {
    WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"frm_search\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"btn_search\"]"));

    searchInput.sendKeys("test");
    searchButton.click();

    WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/p"));
    assertEquals("No products found", errorMessage.getText());
  }
}
