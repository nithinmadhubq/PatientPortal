package src.PatientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class EventTest extends HomeTest
{
	@Test(priority=19)
	public void navigateToEvent() throws InterruptedException
	{
		//Navigating to event page
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='patient-sidebar']/ul[1]/a[2]/li")).click();
	}

	@Test(priority=20)
	public void keywordData() throws InterruptedException
	{
		//Entering random data into keyword
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='event_keyword']")).sendKeys("Wellness");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn submit-search-btn']")).click();
		Thread.sleep(4000);	
		driver.findElement(By.xpath("//input[@id='event_keyword']")).clear();
		Thread.sleep(4000);
	}

	@Test(priority=21)
	public void Category() throws InterruptedException
	{
		//Clicking on category tab
		driver.findElement(By.xpath("//input[@id='event_category']")).click();
		Thread.sleep(5000);	
	}

	@Test(priority=22)
	public void selectAll() throws InterruptedException
	{
		//Selecting all events
		WebElement ele=driver.findElement(By.xpath("//input[@id='event-select-all']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn submit-search-btn']")).click();
		Thread.sleep(4000);
		WebElement deselect=driver.findElement(By.xpath("//input[@id='event-select-all']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", deselect);
		Thread.sleep(4000);
	}

	@Test(priority=23)
	public void reSet() throws InterruptedException
	{
		//reset of data
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='event_keyword']")).sendKeys("Wellness");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//button[@class='see-all search-btn reset-search-btn']")).click();	
	}

	@Test(priority=24)
	public void selectMutipleCategory() throws InterruptedException
	{
		//selection of multiple category
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='event_category']")).click();
		Thread.sleep(5000);	
		WebElement ele=driver.findElement(By.xpath("//input[@id='category6']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//input[@id='category7']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn submit-search-btn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn reset-search-btn']")).click();	
	}

	@Test(priority=25)
	public void todayEvents() throws InterruptedException
	{
		//Switching to Today's event
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@class='view_events nav-link']")).click();
	}

	@Test(priority=26)
	public void myEvents() throws InterruptedException
	{
		//Switching to myEvents
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@class='view_events nav-link']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=27)
	public void allEvents() throws InterruptedException
	{
		//Switching to allEvents
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='allEventsPage']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=28)
	public void selectingEvent() throws InterruptedException
	{
		//Switching to register tab
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='events-page-table3']/tbody/descendant::span[@class='services-name']"));
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			if(listitem.contains("2020 Golden Future 50+ Expo - Orange County Edition"))
			{
				list.get(i).click();
			}
		}
		Thread.sleep(6000);
	}

	@Test(priority=29)
	public void addToCalendar() throws InterruptedException, AWTException
	{
		//Adding event to calendar	
		WebElement ele=driver.findElement(By.xpath("//div[@class='event-more-content']/div[3]/div[3]/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(8000);
		Robot robot=new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_W);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
}
