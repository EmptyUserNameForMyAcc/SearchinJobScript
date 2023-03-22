package pages.MailRuClasses;

import pages.base.BaseTestPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static constants.Constants.TimeOutsVariables.EXPLICITLY_WAIT;

public class InsideMailRuBoxPage extends BaseTestPage {

    public InsideMailRuBoxPage() {
        PageFactory.initElements(driver, this);
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
        driver.switchTo().window(BaseTestPage.mailRuHandle);
        while (true) {
            if (firstMassage.isDisplayed() && uniqDataFromMassage.getText().contains("hh.ru")) {
                firstMassage.click();
                break;
            } else {
                Thread.sleep(Duration.ofMillis(EXPLICITLY_WAIT));
            }
        }
    }

    public void getSecretCode() {
        secretCode = secretCodeElement.getText();
        actions
                .sendKeys(Keys.DELETE)
                .perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
