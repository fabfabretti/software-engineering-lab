package demo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPersonPO extends PageObject {

    public AddPersonPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/form/input[1]")
    private WebElement nameField;

    @FindBy(xpath = "/html/body/form/input[2]")
    private WebElement surnameField;

    @FindBy(tagName = "h1")
    private WebElement message;

    public String getMessage(){
        return message.getText();
    }

    public nonEmptyListPO insertPerson(String name, String surname){
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        surnameField.submit();
        return new nonEmptyListPO(driver);
    }



}
