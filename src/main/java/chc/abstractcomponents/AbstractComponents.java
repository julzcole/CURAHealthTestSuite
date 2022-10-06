package chc.abstractcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {
	private WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-toggle")
	WebElement menuToggle;
	
	@FindBy(css="a[href='history.php#history']")
	WebElement historyLink;
	
	public void goToHistory() {
		menuToggle.click();
		historyLink.click();
	}
}
