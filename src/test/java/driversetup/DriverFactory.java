package driversetup;


import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class DriverFactory {

	Driver localDriver;
	WebDriver driver;
	String browserT="";
	public WebDriver getDriver(String driverType){
		
		
		if(driverType != null){
			
			if(driverType.equalsIgnoreCase("chrome")){
				driver = new ChromeDesktopDriver().initDriver(driverType);
				
			}else{
				System.out.println(driverType +" is not the valid Browser Type");
				browserT="invalid";	
				Assert.assertEquals(browserT, "invalid1","Invalid BrowserType");
				
			}
		}else{
			System.out.println(driverType +"is null");			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
				
	}

}
