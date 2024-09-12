package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
	}

@FindBy(xpath= "//a[@id='login_Layer']")
WebElement btnLoginBtn;

@FindBy(xpath= "//input[@placeholder='Enter your active Email ID / Username']")
WebElement txtEmailField;


@FindBy(xpath= "//input[@placeholder='Enter your password']")
WebElement txtPasswordField;
	
@FindBy(xpath= "//button[@type='submit']")
WebElement btnPopupLoginButton;



public void LoginInfo(String username, String password) {
	
	btnLoginBtn.click();
	txtEmailField.sendKeys(username);
	txtPasswordField.sendKeys(password);
	btnPopupLoginButton.click();
 }

}

