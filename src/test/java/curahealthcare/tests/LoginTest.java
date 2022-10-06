package curahealthcare.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import chc.pageobjects.LoginPage;
import curahealthcare.testcomponents.BaseTest;

public class LoginTest extends BaseTest {
	@Test
	public void successfulLogin() {
		//Test Data

		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(username, password);
	}
	
	@Test
	public void incorrectPassword() {
		
		//Test Data
		String username = "John Doe";
		String password = "ThisIsNotAPassword!";
		
		//Login with wrong password
		LoginPage loginPage = new LoginPage(driver);
		WebElement unsuccessfulLoginPrompt = loginPage.unsuccessfulLogin(username, password);
		Assert.assertTrue(unsuccessfulLoginPrompt.isDisplayed());
	}
	
	@Test
	public void incorrectUsername() {
		String username = "John Do";
		String password = "ThisIsNotAPassword";
		LoginPage loginPage = new LoginPage(driver);
		WebElement unsuccessfulLoginPrompt = loginPage.unsuccessfulLogin(username, password);
		Assert.assertTrue(unsuccessfulLoginPrompt.isDisplayed());
	}
}

