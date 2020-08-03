package src.PatientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;  

	@BeforeTest
	public void launchBrowser() throws InterruptedException
	{
		//Launch's Browser 
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.gecko.driver",path+"\\lib\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.accesselitenow.com");	 
		Thread.sleep(5000);
	}

	@Test(priority=1)
	public void signUp() throws InterruptedException
	{
		//Clicks on SignUp
		driver.findElement(By.xpath("//p[@class='elite-form-signup']/a")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Test(priority=2)
	public void phoneNo() throws InterruptedException, AWTException
	{
		//Clicks on PhoneNumber
		driver.findElement(By.xpath("//form[@class='new_user']/div/p[3]/a")).click();
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
	}

	@Test(priority=3)
	public void forgotPassword() throws InterruptedException
	{
		//Opens the forgot password with email as empty.
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		Thread.sleep(5000);

	}

	@Test(priority=4)
	public void prePopulatedmail() throws InterruptedException
	{
		//Opens forgot password with email as pre-populated from the login screen.
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+34@conciergekeyhealth.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click(); 

	}

	@Test(priority=5)
	public void closePopup() throws InterruptedException
	{
		//Close the pop-up
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=6)
	public void resetPassword() throws InterruptedException
	{
		//Reset mail-id with reset link
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='elite-login-form']/p[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='forgot_password_email']")).sendKeys("nm+34@conciergekeyhealth.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
	}

	@Test(priority=7)
	public void login() throws InterruptedException
	{
		//Submit without any mail-id and password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);

	}

	@Test(priority=8)
	public void loginEmail() throws InterruptedException
	{
		//Valid mail-id without password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+testcorporate@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=9)
	public void invalidEmail() throws InterruptedException
	{
		//Invalid mail-id
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qao.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=10)
	public void invalidSignin() throws InterruptedException
	{
		//Invalid mail-id & Invalid Password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaop@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("password");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}

	@Test(priority=11)
	public void signIn() throws InterruptedException
	{
		//Valid mail-id & Valid Password
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaboth@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("Password1");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}
}
