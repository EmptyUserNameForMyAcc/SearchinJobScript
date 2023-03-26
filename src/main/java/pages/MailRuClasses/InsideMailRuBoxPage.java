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

    public InsideMailRuBoxPage readMassageWithSecretCode() {
        driver.switchTo().window(mailRuHandle);
        try {
            while (true) {
                if (firstMassage.isDisplayed() && adaptiveWaitElementIsVisible(uniqDataFromMassage, LONG_EXPLICITLY_WAIT5M)
                        .getText().contains("hh.ru")) {
                    firstMassage.click();
                    break;
                }
            }
        } catch (TimeoutException | NoSuchElementException e) {
            readMassageWithSecretCode();
            e.getStackTrace();
        }
        return this;
    }

    public InsideMailRuBoxPage getSecretCode() {
        secretCode = secretCodeElement.getText();
        try {
            while (secretCodeElement.isDisplayed()) {
                if (secretCodeElement.isDisplayed()) {
                    actions // Удаляет сообщения от Hh после получения секретного кода.
                            .sendKeys(Keys.DELETE)
                            .perform();
                    Thread.sleep(700);
                }
            }
        } catch (StaleElementReferenceException | NoSuchElementException | InterruptedException serensex) {
            serensex.getStackTrace();
        }
        driver.close();
        return this;
    }
}
