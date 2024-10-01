package TestCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ViewProfilePage;
import utilities.DataProviderClass;
import utilities.ListenerNaukri;


@Listeners(ListenerNaukri.class)
public class TC002_ProfileUpdateDaily extends BaseClass {
	
	
	@Test(groups= {"Regression_Testing","Master"},dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
	public void ProfileUpdate(String username,String password) throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ViewProfilePage pp = new ViewProfilePage(driver);
		
		SoftAssert softAssert = new SoftAssert();
		
		
		
		lp.LoginInfo(username, password);
		hp.clickonProfile();
		pp.UpdateProfile();
		
		driver.quit();
		
		softAssert.assertAll();
		
		
	
	}

}
