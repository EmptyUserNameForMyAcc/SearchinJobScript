package MailRuClasses;

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

    @FindBy(xpath = "//input[contains(@name, 'username')]")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//button[contains(@data-test-id, 'next-button')]")
    private WebElement submitPasswordButton;

    @FindBy(xpath = "//input[@name= 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[contains(@class, 'innerTextWrapper')]")
    private WebElement submitAuthButton;
}
