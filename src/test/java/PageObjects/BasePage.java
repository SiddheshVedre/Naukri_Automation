package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;



public class BasePage {

	WebDriver driver;
	

	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
