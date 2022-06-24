package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static commons.SeleniumWait.waitTellElementVisibility;

public class Veterinarians {
    public Veterinarians(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main-navbar\"]/ul/li[3]/a/span[2]")
    public WebElement veterinariansTab;

    @FindBy(xpath = "//*[@id=\"vets\"]/tbody/tr/td[1]")
    public List<WebElement> veterinariansName;

    public void clickVeterinariansTab() {
        waitTellElementVisibility(veterinariansTab, Long.valueOf(5)).click();
    }

    public List<WebElement> displayVeterinariansName() {
        return veterinariansName;
    }
}
