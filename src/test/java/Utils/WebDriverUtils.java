package Utils;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class WebDriverUtils {

	WebDriver driver;

	public WebDriverUtils(WebDriver driver) {

		
		try {

			this.driver = driver;
		} catch (Exception e) {
			System.out.println(("Class: WebDriverUtils, Method:WebDriverUtils - Exception Message : " + e));
		}
	}


	
	public void openPage(String url) throws Exception {

		driver.manage().window().maximize();

		driver.get(url);

	}



	public boolean fluentWait(final WebElement object, int seconds,String searchElement) {

		boolean elementAvailablityStatus;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class);
		try {
			wait.until(new Function<WebDriver, WebElement>(){

				@Override
				public WebElement apply(WebDriver input) {
					if(object.isDisplayed()) {
						return object;
					}
					else {
						return null;
					}
				}});
			elementAvailablityStatus = object.isDisplayed();
			if(searchElement.length()>0) {
				System.out.println("Inside the Fluent wait,  " + seconds + " seconds - "+searchElement+ " Element will be searched");
				System.out.println(searchElement+" Element isPresent? FluentWait Return value : " + object.isDisplayed());
			}
		}catch(Exception e) {
			elementAvailablityStatus  = false;
			if(searchElement.length()>0) {
				System.out.println(searchElement+" Element isPresent? FluentWait Return value : " + elementAvailablityStatus);
			}
		}
		return elementAvailablityStatus;


	}
	
	



}
