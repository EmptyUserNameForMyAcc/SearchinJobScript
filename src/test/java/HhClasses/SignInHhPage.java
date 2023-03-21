package HhClasses;

import ITests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.ConfProperties;

public class SignInHhPage {
    public final WebDriver driver;

    public SignInHhPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement loginField;

    @FindBy(xpath = "//form/descendant::button[@data-qa = 'account-signup-submit']")
    private WebElement submitEnteringLogin;

    public void submitLogin() {
        submitEnteringLogin.click();
    }
    @FindBy(xpath = "//input[@data-qa = 'otp-code-input']")
    private WebElement passwordFiled;

    @FindBy(xpath = "//button[@data-qa = 'otp-code-submit']")
    private WebElement submitEnteringData;

    public void sendLoginData() {
        loginField.sendKeys(ConfProperties.getProperty("mailRuLogin"));
    }

    public void submitSignInData() {
        submitEnteringData.click();
    }

    public void sendPasswordDataAndSubmit() {
        driver.switchTo().window(BaseTest.hhHandle);
        passwordFiled.sendKeys(BaseTest.secretCode);
        submitEnteringData.click();
    }
}
