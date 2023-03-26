package pages.MailRuPages;

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

    public SignInMailRuPopUp inputLogin() {
        driver.switchTo().frame(signInIFrame);
        waitElementIsVisible(loginFields).sendKeys(ConfProperties.getProperty("mailRuLogin"));
        return this;
    }

    public SignInMailRuPopUp submitLogin() {
        waitElementIsVisible(submitLogin).click();
        return this;
    }

    public SignInMailRuPopUp inputPassword() {
        waitElementIsVisible(passwordField).sendKeys(ConfProperties.getProperty("mailRuPass"));
        return this;
    }

    public SignInMailRuPopUp submitPassword() {
        waitElementIsVisible(submitSignInButton).click();
        return this;
    }

}
