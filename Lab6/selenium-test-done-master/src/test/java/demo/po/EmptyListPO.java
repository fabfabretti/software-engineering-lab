package demo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyListPO extends PageObject {
    public EmptyListPO(WebDriver driver){
        super(driver);
    }
    @FindBy(linkText = "Add new person")
    private WebElement addPersonLink;

    @FindBy(tagName = "h1")
    private WebElement message;

    public String getMessage(){
        return message.getText();
    }

    // Cambio pagina, ergo devo poter navigare alla prossima pagina.
    public AddPersonPO addPerson(){
        addPersonLink.click();
        return new AddPersonPO(driver);
    }
}
