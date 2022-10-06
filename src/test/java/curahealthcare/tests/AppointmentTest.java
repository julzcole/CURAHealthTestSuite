package curahealthcare.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import chc.abstractcomponents.AbstractComponents;
import chc.pageobjects.AppointmentPage;
import chc.pageobjects.HistoryPage;
import chc.pageobjects.LoginPage;
import curahealthcare.testcomponents.BaseTest;

public class AppointmentTest extends BaseTest {
	String appointmentDate;
	
	@Test
	public void makeAppointment() {
		
		//Test Data
		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		int facilityIndex = 2;
		String radioValue = "Medicaid";
		Boolean readmissionSelection = true;
		String comment = "I love automation";
		String neededMonthYear = "March 2023";
		String neededDay = "15";
		
		//Log in to app
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(username, password);
		
		//Make Appointment
		AppointmentPage appointmentPage = new AppointmentPage(driver);
		appointmentPage.enterApptDetails(facilityIndex, radioValue, readmissionSelection, comment);
		appointmentPage.enterApptDate(neededMonthYear, neededDay);
		appointmentDate = appointmentPage.getApptDate();
		appointmentPage.bookAppt();
		String confirmationMsg = appointmentPage.getConfirmationMsg();
		Assert.assertEquals(confirmationMsg, "Appointment Confirmation");
		
		//Confirm Appt History
		HistoryPage historyPage = new HistoryPage(driver);
		AbstractComponents abstractComponents = new AbstractComponents(driver);
		abstractComponents.goToHistory();
		String apptHistoryConfirmation = historyPage.getApptHistoryDate(appointmentDate);
		Assert.assertEquals(apptHistoryConfirmation, appointmentDate);
	}
	

}
