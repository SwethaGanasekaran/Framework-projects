package Junit;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobilepurchase 
{
	static Object WebDriver;
	@SuppressWarnings("deprecation")
	
	@BeforeClass
	public static void launch()
	{
		WebDriverManager.chromedriver().setup();
		   WebDriver=new ChromeDriver();
		   ((WebDriver) WebDriver).get("https:\\flipkart.com");
		   ((WebDriver) WebDriver).manage().window().maximize();
		   ((WebDriver) WebDriver).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   
		}
	@AfterClass
    public static void quit()    
    {
		System.out.println("Quit");
		((WebDriver) WebDriver).quit();
		
    }
	@Test
	public void Method1()
	{
		//login
		System.out.println("Method 1");
		WebElement login=((WebDriver) WebDriver).findElement(By.xpath("/html/body/div[2]/div/div/button"));
		login.click();
		
	}
	@Test
	public void Method2()
	{
		//search
		System.out.println("Method 2");
		WebElement search=((WebDriver) WebDriver).findElement(By.xpath("//input[@name='q']"));
	    search.sendKeys("Redmi mobiles",Keys.ENTER);
	    String mobile=search.getText();
	    System.out.println("Mobile Names:" +mobile);
	    
	    search.click();
	}
	@Test
	public void Method3()
	{
		//windows
		System.out.println("Method 3");
		String parent=((WebDriver) WebDriver).getWindowHandle();
		
		Set<String> child=((WebDriver) WebDriver).getWindowHandles();
		for(String x1:child)
		{
			if(!x1.equals(parent))
			{
				((WebDriver) WebDriver).switchTo().window(x1);
				System.out.println("Window Switched");
				
			}
		}
		}
		
	@Ignore
	@Test    
	public void Method4() 
	 {
		//addToCart
		System.out.println("Add To Cart");
		System.out.println("DropDown & Screenshot");
		WebElement buy=((WebDriver) WebDriver).findElement(By.xpath("//button[text()='BUY NOW]"));
		JavascriptExecutor js=(JavascriptExecutor)WebDriver;
		js.executeScript("argument[0].scrollIntoView(true)", buy);
		String text=buy.getText();
		
		Assert.assertTrue(buy.isDisplayed());
		Assert.assertEquals("BUY NOW", text);
				
	}
	}




