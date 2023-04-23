package TestCases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;

	public ExtentReports report;
	public ExtentTest Test;
	Fillo fillo;
	Connection connection;

	@BeforeTest
	public void Reportsetup() throws FilloException {
		report = new ExtentReports("ExtentReport.html");
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}

	@BeforeMethod
	public void setup(Method Method) {
		WebDriverManager.chromedriver().setup();
		Test = report.startTest(Method.getName());
		this.driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void closeall() {
		report.endTest(Test);
		driver.quit();
	}

	@AfterTest
	public void ReportCleen() {
		report.flush();
		report.close();
	}
}
