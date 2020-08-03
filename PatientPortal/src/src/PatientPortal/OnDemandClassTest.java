package src.PatientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class OnDemandClassTest extends EventTest
{
	@Test(priority=30)
	public void navigateToOnDemandClass() throws InterruptedException
	{	
		//Navigating to onDemand Classes
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='patient-sidebar']/ul[1]/a[3]/li")).click();
		Thread.sleep(5000);
	}

	@Test(priority=31)
	public void keyword() throws InterruptedException
	{
	    //Entering random data into keyword
		driver.findElement(By.xpath("//input[@id='article_keyword']")).sendKeys("Fitness");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-submit-search-btn']")).click();
		Thread.sleep(6000);
	}

	@Test(priority=32)
	public void selectCategory() throws InterruptedException
	{
	    //Clicking on select category
		driver.findElement(By.xpath("//input[@id='article_type']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=33)
	public void selectAllOption() throws InterruptedException
	{
	    //Selecting all category
		WebElement ele=driver.findElement(By.xpath("//input[@id='type-select-all']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-submit-search-btn']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=34)
	public void contentType() throws InterruptedException
	{
	    //Clicking on content type
		driver.findElement(By.xpath("//input[@id='content_type']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=35)
	public void selectAllContent() throws InterruptedException
	{
	    //Selecting all content type
 		WebElement ele=driver.findElement(By.xpath("//input[@id='content-select-all']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-submit-search-btn']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=36)
	public void reSetData() throws InterruptedException
	{
	 //reset data
     driver.findElement(By.xpath("//button[@class='see-all search-btn article-reset-search-btn']")).click();
     Thread.sleep(5000);
	}

	@Test(priority=37)
	public void MultipleCategory() throws InterruptedException
	{
	    //Selecting multiple category
		driver.findElement(By.xpath("//input[@id='article_type']")).click();
		Thread.sleep(5000);	
		WebElement ele=driver.findElement(By.xpath("//input[@id='articleType8']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//input[@id='articleType5']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-submit-search-btn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-reset-search-btn']")).click();		
	}

	@Test(priority=38)
	public void selectContentType() throws InterruptedException
	{
	    //Selecting specific content type
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='content_type']")).click();
		Thread.sleep(4000);
	    WebElement element=driver.findElement(By.xpath("//input[@id='articleTypePodcasts']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-submit-search-btn']")).click();
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='see-all search-btn article-reset-search-btn']")).click();
	}

	@Test(priority=39)
	public void popUpWindow() throws InterruptedException
	{
		//Clicking on popUp window
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='content-library-table2']/tbody/descendant::span[@class='services-discount']"));
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			if(listitem.contains("In need of a sweat? Join Fitness Trainer"))
			{
				list.get(i).click();
			}
		}
	}
	
	@Test(priority=40)
	public void switchWindow() throws InterruptedException
	{
		//Switching to new window
		Thread.sleep(5000);
		String oldTab=driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		for(String newtab:tabs)
		{
			if(!oldTab.equalsIgnoreCase(newtab))
			{
				driver.switchTo().window(newtab);
			}
		}
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test(priority=41)
	public void videoFunction() throws InterruptedException
	{
		//Clicking on video button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[3]/div/div/div/button")).click();
		Thread.sleep(6000);
	}

	@Test(priority=42)
	public void dragAndDrop() throws InterruptedException
	{
		//Forwarding video using drag function
		Thread.sleep(5000);
		WebElement drag=driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[4]/div/div/div/div[2]/div[1]"));
		System.out.println(drag.getText());  
		Actions action=new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(drag).dragAndDropBy(drag,250,250).build().perform();
		Thread.sleep(6000);
		
	}

	@Test(priority=43)
	public void handleVoiceButton() throws InterruptedException
	{
		//Handling mute & unMute function
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[1]")).click();
		Thread.sleep(7000);
	}

	@Test(priority=44)
	public void handleSpeed() throws InterruptedException
	{
		//Handling speed of video
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[3]/descendant::button[@id='w-Speed-accordion-title']/span[1]")).click();
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='w-accordion w-css-reset w-css-reset-tree']/div[1]/div/fieldset/descendant::label[@class='w-css-reset']"));
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			if(listitem.contains("0.5x"))
			{
				list.get(i).click();
			}
		}
		Thread.sleep(6000);
	}

	@Test(priority=45)
	public void handleQuality() throws InterruptedException
	{
		//Handling quality of video
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[3]/descendant::button[@id='w-Quality-accordion-title']/span[1]")).click();
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='w-accordion w-css-reset w-css-reset-tree']/div[2]/div/fieldset/descendant::label[@class='w-css-reset']"));
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			if(listitem.contains("224p"))
			{
				list.get(i).click();
			}
		}
		Thread.sleep(8000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[3]/div/div/div/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		Thread.sleep(6000);
	}

	@Test(priority=46)
	public void fullScreen() throws InterruptedException
	{
		//Handling full screen of video
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[4]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='w-bottom-bar-lower w-css-reset']/div[5]/div/div/div[4]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=47)
	public void postCommand() throws InterruptedException, AWTException
	{
		//Clicking on post Command Without any data 
		Robot robot=new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_END);
		Thread.sleep(7000);
		WebElement element=driver.findElement(By.xpath("//div[@class='actions']/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(5000);
	}

	@Test(priority=48)
	public void comment() throws InterruptedException
	{
		//Adding name of the patient name
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@class='collapsible comment']/div/div[2]/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@class='collapsible comment']/div/div[2]/input")).sendKeys("Lavanya");
		Thread.sleep(5000);
	}

	@Test(priority=49)
	public void message() throws InterruptedException
	{
		//Adding comments
		driver.findElement(By.xpath("//form[@class='collapsible comment']/div/div[2]/div[1]/textarea")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@class='collapsible comment']/div/div[2]/div[1]/textarea")).sendKeys("Wonderful");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='comment__timecode_checkbox']")).click();
	}

	@Test(priority=50)
	public void selectPostCommand() throws InterruptedException
	{
		//Submitting the post
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//form[@class='collapsible comment']/div/div[2]/div[2]/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='comment__timecode_checkbox']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=51)
	public void switchingControl() throws InterruptedException
	{ 
		//Switching back to default window
		Thread.sleep(5000);
		String newtab=driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		for(String oldTab:tabs)
		{
			if(!newtab.equalsIgnoreCase(oldTab))
			{
			     driver.switchTo().window(oldTab);
			}
		}
		Thread.sleep(5000);
	}

	@Test(priority=52)
	public void contactDetails() throws InterruptedException
	{	
		//Switching to contact details
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='patient-sidebar']/ul[2]/li/span")).click();
		Thread.sleep(5000);	
	}
	
	@Test(priority=53)
	public void phoneDetails() throws InterruptedException
	{
		//Clicking on phone number
		driver.findElement(By.xpath("//ul[@class='header-profile-dropdown profile-dropdown-open']/li[1]/a/span")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(4000);
	}

	@Test(priority=54)
	public void emailDetails() throws InterruptedException, AWTException
	{
		//Clicking on email address
		driver.findElement(By.xpath("//ul[@class='header-profile-dropdown profile-dropdown-open']/li[2]/a/span")).click();
		Thread.sleep(7000);
		Robot robot=new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ALT);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_F4);
		Thread.sleep(5000);  
		robot.keyRelease(KeyEvent.VK_F4);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='patient-sidebar']/ul[2]/li/img")).click();
		Thread.sleep(5000);	
	}
	
	@Test(priority=55)
	public void logout() throws InterruptedException, AWTException
	{
	    //logout function
		driver.findElement(By.xpath("//div[@class='patient-sidebar']/ul[3]/a/li")).click();
		Thread.sleep(7000);
	}
	
	@AfterTest
	public void quit() throws InterruptedException, AWTException
	{
	    //Quitting browser
		driver.quit();
	}
}

