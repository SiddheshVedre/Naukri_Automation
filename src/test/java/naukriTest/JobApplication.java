package naukriTest;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Setup;
import listeners.ListenerNaukri;

@Listeners(ListenerNaukri.class)
public class JobApplication extends Setup {


	@Test(priority = 1)
	public void jobSearchBar()  {


		// Interact with the search bar
		WebElement jobSearchBar = driver.findElement(By.xpath(properties.getProperty("jobSearchBar")));
		jobSearchBar.click();

		WebElement designation = driver.findElement(By.xpath(properties.getProperty("designation")));
		designation.sendKeys(properties.getProperty("Enterdesignation"));

		WebElement experience = driver.findElement(By.xpath(properties.getProperty("experience")));
		experience.click();

		WebElement tellExperience = driver.findElement(By.xpath(properties.getProperty("tellExperience")));
		tellExperience.click();

		WebElement jobLocationclick = driver.findElement(By.xpath(properties.getProperty("jobLocationclick")));
		jobLocationclick.click();
		jobLocationclick.sendKeys(properties.getProperty("enterLocation"));


		WebElement popupSearchButton = driver.findElement(By.xpath(properties.getProperty("popupSearchButton")));
		popupSearchButton.click();
	

		// Create an instance of Actions class
		Actions actions = new Actions(driver);    

		// Find job applications
		List<WebElement> applications = driver.findElements(By.xpath("//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']"));

		// Click on the 20 applications
		for (int i = 0; i < 7 && i < applications.size(); i++) 
		{
			actions.moveToElement(applications.get(i)).click().perform();
		}

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		String parentWindow = iterator.next(); // Get the parent window

		// Store child windows in a list for dynamic handling
		List<String> childWindows = new ArrayList<>();
		while (iterator.hasNext()) 
		{
			childWindows.add(iterator.next());
		}


		// Define the XPath for the button
		String buttonXPath = properties.getProperty("buttonXPath");

		// Switch to each child window, take a screenshot, and perform the action
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i < childWindows.size(); i++) 
		{

			String childWindow = childWindows.get(i);
			driver.switchTo().window(childWindow);
/*
			WebElement elementToCapture = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='styles_jd-header-comp-name__MvqAI']/a[contains(@href, 'naukri.com')])[1]")));
			actions.moveToElement(elementToCapture).perform();

			String companyName = elementToCapture.getText();        

			// Take a screenshot of the specific element
			File elementScreenshot = elementToCapture.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(elementScreenshot, new File(".\\screenshots\\" + companyName + ".png"));
*/

			// Perform the action 
			WebElement companyApplyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
			companyApplyButton.click();
		}

		// Switch back to the parent window if needed
		driver.switchTo().window(parentWindow);
	}
}
