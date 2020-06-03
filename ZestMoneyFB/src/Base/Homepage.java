package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	protected WebDriver driver;
	public static Properties prop;
	static {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"C:\\Users\\vebbler-11\\eclipse-workspace\\ZestMoneyFB\\src\\Base\\data.properties");
			prop.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Homepage(ChromeDriver driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return prop.getProperty("email");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public WebElement email() {
		return driver.findElement(By.xpath("//input[@id='email']"));
	}

	public WebElement password() {
		return driver.findElement(By.xpath("//input[@id='pass']"));
	}

	public WebElement submit() {

		return driver.findElement(By.id("u_0_b"));
	}

	public void createpost(String post) {
		driver.findElement(By.xpath("//textarea[@name='xhpc_message']")).sendKeys(post);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Post']"))).click();
	}

	public WebElement Post() {
		return driver.findElement(By.xpath("//div[@contenteditable='true']"));
	}
}
