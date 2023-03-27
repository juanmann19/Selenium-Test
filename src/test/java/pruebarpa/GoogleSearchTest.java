package pruebarpa;
import java.io.IOException;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	private WebDriver driver;
	
	@Before
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Fifa World Cup");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		assertEquals("Fifa World Cup - Buscar con Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		  System.out.println("Press any key to close the browser window...");
		  try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
	}
	
	
}
