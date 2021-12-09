package tests.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends PageObject{
    public HomePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[3]/a")
    private WebElement findOwnerLink;

    public emptyFindOwnerPO goToFindOwner(){
        return new emptyFindOwnerPO(driver);
    }


}
