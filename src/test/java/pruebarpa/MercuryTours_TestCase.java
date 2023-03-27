package pruebarpa;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MercuryTours_TestCase {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By registerUserNameLocator = By.id("email");
	
	By registerPasswordLocator = By.name("password");
	By registerConfirmPasswordLocator = By.name("confirmPassword");
	By registerSubmitBtn = By.name("submit");
	
	By userLocator = By.name("userName");
	By passwordLocator = By.name("password");
	By btnSubmit =  By.name("submit");
	By loginConfirmationLocator = By.tagName("h3");
	
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(registerUserNameLocator).sendKeys("Admin");
			driver.findElement(registerPasswordLocator).sendKeys("Hol@123");
			driver.findElement(registerConfirmPasswordLocator).sendKeys("Hol@123");
			driver.findElement(registerSubmitBtn).click();
			Thread.sleep(2000);
		}
		else {
			System.out.print("Page was not found");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is Admin.", fonts.get(5).getText());
	}
	
	@Test
	public void SignIn() throws InterruptedException {
		
		
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("Admin");
			driver.findElement(passwordLocator).sendKeys("Hol@123");
			driver.findElement(btnSubmit).click();
			Thread.sleep(2000);
			assertEquals("Login Successfully", driver.findElement(loginConfirmationLocator).getText());
			
		}
		
		else
		{
			System.out.print("User name textbox was not present");
		}
		
	}

}
