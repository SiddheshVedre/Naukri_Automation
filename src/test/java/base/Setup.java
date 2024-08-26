package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

	public static WebDriver driver;
	public  Properties properties = new Properties();


	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void login() throws IOException {

		FileReader config = new FileReader("C:\\Practice_workspace\\NaukriTesting\\src\\test\\resources\\configfiles\\config.properties");
		properties.load(config);

		FileReader locators = new FileReader("C:\\Practice_workspace\\NaukriTesting\\src\\test\\resources\\configfiles\\locators.properties");
		properties.load(locators);

		FileReader searchInfo = new FileReader("C:\\Practice_workspace\\NaukriTesting\\src\\test\\resources\\configfiles\\searchInfo.properties");
		properties.load(searchInfo);
		
	
 
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(properties.getProperty("url"));
		}
		else if(properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(properties.getProperty("url"));

		}
		else if(properties.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(properties.getProperty("url"));

		}
		else {

			throw new IllegalArgumentException("Browser type not supported");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);		
	}


	@BeforeTest
	public void LoginInfo() throws IOException {

		FileReader loginInfo = new FileReader("C:\\Practice_workspace\\NaukriTesting\\src\\test\\resources\\configfiles\\login.properties");
		properties.load(loginInfo);

		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();

		// Locate and fill the email/username field
		WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")); // replace with the actual ID
		emailField.sendKeys(properties.getProperty("username"));

		// Locate and fill the password field
		WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter your password']")); // replace with the actual ID
		passwordField.sendKeys(properties.getProperty("password"));

		// Locate and click the login button within the popup
		WebElement popupLoginButton = driver.findElement(By.xpath("//button[@type='submit']")); // replace with the actual ID
		popupLoginButton.click();	

	}


	@AfterSuite(enabled=false)
	public void teardown() {

		if(driver!=null){	
			driver.quit();
		}

	}

}
