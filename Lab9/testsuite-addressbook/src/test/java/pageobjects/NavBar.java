package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

	
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[3]/ul/li[2]/a")
	private WebElement addNewLink;
	
	
	@FindBy(xpath = "/html/body/div/div[3]/ul/li[1]/a")
	private WebElement homeLink;

	
	
	public NavBar (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * click on the link to go to the edit page to add a new address
	 * @return the edit page (first form)
	 */
	public AddNewAddressBookAddressForm goToAddNewAddressBook () {
		
		addNewLink.click();
		
		return new AddNewAddressBookAddressForm(driver);
	}
	
	
	/**
	 * click on the link to go to the home page
	 * @return the home page
	 */
	public ProfilePage goToProfilePage () {
		
		homeLink.click();
		
		return new ProfilePage(driver);
	}
	
}
