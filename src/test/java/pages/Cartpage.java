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


public class Cartpage {

	WebDriver driver;
	WebDriverUtils wdutils;
	
	static String cart_Price="";
	
	

	public Cartpage(WebDriver driver) {
		this.driver = driver;
		wdutils = new WebDriverUtils(driver);

	}
	

	 

	  
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_31gTpz _1RLi8m']/form/button")
	WebElement placeOrder;
	
	

	public void AddProductToCart(String className) {
		
		
		  		//Getting all the windows which are open
		  		Set <String> ids=driver.getWindowHandles();
		  		Iterator <String>it=ids.iterator();
		  		it.next(); 
		  
		  		//Moving the control of driver to product details page
		  		driver.switchTo().window(it.next());
		
		  		addToCart.click();
   }
	
				  
	public void ExtractingCartDetails(String className) throws Exception {		
		
		          //Grabbing product price from cart details page
		          Thread.sleep(1000);
				  String[] cartPrice=driver.findElement(By.xpath("//div[@class='_3vIvU_']/span[1]")).getText().split("₹");
				  cart_Price=cartPrice[1];
				  
				  System.out.println("Product price in cart detail page "+cart_Price);
	}
	
	
	public void orderPlace(String className) throws Exception {		
		
	             //Comparing the prices
				 Assert.assertEquals(cart_Price, Homepage.product_Price);
				 System.out.println("Product detail Matching");
				 
				
				 
				 //Order placing
				 placeOrder.click();
			
	}

	

	
	
}