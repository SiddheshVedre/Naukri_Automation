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

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  TC002_ProfileUpdateDaily : Update Profile  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
@Listeners(ListenerNaukri.class)
public class TC002_ProfileUpdateDaily extends BaseClass {
	
	//  ----------------------------------   groups : Regression_Testing, Master  ----------------------------------------------------
	@Test(groups= {"Regression_Testing","Master"},dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)// ------------  Test Class Calling Data from DataProvider Class : Naukri_Automation_Details.xlsx  -----------
	public void ProfileUpdate(String username,String password) throws IOException {
		
	    //  >>>>>>>>>>>>>>>>>>>>>>>>  Initilization Classes  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ViewProfilePage pp = new ViewProfilePage(driver);
		
		// ---------------  ASSERTION Equals : Needs To ADD more Assertions  -----------------
		SoftAssert softAssert = new SoftAssert();
		
		
		// >>>>>>>>>>>>>>>>>  Test Senario  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		lp.LoginInfo(username, password);
		hp.clickonProfile();
		pp.UpdateProfile();
		
		driver.quit();
		
		softAssert.assertAll();
		
		
	
	}

}
