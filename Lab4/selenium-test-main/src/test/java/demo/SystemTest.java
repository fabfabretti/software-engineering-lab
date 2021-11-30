package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.lang3.SystemUtils;

import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SystemTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        org.openqa.selenium.chrome.ChromeOptions chrome_options = new ChromeOptions();
        //chrome_options.addArguments("--headless");
        if(SystemUtils.IS_OS_WINDOWS){
            System.setProperty("webdriver.chrome.driver",
                    Paths.get("src/test/resources/chromedriver_win32_96/chromedriver.exe").toString());
        }
        else if (SystemUtils.IS_OS_MAC){
            System.setProperty("webdriver.chrome.driver",
                    Paths.get("src/test/resources/chromedriver_mac64_96/chromedriver").toString());
        }
        else if (SystemUtils.IS_OS_LINUX){
            System.setProperty("webdriver.chrome.driver",
                    Paths.get("src/test/resources/chromedriver_linux64_96/chromedriver").toString());
        }
        if (driver == null)
            driver = new ChromeDriver(chrome_options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }


    // in SystemTest.java
    @Test
    public void testAddPerson(){

            // ADD A PERSON

        // Carico la pagina

        driver.get("http://localhost:8080");

        // Verifico di essere nella pagina corretta estraendo il tag

        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();

        assertEquals("People list",titleMessage);

        // Clicco sul link. Ci sono delle asserzioni implicite: se l'elemento/link
        // non fosse presente, selenium automaticamente ritorna che il caso di
        // test fallisce
        // Poi Verifico di essere arrivato nella pagina corretta. Facciamo tutto in una riga

        WebElement link = driver.findElement(By.linkText("Add new person"));
        link.click();

        assertEquals("Create a new record", driver.findElement(By.tagName("h1")).getText());

        // Digito il nome nelle form e invio. Asserto se sono sulla pagina dell'elenco
        // aka che sia tutto andato a buon fine

        driver.findElement(By.name("firstname")).sendKeys("Fabiola");
        driver.findElement(By.name("lastname")).sendKeys("Fabretti");
        driver.findElement(By.name("lastname")).submit();

        assertEquals("People list", driver.findElement(By.tagName("h1")).getText());


            // VERIFY THAT THE PERSON IS ADDED

        // Vogliamo trovare la riga della tabela dove ho inserito cose; quindi uso una xpath
        // per trovare il nome inserito.

        WebElement cell = driver.findElement(By.xpath("//table/tbody//td[2]"));

        assertEquals("Fabiola",cell.getText());


            // CHANGE THE PERSON'S SURNAME

        // Clicco sul link "edit" e verifico di arrivare alla pagina di modifica.

        link = driver.findElement(By.linkText("edit"));
        link.click();

        assertEquals("Edit a record", driver.findElement(By.tagName("h1")).getText());

        // Modifico il cognome nel form, submitto e verifico di arrivare sulla pagina giusta
        WebElement surnameField = driver.findElement(By.name("lastname"));
        surnameField.clear();
        surnameField.sendKeys("Fabretti2");
        surnameField.submit();

        assertEquals("People list", driver.findElement(By.tagName("h1")).getText());


            // VERIFY THAT THE PERSON NAME IS CHANGED

        // Verifico che il cognome sia stato modificato
        cell = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[3]"));
        assertEquals("Fabretti2", cell.getText());


             // DELETE THE PERSON FROM THE DATA BASE

        // Elimino la persona e verifico di essere di nuovo nella home page
        link = driver.findElement(By.linkText("delete"));
        link.click();

        assertEquals("People list", driver.findElement(By.tagName("h1")).getText());


            // VERIFY THAT THE PERSON IS NOT PRESENT IN THE LIST

        List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/thead/tr"));

        assertEquals(1, rows.size());
    }

}
