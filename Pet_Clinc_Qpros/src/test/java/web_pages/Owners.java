package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static commons.SeleniumWait.waitTellElementVisibility;

public class Owners {

    public Owners(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main-navbar\"]/ul/li[2]/a/span[2]")
    public WebElement ownersTab;

    @FindBy(xpath = "//*[@id=\"search-owner-form\"]/div[2]/div/button")
    public WebElement findOwnerButton;

    @FindBy(xpath = "//*[@id=\"owners\"]/tbody/tr/td[1]/a")
    public List<WebElement> ownersName;

    @FindBy(xpath = "/html/body/div/div/a")
    public WebElement addOwnerButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "address")
    public WebElement addressField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "telephone")
    public WebElement telephoneField;

    @FindBy(xpath = "//*[@id=\"add-owner-form\"]/div[2]/div/button")
    public WebElement saveOwner;

    @FindBy(xpath = "/html/body/div/div/a[2]")
    public WebElement addNewPetButton;

    @FindBy(id = "name")
    public WebElement petNameField;

    @FindBy(id = "birthDate")
    public WebElement petBirthdateField;

    @FindBy(id = "type")
    public WebElement petTypeList;

    @FindBy(xpath = "//*[@id=\"type\"]/option[2]")
    public WebElement petType;

    @FindBy(id = "lastName")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"search-owner-form\"]/div[2]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"owners\"]/tbody/tr/td[1]/a")
    public List<WebElement> ownersList;

    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr")
    public List<WebElement> tableKeys;

    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr/td")
    public List<WebElement> tableValues;


    public void clickOwnersTab() {
        waitTellElementVisibility(ownersTab, Long.valueOf(5)).click();
    }

    public void clickFindOwnerButton() {
        waitTellElementVisibility(findOwnerButton, Long.valueOf(5)).click();
    }

    public List<WebElement> displayOwnersName() {
        return ownersName;
    }

    public void clickAddOwner() {
        waitTellElementVisibility(addOwnerButton, Long.valueOf(5)).click();
    }

    public void fillFirstNameField(String name) {
        firstNameField.sendKeys(name);
    }

    public void fillLastNameField(String name) {
        lastNameField.sendKeys(name);
    }

    public void fillAddressField(String address) {
        addressField.sendKeys(address);
    }

    public void fillCityField(String city) {
        cityField.sendKeys(city);
    }

    public void fillTelephoneField(String number) {
        telephoneField.sendKeys(number);
    }

    public void clickSaveButton() {
        saveOwner.click();
    }

    public void clickAddNewPetButton() {
        addNewPetButton.click();
    }

    public void fillPetNameField(String name) {
        petNameField.sendKeys(name);
    }

    public void fillPetBirthDateField(String date) {
        petBirthdateField.sendKeys(date);
    }

    public void clickPetTypeListButton() {
        petTypeList.click();
    }

    public void clickPetType() {
        petType.click();
    }

    public void fillSearchBox(String lastName) {
        searchBox.sendKeys(lastName);
    }

    public List<WebElement> getOwnersList() {
        return ownersList;
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public int getTableSize() {
        return tableKeys.size();
    }

    public List<WebElement> getTableKeys() {
        return tableKeys;
    }

    public List<WebElement> getTableValues() {
        return tableValues;
    }
}
