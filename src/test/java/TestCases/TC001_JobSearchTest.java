package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import PageObjects.HomePage;
import PageObjects.JobSubmitPage;
import PageObjects.LoginPage;
import utilities.DataProviderClass;
import utilities.ListenerNaukri;


//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>  TC001_JobSearchTest : Job Searching & Click on Apply Button  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
@Listeners(ListenerNaukri.class)
public class TC001_JobSearchTest extends BaseClass {

    
    @Test(dataProvider = "AllData", dataProviderClass = DataProviderClass.class) // ------------  Test Class Calling Data from DataProvider Class : Naukri_Automation_Details.xlsx  ---------------------
    public void Job_Search(String username, String password, String designation, String Location, String application , String experience ) throws IOException {

    	System.out.println("@@@ TC001_JobSearchTest Started Running @@@");

        try {
        	
        	//  >>>>>>>>>>>>>>>>>>>>>>>>  Initilization Classes  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            LoginPage lp = new LoginPage(driver);
            HomePage hp = new HomePage(driver);
            JobSubmitPage jsp = new JobSubmitPage(driver);
            
           
            //  >>>>>>>>>>>>>>>>>>>>>>>>  Logging : in with username and password  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            System.out.println("---Passing Parameters Email ID, Password---");
            lp.LoginInfo(username, password);
            
          
           
            // >>>>>>>>>>>>>>>>>>>>>>>>>  Searching : for jobs with designation and location  <<<<<<<<<<<<<<<<<<<<<<<<<<<
            System.out.println("---Passing Parameters Designation, Location---");
            hp.SearchBar(designation, Location, experience);
            
            // -----------------------  ASSERTION Equals : Jobs Name  ---------------------------------
            String confmsg = hp.getConfirmation();
            Assert.assertEquals(confmsg, "Jobs");
            
            // >>>>>>>>>>>>>>>>>>>>>  Applying : to jobs using the number of applications  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            hp.applications(Integer.parseInt(application));
            jsp.ApplyClick();
            
        
            System.out.println("Script ComeBack to Test");

        } catch (Exception e) {
        	System.out.println("---TC001_JobSearchTest Failed---");
            Assert.fail();
        }
        
       
        
    }
}
