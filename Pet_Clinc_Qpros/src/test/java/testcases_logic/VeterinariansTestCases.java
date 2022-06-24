package testcases_logic;

import commons.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import util.TestUtils;
import web_pages.Veterinarians;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class VeterinariansTestCases extends SeleniumDriver {
    @Test(description = "TC2-Find all the Veterinarians which are added in the application and print that list")
    public void findAllTheVeterinariansAreAdded(Method method) throws IOException {
        Veterinarians veterinarians = new Veterinarians(seleniumDriver);
        veterinarians.clickVeterinariansTab();

        List<WebElement> allVeterinarians = veterinarians.displayVeterinariansName();

        System.out.println("---- veterinarian Name ----");

        for (WebElement veterinarianName : allVeterinarians) {
            System.out.println(veterinarianName.getText());
            System.out.println("______________");
        }

        TestUtils.takePicture(method.getName());
    }
}
