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


import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass  {

	public WebDriver driver;
	public Logger logger;
	public Properties properties = new Properties();
	
  

	@SuppressWarnings("deprecation")
	@BeforeSuite

	public void setup() throws IOException {

		logger = LogManager.getLogger(this.getClass());


		logger.info("---Starting the Selenium Test Suite---");

		FileReader config = new FileReader("C:\\Practice_workspace\\NaukriTesting\\src\\test\\resources\\configfiles\\config.properties");
		properties.load(config);

		logger.info("---FileReader Works Perfectly---");

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

		logger.info("---Browser Mximizing Perfectly---");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		logger.info("---BaseClass work and Close perfectly---");
	}

	@AfterSuite(enabled = true)
	public void teardown() {

		logger.info("---Windows Close Perfectly---");
	
		if (driver != null) {
			driver.quit();
			
		logger.info("---Next Browser Opning---");	
		}

	}

}
