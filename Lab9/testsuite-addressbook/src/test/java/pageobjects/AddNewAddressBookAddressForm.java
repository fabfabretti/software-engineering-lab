package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressBookAddressForm {

	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[4]/form/input[1]")
	private WebElement nextButton;
	
	
	public AddNewAddressBookAddressForm (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * go to the full form
	 * @return the new address page
	 */
	public AddNewAddressBookFullForm goToFullForm () {
		
		nextButton.click();
		
		return new AddNewAddressBookFullForm(driver);
		
	}
}
