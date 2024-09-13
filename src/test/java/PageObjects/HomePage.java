package PageObjects;

import java.io.IOException;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) throws IOException {
		super(driver);
	}

@FindBy(xpath= "//span[@class='nI-gNb-sb__placeholder']")
WebElement btnjobSearchBar;

@FindBy(xpath= "//input[@placeholder='Enter keyword / designation / companies']")
WebElement txtdesignation;


@FindBy(xpath= "//*[@id='experienceDD']")
WebElement btnexperience;
	
@FindBy(xpath= "(//ul)[9]/child::li")
List<WebElement> btntellExperience;



@FindBy(xpath= "//input[@placeholder='Enter location']")
WebElement txtjobLocationclick;

@FindBy(xpath= "//span[normalize-space()='Search']")
WebElement btnpopupSearch;

@FindBy(xpath= "(//a[@class='nI-gNb-menuItems__anchorDropdown']/div)[1]")
WebElement eleJob;

@FindBy(xpath= "//div[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']")
List<WebElement> applications;

	
	public void SearchBar(String designation,String jobLocationclick, String  experience) {
		
		//logger.info("---Search Bar opration happning---");
		btnjobSearchBar.click();
		txtdesignation.sendKeys(designation);
		btnexperience.click();
		
		
		selectExperience(Integer.parseInt(experience));
		
		
		txtjobLocationclick.sendKeys(jobLocationclick);
		btnpopupSearch.click();	
	}
	
	
	public String getConfirmation() {
		try {
			return (eleJob.getText());
		}catch(Exception e){
			return (e.getMessage());
		}
		
		
	}
	
	
	public void selectExperience(int index) {
		
        // Check if the index is valid
        if (index >= 0 && index < btntellExperience.size()) {
            // Get the element from the list using the index and click it
            WebElement liElement = btntellExperience.get(index);
            liElement.click();
            
        } else {
            System.out.println("Invalid index: " + index);
        }	
	}
	
	
	public void applications(int applications2) {
		
		Actions actions = new Actions(driver);
		
		
		// Click on the 20 applications
		for (int i = 0; i < applications2 && i < applications.size(); i++) 
		{
			actions.moveToElement(applications.get(i)).click().perform();
		}
		
	

	}
	
}
