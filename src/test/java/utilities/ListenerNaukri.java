package utilities;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;


public class ListenerNaukri implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    
    @Override
    public void onTestFailure(ITestResult result) {
    	
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        // Retrieve WebDriver from ITestContext
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

        if (driver != null) {
            try {
                // Capture failure screenshot
                String screenshotPath = new BaseClass().captureFailureScreenshot(driver, result.getName());
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e1) {
                e1.printStackTrace();
                test.log(Status.FAIL, "WebDriver instance was null. Screenshot could not be captured.");
            }
       }
    }
    
    

    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat(" [yyyy.MM.dd] [HH.mm.ss] ").format(new Date());
        String reportName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Naukri.com");
        extent.setSystemInfo("Environment", "UAT");
        extent.setSystemInfo("Module", "Applications");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        String url = testContext.getCurrentXmlTest().getParameter("url");
        extent.setSystemInfo("URL", url);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }
    
    
    
    

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
