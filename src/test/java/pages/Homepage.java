package pages;



import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import Utils.WebDriverUtils;


public class Homepage {

	WebDriver driver;
	WebDriverUtils wdutils;
	
	
	static String product_Price="";
	

	public Homepage(WebDriver driver) {
		this.driver = driver;
		wdutils = new WebDriverUtils(driver);

	}
	
	
	@FindBy(how = How.CLASS_NAME, using = "_2zrpKA")
	WebElement Username;
	

	@FindBy(how = How.XPATH, using ="//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1avdGP']/button")
	WebElement loginbtn;
	

	@FindBy(how = How.XPATH, using = "//div[@class='O8ZS_U']/input")
	WebElement SearchArea;
	 

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Sony CyberShot DSC-H300')]")
	WebElement productLink;
	  
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_31gTpz _1RLi8m']/form/button")
	WebElement placeOrder;
	
	
	



	public void login(String className) throws InterruptedException {
		
			//login to the application,hiding my login details
			Username.sendKeys("8*******");
			password.sendKeys("**********");
			loginbtn.submit();
	
		
		
	}

	public void SearchText(String string) throws InterruptedException {
			System.out.println("search text is"+string);
			//Waiting for search area to be displayed
			if(wdutils.fluentWait(SearchArea, 60,"SearchArea")) 
			{
				SearchArea.sendKeys(string);
				System.out.println(string+" is entered as search element");
			
			}	
		
			else
			{
				System.out.println("SearchArea Element no prsent");
			}
		
	
		
	}
	
	
	public void Search(String className) throws Exception {
		
		          SearchArea.sendKeys(Keys.ENTER);
		          
		          //Waiting for particular element to be displayed
				  WebDriverWait wait = new WebDriverWait(driver, 40);
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Sony CyberShot DSC-H300')]")));
				  Thread.sleep(1000);
				  
				  //Scrolling till the element is found
				  JavascriptExecutor jse = (JavascriptExecutor)driver;
				  jse.executeScript("window.scrollBy(0,250)", "");
				  
				  
	}
		
	public void ExtractingProductDetails(String className) throws Exception {
		
	              //Getting price of the product in product details page
				  WebElement cam=driver.findElement(By.xpath("//div[contains(text(),'Sony CyberShot DSC-H300')]/parent::div/following-sibling::div/div/div/div"));
				  String[] price=cam.getText().split("₹");
				  product_Price=price[1];
				  
				  System.out.println("product price in product detail page "+product_Price);
				  
				  //Clicking on product
				  productLink.click();
	}			  
	
	





	



	
	
	
}	