package TestCases;





import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public Properties properties = new Properties();
    
   
//  >>>>>>>>>>>>>>>>>>>>>  Before Test Run  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	@SuppressWarnings("deprecation")
	@Parameters({ "browser", "os", "url" }) // --------- XML Properties Parameters  --------------------
	@BeforeTest
	public void setup(String browser, String os, String url, ITestContext context) throws IOException { 
																										

		//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Property Files  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		try {
			FileReader config = new FileReader(".\\src\\test\\resources\\configfiles\\config.properties");
			properties.load(config);
		} catch (Exception e) {
			System.out.println("file reader issue");
			e.printStackTrace();

		}

		System.out.println("---FileReader Works Perfectly---");

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Local Testing code <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		if (properties.getProperty("execution_env").equalsIgnoreCase("Local")) {

	        	
			try {
			   //  ----------------------------------  Local Chrome Setup  --------------------------
				if (browser.equalsIgnoreCase("chrome")) {

					
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(url);

					driver.manage().window().maximize();
					System.out.println("---Browser Mximizing Perfectly---");
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
					System.out.println("---BaseClass work and Close perfectly---");
				
				//  ----------------------------------  Local FireFox Setup  --------------------------
				} else if (browser.equalsIgnoreCase("firefox")) {

					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.get(url);

					driver.manage().window().maximize();
					System.out.println("---Browser Mximizing Perfectly---");
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
					System.out.println("---BaseClass work and Close perfectly---");
		
				//  ----------------------------------  Local Edge Setup  -----------------------------
				} else if (browser.equalsIgnoreCase("edge")) {

					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					driver.get(url);

					driver.manage().window().maximize();
					System.out.println("---Browser Mximizing Perfectly---");
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
					System.out.println("---BaseClass work and Close perfectly---");
					
				} else {

					throw new IllegalArgumentException("Browser type not supported");
				}

			} catch (Exception e) {
				System.out.println("Local Browser Configration issue");
				e.printStackTrace();
			}

		}

		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  REMOTE Testing code <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		if (properties.getProperty("execution_env").equalsIgnoreCase("Remote")) {

			// Remote Browser Setting here
			DesiredCapabilities capable = new DesiredCapabilities();

			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Remote OS  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			if (os.equalsIgnoreCase("windows")) {

				// Windows os initilization
				capable.setPlatform(Platform.WIN11);

			} else if (os.equalsIgnoreCase("mac")) {

				// Windows os initilization
				capable.setPlatform(Platform.MAC);

			} else {
				throw new IllegalArgumentException("Invalid OS entered");
				

			}
			
			System.out.println("Remote Browser Collect Perfectly");

			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>  Remote Browsers  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			switch (browser.toLowerCase()) {
			case "chrome":
				capable.setBrowserName("chrome"); //----- Remote Chrome  -----
				break;
				
			case "edge":
				capable.setBrowserName("Edge");   //-----  Remote  Edge  -----
				break;
				
			case "firefox":
				capable.setBrowserName("firefox"); //-----  Remote  Firefox  -----
				break;
					
			default:
				throw new IllegalArgumentException("Invalid OS entered");
				
			}
			
			System.out.println("Remote OS Collect Perfectly");

			// >>>>>>>>>>>>>>>>>>>>>>>  Assign Selenium Hub Server to the Driver <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			   try {
			        driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444"), capable);
			    } catch (MalformedURLException e) {
			    	System.out.println("URL Error");
			        throw new RuntimeException("Invalid RemoteWebDriver URL", e);
			    }
			   
			   System.out.println("Remote URL Collect Perfectly");
			   
			 // >>>>>>>>>>>>>>>>>>>>>>  Remote Driver Config  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			    driver.get(url);
			    
				driver.manage().window().maximize();
				System.out.println("---Browser Mximizing Perfectly---");
				
				
			// >>>>>>>>>>>>>>>>>>>  Implicit Wait  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				System.out.println("---BaseClass work and Close perfectly---");
				
				System.out.println("Remote Naukri.com Collect Perfectly & Open");

		}
	}
       
    
    
	
//  >>>>>>>>>>>>>>>>>>>>>>>>>  After Test Run  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
    @AfterTest(enabled = false)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
    
    
    

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Method to Capture a Screenshot  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public String captureFailureScreenshot(WebDriver driver, String testName) throws IOException {
        String screenshotPath = null;
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
            screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
            FileUtils.copyFile(sourceFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
    
   

}
