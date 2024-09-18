package ReportsListeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerNaukri implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Generate a timestamped report filename
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time-stamped format
        String reportName = "Test-Report-" + timeStamp + ".html";

        // Initialize the ExtentSparkReporter with the timestamped file name
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);

        sparkReporter.config().setDocumentTitle("Automation Report"); // Set the document title
        sparkReporter.config().setReportName("Functional Testing");   // Set the report name
        sparkReporter.config().setTheme(Theme.DARK);                  // Set the report theme

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Adding system information to the report
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Siddhesh Vedree"); // Customize the user if needed
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Create a new entry in the report for the passed test
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Create a new entry in the report for the failed test
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
        test.log(Status.FAIL, result.getThrowable()); // Log the error/exception details
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Create a new entry in the report for the skipped test
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Writes all the details to the report file
    }

}
