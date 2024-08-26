package naukriTest;

import java.time.Duration;

import org.openqa.selenium.By;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Setup;

public class ProfileUpdateTest extends Setup {
	
	
	@Test
	public void profileUpdate() throws InterruptedException {
		
		
		Actions actions = new Actions(driver);
		SoftAssert softA = new SoftAssert();
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
		
	   /*
		 WebElement profileImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nI-gNb-drawer__bars']")));
	        WebElement profileImg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View & Update Profile']")));
	        WebElement profileUpadeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='icon edit']")));
	        
	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profileImg);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profileImg2);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profileUpadeIcon);
	        
	        

	        // Perform actions
	        actions.moveToElement(profileImg)
	               .click()
	               .moveToElement(profileImg2)
	               .click()
	               .moveToElement(profileUpadeIcon)
	               .click()
	               .perform();
	        
	     */
		
		
		WebElement profileImg = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']"));
		profileImg.click();
		
		WebElement profileImg2 = driver.findElement(By.xpath("//a[text()='View & Update Profile']"));
		profileImg2.click();
		
		WebElement profileUpadeIcon = driver.findElement(By.xpath("//em[@class='icon edit']"));
		profileUpadeIcon.click();

		
		
		WebElement inputSalary = driver.findElement(By.xpath("//div[@class='currency-input-container']//input[@type='text']"));
		inputSalary.click(); // Click to focus the field
		inputSalary.sendKeys(Keys.CONTROL + "a"); // Select all text
		inputSalary.sendKeys(Keys.DELETE); // Delete the selected text
		inputSalary.sendKeys("800000");
		
		
		
		WebElement profileUpdateSave = driver.findElement(By.xpath("//div[@class='action s12']//button"));
		
		actions.click(profileUpdateSave).click(profileUpdateSave).perform();
		
		
		
		Thread.sleep(5000); 
		
		String ExpectedResult = "8,00,000";
		WebElement ActualResultElement = driver.findElement(By.xpath("//span[@name='Salary']//span[2]"));
		String ActualResult = ActualResultElement.getText();
	
		softA.assertEquals(ActualResult, ExpectedResult, "Test Failed");
		softA.assertAll();
		
		
		
		
		
		
		//driver.quit();
		
		
		
	}

}
