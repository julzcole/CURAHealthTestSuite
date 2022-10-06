package chc.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import chc.abstractcomponents.AbstractComponents;

public class AppointmentPage extends AbstractComponents {

	WebDriver driver;
	
	public AppointmentPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="chk_hospotal_readmission")
	WebElement readmissionCheckbox;
	
	@FindBy(id="combo_facility")
	WebElement facility;
	
	@FindBy(id="txt_visit_date")
	WebElement apptDateField;
	
	@FindBy(css="div[class='datepicker-days'] th[class='datepicker-switch']")
	WebElement month;
	
	@FindBy(css="td[class='day']")
	List<WebElement> days;
	
	@FindBy(id="txt_comment")
	WebElement commentBox;
	
	@FindBy(id="btn-book-appointment")
	WebElement bookApptBtn;
	
	@FindBy(tagName="h2")
	WebElement confirmationMsg;
	
	@FindBy(css="input[type='radio']")
	List<WebElement> radioButtons;
	
	@FindBy(css="div[class='datepicker-days'] th[class='next']")
	WebElement nextMonthBtn;
	
	
	public void enterApptDetails(int facilityIndex, String radioValue, Boolean readmissionSelection, String comment) {
		//Select a facility
		Select facilityDropdown = new Select(facility);
		facilityDropdown.selectByIndex(facilityIndex);
		
		//Re-admission check
		if(readmissionSelection == true) {
			readmissionCheckbox.click();
		}
		//Healthcare Program Selection
		for(int i = 0 ; i < radioButtons.size(); i++) {
			if(radioButtons.get(i).getAttribute("value").equalsIgnoreCase(radioValue)) {
				radioButtons.get(i).click();
			}
		}
		
		//Enter a Comment
		commentBox.sendKeys(comment);
	}
	
	public void enterApptDate(String neededMonthYear, String neededDay) {
		apptDateField.click();
		while(!month.getText().contains(neededMonthYear)) {
			nextMonthBtn.click();
		}
		
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getText().equalsIgnoreCase("21")) {
				days.get(i).click();
				break;
			}
		}
	}
	
	public String getApptDate() {
		String apptDate = apptDateField.getAttribute("value");
		return apptDate;
	}
	
	public void bookAppt() {
		bookApptBtn.click();
	}
	
	public String getConfirmationMsg() {
		String confirmationMsg = driver.findElement(By.tagName("h2")).getText();
		return confirmationMsg;
	}
}
