package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestSearchEmptyProduct extends BaseTest {

  @Test
  public void testSearchEmptyProduct() {
    WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"frm_search\"]"));
    WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"btn_search\"]"));

    searchInput.sendKeys("");
    searchButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//*[@id=\"notify_message\"]"));
    assertEquals("Please enter a search value", notificationMessage.getText());
  }
}
