package Runner;

import PreRequisites.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

// listeners class implements itestlisteners which do the specific task on the particular state of the test
public class Listeners extends BaseClass implements ITestListener {

    private final Logger log= LogManager.getLogger(Listeners.class.getName());
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;
    ExtentTest test;

    //attach reporter to extent reporter


    @Override
    public void onTestStart(ITestResult result) {
        test=extentReports.createTest(result.getName());
        test.log(Status.INFO, "Starting Test"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass(result.getName()+"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getName()+"Test Failed");
        //getting the test name which is failed
        String testName=result.getMethod().getMethodName();
        //initializing the screenshot class
        TakesScreenshot ts=(TakesScreenshot) driver;
        //initializing the source of screenshot
        File src=ts.getScreenshotAs(OutputType.FILE);
        //initializing the destination of screenshot
        File des=new File(System.getProperty("user.dir")+"/results/Failed Tests Screenshots/"+testName+"_.jpg");
        try {
            //copy the screenshot in the destination
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.info(result.getName()+"Test Skipped");
        //System.out.println("Skipped As Maximum Expense is Greater than 100");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        //initialize the reporter
        myReporter=new ExtentSparkReporter("results//Reports//extentReport.html");;
        extentReports =new ExtentReports();

        extentReports.attachReporter(myReporter);

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
