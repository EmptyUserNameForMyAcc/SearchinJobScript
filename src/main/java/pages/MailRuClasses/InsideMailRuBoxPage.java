package pages.MailRuClasses;

import org.openqa.selenium.*;

import pages.base.BaseTestPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.TimeOutsVariables.LONG_EXPLICITLY_WAIT5M;

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

    public void readMassageWithSecretCode() {
        driver.switchTo().window(BaseTestPage.mailRuHandle);
        while (true) {
            if (firstMassage.isDisplayed() && adaptiveWaitElementIsVisible(uniqDataFromMassage, LONG_EXPLICITLY_WAIT5M)
                    .getText().contains("hh.ru")) {
                firstMassage.click();
                break;
            }
        }
    }

    public void getSecretCode() {
        secretCode = secretCodeElement.getText();
        try {
            while (secretCodeElement.isDisplayed()) {
                if (true) {
                    actions // Удаляет сообщения после получения секретного кода.
                            .sendKeys(Keys.DELETE)
                            .perform();
                    Thread.sleep(700);
                }
            }
        } catch (StaleElementReferenceException | NoSuchElementException | InterruptedException serensex) {
            serensex.getStackTrace();
        }
        driver.close();
    }
}
