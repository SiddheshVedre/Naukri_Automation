package utilities;




import org.testng.annotations.DataProvider;


public class DataProviderClass {

    // DataProvider method that provides test data
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"YourMailId", "YourPassword","YourDesignation","Location",3}
            

        };
    }
    
}

