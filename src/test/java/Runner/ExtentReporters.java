package Runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporters {

    ExtentSparkReporter myReporter=new ExtentSparkReporter("results//Reports//extentReport.html");;
    ExtentReports extentReports =new ExtentReports();
    ExtentTest test;

    public void attachReports(){
        extentReports.attachReporter(myReporter);
    }
}
