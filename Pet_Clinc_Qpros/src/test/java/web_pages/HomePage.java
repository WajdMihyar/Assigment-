package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static commons.SeleniumWait.waitTellElementVisibility;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "img-responsive")
    public WebElement homeImage;

    public WebElement displayHomeImage() {
        return waitTellElementVisibility(homeImage, Long.valueOf(5));
    }
}
