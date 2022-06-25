package cucumber;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	
	static WebDriver driver  ;
	
	@SuppressWarnings("deprecation")
	@Given("user to launch flipkart app")
	public void user_to_launch_flipkart_app()
	{
		
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   ((WebDriver) driver).get("https:\\flipkart.com");
	   ((WebDriver) driver).manage().window().maximize();
	   ((WebDriver) driver).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   
	}
	
	@Given("user able to login with credentials")
	public void user_able_to_login_with_credentials()
	{
		WebElement login=driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		login.click();
	}

	@When("user searching mobiles and choose one")
	public void user_searching_mobiles_and_choose_one() 
	{
		WebElement search=((WebDriver) driver).findElement(By.xpath("//input[@name='q']"));
	    search.sendKeys("Redmi mobiles",Keys.ENTER);
	    String mobile=search.getText();
	    System.out.println("Mobile Names:" +mobile);
	    
	    search.click();
	    		  
	}

	@When("add to cart the mobile and doing payment")
	public void add_to_cart_the_mobile()
	{
		String parent=((WebDriver) driver).getWindowHandle();
		
		Set<String> child=((WebDriver) driver).getWindowHandles();
		{
			for(String x1:child)
			{
				if(!x1.equals(parent))
				{
					((WebDriver) driver).switchTo().window(x1);
					System.out.println("Window Switched");
					
				}
			}
			
		}
		
				
	   
	}

	

	@Then("I validate the confirmation message")
	public void i_validate_the_confirmation_message()
	{
		System.out.println("Message");
		WebElement buy=((WebDriver) driver).findElement(By.xpath("//button[text()='BUY NOW]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)", buy);
		String text=buy.getText();
		
		Assert.assertTrue(buy.isDisplayed());
		Assert.assertEquals("BUY NOW", text);
		
		
		
	    
	}

	

}
