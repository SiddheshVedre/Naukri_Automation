package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewProfilePage extends BasePage {
	
	
	
	public ViewProfilePage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	
@FindBy(xpath = "//*[@Class='icon edit ']")
WebElement btnEditIcaon;

@FindBy(xpath = "//*[text()='Save']")
WebElement btnSave;




	public void UpdateProfile() {
		btnEditIcaon.click();
		btnSave.submit();
		
	}
}
