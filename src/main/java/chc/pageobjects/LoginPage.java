package chc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chc.abstractcomponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		//Initialize driver. Basically initializes first when accessing this class
		this.driver = driver;
		//PageFactory initElements
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="btn-make-appointment")
	WebElement makeApptButton;
	
	@FindBy(id="txt-username")
	WebElement usernameField;
	
	@FindBy(id="txt-password")
	WebElement passwordField;
	
	@FindBy(id="btn-login")
	WebElement loginButton;
	
	@FindBy(css=".text-danger")
	WebElement unsuccessfulLoginPrompt;
	
	public AppointmentPage loginToApp(String username, String password) {
		makeApptButton.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new AppointmentPage(driver);
	}
	
	public WebElement unsuccessfulLogin(String username, String password) {
		makeApptButton.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return unsuccessfulLoginPrompt;
	}
	
	public void goTo() {
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}
	
	
}
