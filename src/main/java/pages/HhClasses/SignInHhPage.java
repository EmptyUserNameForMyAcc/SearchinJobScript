package pages.HhClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.base.BaseTestPage;

import resources.ConfProperties;

public class SignInHhPage extends BaseTestPage {

    public SignInHhPage() {
        PageFactory.initElements(driver, this);
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
        waitElementIsVisible(submitEnteringData);
        BaseTestPage.actions.clickAndHold(submitEnteringData);
    }

    public void sendPasswordDataAndSubmit() {
        driver.switchTo().window(BaseTestPage.hhHandle);

        waitElementIsVisible(passwordFiled);
        passwordFiled.sendKeys(secretCode);
        submitEnteringData.click();
    }
}
