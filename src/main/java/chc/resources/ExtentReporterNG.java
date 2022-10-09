package chc.resources;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	@BeforeMethod
	public static ExtentReports getReportObject() {
	//Create a string object that stores the file path for the report
	String path = System.getProperty("user.dir") + "\\reports\\index.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("CuraHealth Automation Tests");
	reporter.config().setDocumentTitle("CuraHealth Test Results");
	reporter.config().setTheme(Theme.DARK);
	
	ExtentReports reports = new ExtentReports();
	reports.attachReporter(reporter);
	reports.setSystemInfo("Tester", "Julian Coleman");
	reports.createTest(path);
	
	return reports;
	}
}
