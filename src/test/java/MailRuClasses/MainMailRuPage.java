package MailRuClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMailRuPage {
    public final WebDriver driver;
    public MainMailRuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@class, 'resplash-btn')]")
    private WebElement buttonOpenSignInPopUp;


}