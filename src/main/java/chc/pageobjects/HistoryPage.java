package chc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chc.abstractcomponents.AbstractComponents;

public class HistoryPage extends AbstractComponents{
	WebDriver driver;
	
	public HistoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".panel-heading")
	WebElement apptHistoryDate;
	
	public String getApptHistoryDate(String appointmentDate) {
		String apptHistoryConfirmation = apptHistoryDate.getText();
		return apptHistoryConfirmation;
	}
}
