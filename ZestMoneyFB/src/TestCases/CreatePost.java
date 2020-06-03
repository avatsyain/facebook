package TestCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Homepage;

public class CreatePost {

	ChromeDriver driver;

	private static Logger LOG = Logger.getLogger(CreatePost.class.getName());

	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void createFBPostTest() {
		LOG.log(Level.INFO, "Starting the createFBPostTest");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Homepage hp = new Homepage(driver);
		hp.email().sendKeys(hp.getUserName());
		hp.password().sendKeys(hp.getPassword());
		hp.submit().click();
		LOG.log(Level.INFO, "Logged in Facebook");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
			hp.createpost("Hello World");
			Thread.sleep(3000);
			hp.Post().click();
			LOG.log(Level.INFO, "Existing createFBPostTest");
		} catch (InterruptedException e) {
			LOG.log(Level.SEVERE, "Thread sleep was intrrupted");
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
