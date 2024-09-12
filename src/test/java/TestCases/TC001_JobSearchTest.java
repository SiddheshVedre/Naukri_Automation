package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.JobSubmitPage;
import PageObjects.LoginPage;
import listeners.ListenerNaukri;
import utilities.DataProviderClass;

@Listeners(ListenerNaukri.class)
public class TC001_JobSearchTest extends BaseClass {

    // Test method using the DataProvider from DataProviderClass
    @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void verify_login(String username, String password, String designation, String Location, int applications) throws IOException {

        logger.info("@@@ TC001_JobSearchTest Started Running @@@");

        try {
            LoginPage lp = new LoginPage(driver);
            HomePage hp = new HomePage(driver);
            JobSubmitPage jsp = new JobSubmitPage(driver);
            
            // Logging in with username and password
            logger.info("---Passing Parameters Email ID, Password---");
            lp.LoginInfo(username, password);
            
            // Searching for jobs with designation and location
            logger.info("---Passing Parameters Designation, Location---");
            hp.SearchBar(designation, Location);
            
            // Verifying the confirmation message
            String confmsg = hp.getConfirmation();
            Assert.assertEquals(confmsg, "Jobs");
            
            // Applying to jobs using the number of applications
            hp.applications(applications);
            jsp.ApplyClick();

        } catch (Exception e) {
            logger.info("---TC001_JobSearchTest Failed---");
            Assert.fail();
        }

        logger.info("@@@ TC001_JobSearchTest Completed Successfully @@@");
    }
}
