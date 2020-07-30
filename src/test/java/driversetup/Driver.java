package driversetup;

import org.openqa.selenium.WebDriver;

public abstract class Driver {

	public abstract WebDriver initDriver(String browser);
}
