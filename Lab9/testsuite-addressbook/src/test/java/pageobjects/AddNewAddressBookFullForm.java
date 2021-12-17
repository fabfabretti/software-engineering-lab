package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressBookFullForm {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressField;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileField;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "/html/body/div/div[4]/form/input[21]")
	private WebElement submitForm;

	@FindBy(xpath = "/html/body/div/div[4]/form[1]/input[22]")
	private WebElement submitFormEdit;
	
	@FindBy(xpath = "/html/body/div/div[4]/form[2]/input[2]")
	private WebElement deleteButton;
	
	
	public AddNewAddressBookFullForm (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	/**
	 * Insert the given values in the form and submit
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param mobile
	 * @param email
	 * @return the profile page
	 */
	public ProfilePage addNewAddress(String firstName, String lastName, String address, String mobile, String email) {
	
		addToFormIfNotNull(firstNameField, firstName);
		addToFormIfNotNull(lastNameField, lastName);
		addToFormIfNotNull(addressField, address);
		addToFormIfNotNull(mobileField, mobile);
		addToFormIfNotNull(emailField, email);

		try{
			submitFormEdit.click();
		}catch(Exception e){
			submitForm.click();
		}
		
		return new NavBar(driver).goToProfilePage();
	}
	
	
	public ProfilePage delete() {
		
		deleteButton.click();
		
		return new NavBar(driver).goToProfilePage();
	}

	private void addToFormIfNotNull (WebElement formField, String value) {
		
		if (value != null) {
			
			formField.clear();
			formField.sendKeys(value);
		}
	}
	
	
	
	
}
