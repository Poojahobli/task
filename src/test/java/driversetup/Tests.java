package driversetup;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Tests {

	DriverFactory dfactory;

	public static WebDriver driver;
	public String browserType;

	@BeforeSuite
	public void beforeSuite() {

	}

	@AfterSuite
	public void afterSuite() {

		//driver.quit();

	}

	@BeforeMethod
	@Parameters("browser")
	public void initDriver(String browser) {
		// initDriver method inside Tests
		browserType = browser;
		dfactory = new DriverFactory();
		driver = dfactory.getDriver(browserType);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	

	@AfterSuite
	public void processAfterSuite() {
	
		// driver.close();
	}

	
	
	@AfterMethod
	public void afterMethod() {

		//driver.quit();

	}

}
