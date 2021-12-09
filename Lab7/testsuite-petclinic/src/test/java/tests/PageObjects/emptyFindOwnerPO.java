package tests.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class emptyFindOwnerPO extends PageObject{

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(xpath = "/html/body/div/div/form/div[2]/div/button")
    WebElement button;

    public emptyFindOwnerPO(WebDriver driver) {
        super(driver);
    }

    public void searchPresentOwner(String lastName){
        lastNameField.sendKeys(lastName);
        lastNameField.submit();
        button.submit();
    }

    public void searchAbsentOwner(String lastName){

    }
}
