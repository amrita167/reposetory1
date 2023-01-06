package DemoClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListinerClass implements ITestListener {
	ExtentReports er;
	//it will monitorthe listner classexamplewhen it is starting ending
	ExtentTest test;
public void onTestStart(ITestResult result) {
		String name=result.getName();
		//particular test case monitor
		test=er.createTest(name);
	}
public void onTestSuccess(ITestResult result) {
	String name=result.getName();
	//particular test case monitor
	test.log(Status.PASS,"name+------>pass");
		
	}

public void onTestFailure(ITestResult result) {
	String name=result.getName();
	//particular test case monitor
	test.log(Status.FAIL,"name+------>Fail");
	
}
public void onTestSkipped(ITestResult result) {
	String name=result.getName();
	//particular test case monitor
	test.log(Status.SKIP,"name+------>Skip");
	
	
}

	public void onStart(ITestContext context) {
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReport\\"+1+".html");
		//to provide tittle to the report
		esr.config().setDocumentTitle("Final vtiger Report ");
		//provideing the theme or colour
		esr.config().setTheme(Theme.DARK);
		//providing the reporter name
		esr.config().setReportName("Abhi");
		er=new ExtentReports();
		//it will match between extentspark reportand extent report
		er.attachReporter(esr);
		er.setSystemInfo("operating system","window");
		er.setSystemInfo("language","java");
		
	}

	public void onFinish(ITestContext context) {
		//it is going to consolidate the report
		er.flush();
		
	}
	

}
