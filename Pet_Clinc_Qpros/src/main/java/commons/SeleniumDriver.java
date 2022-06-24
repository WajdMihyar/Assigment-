package commons;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class SeleniumDriver {

    public static WebDriver seleniumDriver;
    public static String siteUrl = "https://petclincqpros.herokuapp.com/";
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void seleniumChromeSetUp() {
        WebDriverManager.chromedriver().setup();
        seleniumDriver = new ChromeDriver();
        seleniumDriver.manage().window().maximize();
        seleniumDriver.navigate().to(siteUrl);
    }

    @AfterTest
    public void seleniumTopTear() {
        seleniumDriver.close();
    }

    @BeforeSuite
    public void reportSetUp() {
        extent = new ExtentReports("src/TestReport/index.html", true);

        extent.addSystemInfo("Os", "windows");
        extent.addSystemInfo("Owner", "Wajd Mihyar");
        extent.addSystemInfo("TestName", "QPros");
    }

    @AfterSuite
    public void reportTearDown() {
        extent.flush();
    }

    @BeforeMethod
    public void setup(Method method) {
        logger = extent.startTest(method.getName());
    }

    @AfterMethod
    public void tearDown(Method method, ITestResult result) {
        String downloadSnapshot = "<div><a href='" + result.getName() + ".png" + "'> <span class='lable info'> Download Snapshot </span></a></div>";

        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test pass  " + downloadSnapshot);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, result.getThrowable() + downloadSnapshot); // show the error message
        } else {
            logger.log(LogStatus.SKIP, "Test Skipped" + downloadSnapshot);
        }
    }
}
