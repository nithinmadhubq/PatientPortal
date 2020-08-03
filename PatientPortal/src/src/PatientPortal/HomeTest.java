package src.PatientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class HomeTest extends LoginTest
{
	@Test(priority=12)
	public void imageSelect() throws InterruptedException
	{
		//Switching images
		for(int i=0;i<=5;i++)
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='carousel-control-next']/img")).click();
			Thread.sleep(5000);
		}	
	}

	@Test(priority=13)
	public void myEvent() throws InterruptedException
	{ 
		//Switch to myEvent
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs events-tabs-section']/li[2]/a")).click();
		Thread.sleep(5000);
	}

	@Test(priority=14)
	public void eventSeeAll() throws InterruptedException
	{ 
		//Clicking on See all events
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='my-events']/div[1]/a/button")).click();
		Thread.sleep(5000);
	}

	@Test(priority=15)
	public void navigateBack() throws InterruptedException
	{
		//Navigating back to home page
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Test(priority=16)
	public void onDemandSeeAll() throws InterruptedException
	{
		//Clicking to see all onDemand classes
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all see-all-classes']")).click();		
	}

	@Test(priority=17)
	public void backToHome() throws InterruptedException
	{
		//Navigating back to home page
		Thread.sleep(5000);
		driver.navigate().back();
	}

	@Test(priority=18)
	public void onDemandalsses() throws InterruptedException, AWTException
	{	
		//Count of onDemand Classes
		Thread.sleep(4000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_END);
		Thread.sleep(4000);
		for(int i=0;i<=13;i++)
		{
			driver.findElement(By.xpath("//li[@id='content-library-table_next']/a")).click();
			Thread.sleep(4000);
		}
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_HOME);

	}
}
