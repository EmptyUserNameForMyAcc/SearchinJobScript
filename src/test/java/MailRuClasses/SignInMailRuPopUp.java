package MailRuClasses;

import resources.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInMailRuPopUp {
    public final WebDriver driver;

    public SignInMailRuPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//iframe[contains(@class, 'popup__frame')]")
    private WebElement signInIFrame;

    @FindBy(xpath = "//input[contains(@name, 'username')]")
    private WebElement loginFields;

    @FindBy(xpath = "//button[contains(@data-test-id, 'next-button')]")
    private WebElement submitLogin;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[contains(@class, 'innerTextWrapper')]")
    private WebElement submitSignInButton;

    public void inputLogin() {
        driver.switchTo().frame(signInIFrame);
        loginFields.sendKeys(ConfProperties.getProperty("mailRuLogin"));
    }

    public void submitLogin() {
        submitLogin.click();
    }

    public void inputPassword() {
        passwordField.sendKeys(ConfProperties.getProperty("mailRuPass"));
    }

    public void submitPassword() {
        submitSignInButton.click();
    }

}
