package PageObjects;

import java.io.IOException;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

// >>>>>>>>>>>>>>>>>>>  Home : Page Class  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class HomePage extends BasePage {
	
	// >>>>>>>>>>>>>>>>>>>>>>>  HomePage Constructor  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public HomePage(WebDriver driver) throws IOException {
		super(driver);
	}

//  >>>>>>>>>>>>>>>>>>>>>>>>>  Elements Locatores	<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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

@FindBy(xpath= "//a[text()='View']")
WebElement btnViewProfile;

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Handling Search Bar Opration <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public void SearchBar(String designation,String jobLocationclick, String  experience) {
		
		//logger.info("---Search Bar opration happning---");
		btnjobSearchBar.click();
		txtdesignation.sendKeys(designation);
		btnexperience.click();
		
		
		selectExperience(Integer.parseInt(experience));
		
		
		txtjobLocationclick.sendKeys(jobLocationclick);
		btnpopupSearch.click();	
	}
	
	
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>> Getting the confirmation  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	public String getConfirmation() {
		try {
			return (eleJob.getText());
		}catch(Exception e){
			return (e.getMessage());
		}
		
		
	}
	
//  >>>>>>>>>>>>>>>>>>>>>>  Selecting Experience on Job Serach Bar  <<<<<<<<<<<<<<<<<<<<<<<<<
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
	
// >>>>>>>>>>>>>>>>>>>>>>>>> Selecting Applications Passed in Excel File  <<<<<<<<<<<<<<<<<<<<<<<<<
	public void applications(int applications2) {
		
		Actions actions = new Actions(driver);
		
		
		// Click on the 20 applications
		for (int i = 0; i < applications2 && i < applications.size(); i++) 
		{
			actions.moveToElement(applications.get(i)).click().perform();
		}
	
	}
	

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Click On View Profile Button  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	public void clickonProfile(){
		
		btnViewProfile.click();
	}
	
}
