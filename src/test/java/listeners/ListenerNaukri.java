package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerNaukri implements ITestListener {
	
   public ExtentSparkReporter sparkReporter; // UI oof the report
   public ExtentReports extent; //populate common info on reports
   public ExtentTest test; // Creating TestCases entries in the report and update status of the test method
   
   @Override
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReports.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
	}
	
   
	public void onTestSuccess(ITestContext result) {
		
		test = extent.createTest(result.getName()); //create new entry in report
		test.log(Status.PASS,"Test case PASSED is:"+ result.getName()); // update stauts pass/faild/skip
		

	}
	
   
	public void onTestFailure(ITestContext result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED case is: " + result.getName());
		
	}
   
   
	public void onTestSkipped(ITestContext result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
		
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	


}
