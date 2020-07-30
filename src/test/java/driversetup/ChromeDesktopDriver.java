package driversetup;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDesktopDriver extends Driver {

	WebDriver driver;
	@Override
	public WebDriver initDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "E:\\omkar\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
		return driver;
	}
	
}