package TestCases;

import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass  {

	public WebDriver driver;

	public Properties properties = new Properties();
	
  

	@SuppressWarnings("deprecation")
	@BeforeTest

	public void setup() throws IOException {

	


		

		FileReader config = new FileReader(".\\src\\test\\resources\\configfiles\\config.properties");
		properties.load(config);

		System.out.println("---FileReader Works Perfectly---");

		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(properties.getProperty("url"));

			
		} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	        driver.get(properties.getProperty("url"));
			

			
		} else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(properties.getProperty("url"));
			
		} else {

			throw new IllegalArgumentException("Browser type not supported");
		}

		System.out.println("---Browser Mximizing Perfectly---");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		System.out.println("---BaseClass work and Close perfectly---");
	}

	@AfterTest(enabled = true)
	public void teardown() {

		System.out.println("---Windows Close Perfectly---");
	
		if (driver != null) {
			driver.quit();
			
		System.out.println("---Next Browser Opning---");	
		
		}

	}

}
