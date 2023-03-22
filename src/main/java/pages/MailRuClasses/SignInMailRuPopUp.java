package pages.MailRuClasses;

import pages.base.BaseTestPage;

import resources.ConfProperties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInMailRuPopUp extends BaseTestPage {

    public SignInMailRuPopUp() {
        PageFactory.initElements(driver, this);
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
        waitElementIsVisible(loginFields).sendKeys(ConfProperties.getProperty("mailRuLogin"));
    }

    public void submitLogin() {
        waitElementIsVisible(submitLogin).click();
    }

    public void inputPassword() {
        waitElementIsVisible(passwordField).sendKeys(ConfProperties.getProperty("mailRuPass"));
    }

    public void submitPassword() {
        waitElementIsVisible(submitSignInButton).click();
    }

}
