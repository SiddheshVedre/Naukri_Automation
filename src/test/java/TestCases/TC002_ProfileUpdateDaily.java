package TestCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ViewProfilePage;
import ReportsListeners.ListenerNaukri;
import utilities.DataProviderClass;

@Listeners(ListenerNaukri.class)
public class TC002_ProfileUpdateDaily extends BaseClass {
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
	public void ProfileUpdate(String username,String password) throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ViewProfilePage pp = new ViewProfilePage(driver);
		
		
		lp.LoginInfo(username, password);
		hp.clickonProfile();
		pp.UpdateProfile();
		
		
		
		
		
	
		
		
	}

}
