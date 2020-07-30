package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.WebDriverUtils;
import dataproviders.dataprovidercode;
import driversetup.Tests;
import pages.Cartpage;
import pages.Homepage;


public class Flipkart extends Tests {
	WebDriver driver;
	WebDriverUtils wdutils;
	
	String className=this.getClass().getSimpleName();

	@BeforeMethod
	public void setUp() {
		
		driver = Tests.driver;
		wdutils = new WebDriverUtils(driver);
	}

	@Test(dataProviderClass = dataprovidercode.class, dataProvider = "Data_provider", priority = 1 )
	public void FirstpageTest(HashMap<String, String> obj) throws InterruptedException, FileNotFoundException, IOException, Exception {


		 


		Homepage FlipkrtHome = PageFactory.initElements(driver, Homepage.class);
		Cartpage FlipkrtCart = PageFactory.initElements(driver, Cartpage.class);
			wdutils.openPage("https://www.flipkart.com");
			
			FlipkrtHome.login(className);
			//Taking search element from Excel sheet
			FlipkrtHome.SearchText(obj.get("keyword"));
			FlipkrtHome.Search(className);
			FlipkrtHome.ExtractingProductDetails(className);
			FlipkrtCart.AddProductToCart(className);
			FlipkrtCart.ExtractingCartDetails(className);
			FlipkrtCart.orderPlace(className);

		}
}
