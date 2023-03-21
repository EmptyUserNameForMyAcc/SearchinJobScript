package MailRuClasses;

import ITests.BaseTest;
import static ITests.BaseTest.actions;

import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div[@aria-label = 'grid']/div/a[1]//div[3]/descendant::span[4]")
    private WebElement uniqDataFromMassage;

    @FindBy(xpath = "//div[@aria-label = 'grid']/div/a[1]")
    private WebElement firstMassage;

    @FindBy(xpath = "//span[contains(@class, 'sp__normal')]")
    private WebElement massageWithSecretCode;

    @FindBy(xpath = "//p/b")
    private WebElement secretCodeElement;

    public void readMassageWithSecretCode() throws InterruptedException {
        driver.switchTo().window(BaseTest.mailRuHandle);
        while (true) {
            if (firstMassage.isDisplayed() && uniqDataFromMassage.getText().contains("hh.ru")) {
                firstMassage.click();
                break;
            } else {
                Thread.sleep(10);
            }
        }
    }

    public void getSecretCode() throws InterruptedException {
        try {
            BaseTest.secretCode = secretCodeElement.getText();
            actions
                    .sendKeys(Keys.DELETE)
                    .perform();
        } finally {
            Thread.sleep(150);
            driver.close();
        }
    }
}
