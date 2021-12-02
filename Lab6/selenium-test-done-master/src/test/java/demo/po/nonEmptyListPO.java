package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class nonEmptyListPO extends PageObject {
    @FindBy(tagName = "h1")
    private WebElement message;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[2]")
    private WebElement firstEntryName;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[3]")
    private WebElement firstEntrySurname;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]")
    private WebElement firstEntryId;
    @FindBy(tagName = "table")
    private WebElement table;


    public nonEmptyListPO(WebDriver driver) {
        super(driver);
    }

    public String getMessage(){
        System.out.println(message.getText());
        return message.getText();
    }

    public String getFirstEntryName(){
        return firstEntryName.getText();
    }
    public String getFirstEntrySurname(){
        return firstEntrySurname.getText();
    }
    public int getRowsNumber(){
        return table.findElements(By.tagName("tr")).size();
    }
}
