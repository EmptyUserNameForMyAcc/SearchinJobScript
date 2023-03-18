package MailRuClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsideMailRuBoxPage {
    public final WebDriver driver;

    public InsideMailRuBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(@class, 'sp__normal')]")
    private WebElement massageWithSecretCode;

    @FindBy(xpath = "//tr/td[contains(@style, 'padding')]/descendant::td/p[3]/b") // Try to change on //p/b.
    private WebElement secretCodeElement;
}
