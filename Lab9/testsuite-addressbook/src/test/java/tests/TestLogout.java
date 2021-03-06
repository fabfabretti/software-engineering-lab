package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import pageobjects.LoginPage;
import pageobjects.ProfilePage;
import utils.BaseTest;

public class TestLogout extends BaseTest {

	@Test
	public void testLogout() {

		String username = "admin";
		String password = "secret";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertEquals(false,loginPage.isLoginPage());
		
		
		ProfilePage profilePage = new ProfilePage(driver);
		assertEquals("(" + username + ")", profilePage.getLoggedUser());
		
		loginPage = profilePage.logout();

		boolean amIInLogin = loginPage.isLoginPage();
		assertEquals(true,amIInLogin);
		
		
	}
}
