package HhClasses;

import MailRuClasses.InsideMailRuBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "//input[@type = 'number']")
    private WebElement passwordFiled;

    @FindBy(xpath = "//span/parent:button[@data-qa = 'otp-code-submit']")
    private WebElement submitButton; // Parent using just for showing. Redundant in this case.

    public void sendLoginData() {
        loginField.sendKeys(ConfProperties.getProperty("hhSignInLogin"));
    }

    public void sendPasswordData() {

    }

    public void submitSignInData() {
        submitButton.click();
    }
}
