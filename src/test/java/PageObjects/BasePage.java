package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


//  >>>>>>>>>>>>>>>>>  Base : Page PageFactory Class  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class BasePage {

	// >>>>>>>>>>>>>>>>>>>>>>>>  Base Page Class Driver  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	WebDriver driver;
	
    // >>>>>>>>>>>>>>>>>>>>>>>>  PageFactory Method With driver Cunstructor  <<<<<<<<<<<<<<<<<<<<<< 
	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
