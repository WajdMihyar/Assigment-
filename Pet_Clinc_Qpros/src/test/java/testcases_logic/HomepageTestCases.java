package testcases_logic;

import commons.SeleniumDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.TestUtils;
import web_pages.HomePage;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomepageTestCases extends SeleniumDriver {

    @Test(description = "TC1-Verify image on home page")
    public void VerifyDisplayImageOnHomepage(Method method) throws IOException {
        HomePage homepage = new HomePage(seleniumDriver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(homepage.displayHomeImage());

        TestUtils.takePicture(method.getName());
    }
}
