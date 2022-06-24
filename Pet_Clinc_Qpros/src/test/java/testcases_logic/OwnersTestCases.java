package testcases_logic;

import commons.SeleniumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.TestUtils;
import web_pages.Owners;
import web_pages.Veterinarians;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class OwnersTestCases extends SeleniumDriver {
    @Test(description = "TC3-find all required owners are added")
    public void findAllTheOwnersAreAdded(Method method) throws IOException {
        Owners owners = new Owners(seleniumDriver);
        owners.clickOwnersTab();
        owners.clickFindOwnerButton();

        List<WebElement> allOwners = owners.displayOwnersName();

        System.out.println("---- Owners Name ----");

        for (WebElement ownerName : allOwners) {
            System.out.println(ownerName.getText());
            System.out.println("______________");
        }

        TestUtils.takePicture(method.getName());
    }

    @Test(description = "TC4-Add a new owner, add pet for that owner")
    public void AddOwnerAndPet(Method method) throws IOException {
        Owners owners = new Owners(seleniumDriver);
        owners.clickOwnersTab();
        owners.clickAddOwner();
        owners.fillFirstNameField("Wajd");
        owners.fillLastNameField("Mihyar");
        owners.fillAddressField("Amman");
        owners.fillCityField("Amman");
        owners.fillTelephoneField("078662255");
        owners.clickSaveButton();

        owners.clickAddNewPetButton();
        owners.fillPetNameField("Salma");
        owners.fillPetBirthDateField("2020-08-01");
        owners.clickPetTypeListButton();
        owners.clickPetType();

        TestUtils.takePicture(method.getName());
    }

    @Test(description = "TC5-Verify all the information added for the newly created owner and pet is correct")
    public void verifyOwnerInformation(Method method) throws IOException {
        Owners owners = new Owners(seleniumDriver);
        owners.clickOwnersTab();
        owners.fillSearchBox("Mihyar");
        owners.clickSearchButton();
        int lastIndex = owners.getOwnersList().size() - 1;
        owners.getOwnersList().get(lastIndex).click();

        HashMap<String, String> actualTableValues = new HashMap<>();

        List<WebElement> tableKeys = owners.getTableKeys();
        List<WebElement> tableValues = owners.getTableValues();

        for (int i = 0; i < owners.getTableSize(); i++) {
            actualTableValues.put(tableKeys.get(i).getText(), tableValues.get(i).getText());
        }

        HashMap<String, String> expectedTableValues = new HashMap<>();
        expectedTableValues.put("Name", "Wajd Mihyar");
        expectedTableValues.put("Address", "Amman");
        expectedTableValues.put("City", "Amman");
        expectedTableValues.put("Telephone", "078662255");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTableValues, actualTableValues);

        TestUtils.takePicture(method.getName());
    }
}
