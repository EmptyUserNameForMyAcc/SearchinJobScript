package HhClasses;

import ITests.BaseTest;
import MailRuClasses.InsideMailRuBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

public class SignInHhPage extends InsideMailRuBoxPage {
    public final WebDriver driver;

    public SignInHhPage(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//span/parent:button[@data-qa = 'otp-code-submit']")
    private WebElement submitEnteringData; // Parent using just for showing. Redundant in this case.

    public static Date sentMassageDate;
    public void sendLoginData() {
        loginField.sendKeys(ConfProperties.getProperty("lalala"));
        sentMassageDate = new Date();
    }

    public void submitSignInData() {
        submitEnteringData.click();
    }

    public void sendPasswordDataAndSubmit() {
        driver.switchTo().window(BaseTest.hhHandle);
        passwordFiled.sendKeys(InsideMailRuBoxPage.getSecretCode());
        submitEnteringData.click();
    }
}
