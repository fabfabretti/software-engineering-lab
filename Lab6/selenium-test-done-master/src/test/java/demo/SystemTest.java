package demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;


public class SystemTest extends BaseTest {

    @Test
    public void testAddPerson() {
        driver.get("http://localhost:8080/");
        String message1 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("People list message expected", "People list", message1);
        WebElement link1 = driver.findElement(By.linkText("Add new person"));
        link1.click();

        String message2 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("new record message expected", "Create a new record", message2);
        driver.findElement(By.name("firstname")).sendKeys("mariano");
        driver.findElement(By.name("lastname")).sendKeys("ceccato");
        driver.findElement(By.name("lastname")).submit();

        String message3 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("People list message expected", "People list", message3);
        WebElement table  = driver.findElement(By.tagName("table"));
        assertEquals("Just two lines expected", 2, table.findElements(By.tagName("tr")).size());

        WebElement firstRow = driver.findElement(By.xpath("//table//tbody//td[2]"));
        assertEquals("First name should be 'mariano'", "mariano", firstRow.getText());
    }

}
