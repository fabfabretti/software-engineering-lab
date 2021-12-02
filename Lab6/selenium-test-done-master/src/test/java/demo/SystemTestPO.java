package demo;

import demo.po.AddPersonPO;
import demo.po.EmptyListPO;
import demo.po.nonEmptyListPO;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTestPO extends BaseTest{

    @Test
    public void testAddPerson() {

        //Start and initialize
        driver.get("http://localhost:8080/");
        EmptyListPO entryPage = new EmptyListPO(driver);
        assertEquals("People list", entryPage.getMessage());

        // Click on add new person
        AddPersonPO addPage = entryPage.addPerson();

        // Verifico di essere arrivat nella pagina corretta.
        assertEquals("Create a new record",addPage.getMessage());

        //Inserisco il mio nome di test e invio.
        nonEmptyListPO listPage = addPage.insertPerson("Mariano","Ceccato");

        // Verifico di essere sulla pagina corretta
        assertEquals("People list",listPage.getMessage());

        // Verifico che ci siano != 0 righe e che
        // il nome sia quello corretto.
        assertEquals(2,listPage.getRowsNumber());
        assertEquals("Mariano",listPage.getFirstEntryName());
        assertEquals("Ceccato",listPage.getFirstEntrySurname());






    }
}
