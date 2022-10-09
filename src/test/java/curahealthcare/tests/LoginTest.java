package curahealthcare.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import chc.pageobjects.LoginPage;
import curahealthcare.testcomponents.BaseTest;

public class LoginTest extends BaseTest {
	@Test(dataProvider="getData")
	public void successfulLogin(HashMap<String,String> input) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(input.get("username"), input.get("password"));
	}
	
	@Test(dataProvider="getData2")
	public void incorrectPassword(HashMap<String,String> input) {
		LoginPage loginPage = new LoginPage(driver);
		WebElement unsuccessfulLoginPrompt = loginPage.unsuccessfulLogin(input.get("username"), input.get("password"));
		Assert.assertTrue(unsuccessfulLoginPrompt.isDisplayed());
	}
	
	@Test(dataProvider="getData3")
	public void incorrectUsername(HashMap<String,String> input) {
		LoginPage loginPage = new LoginPage(driver);
		WebElement unsuccessfulLoginPrompt = loginPage.unsuccessfulLogin(input.get("username"), input.get("password"));
		Assert.assertTrue(unsuccessfulLoginPrompt.isDisplayed());
	}


	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//curahealthcare//testdata//testdata.json");
		return new Object[][] {{data.get(0)}};
	}
	
	@DataProvider
	public Object[][] getData2() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//curahealthcare//testdata//testdata.json");
		return new Object[][] {{data.get(1)}};
	}
	
	@DataProvider
	public Object[][] getData3() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//curahealthcare//testdata//testdata.json");
		return new Object[][] {{data.get(2)}};
	}
}
