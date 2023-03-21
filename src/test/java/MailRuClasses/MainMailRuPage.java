package MailRuClasses;

import ITests.BaseTest;
import ITests.SearchingJobScript;
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

    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement buttonOpenSignInPopUp;

    public void goToSignIn() {
        driver.switchTo().window(BaseTest.mailRuHandle);
        buttonOpenSignInPopUp.click();
    }
}
