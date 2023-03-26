package pages.HhPages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.base.BaseTestPage;

import static constants.Constants.TextVariables.COVERING_TEXT;

public class SentCvPopUp extends BaseTestPage {

    public SentCvPopUp() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-qa = 'resume-title' and text()='QA Automation Engineer (Java + Selenium)']")
    private WebElement chooseCv;

    @FindBy(xpath = "//button[@data-qa='vacancy-response-letter-toggle']")
    private WebElement openCoveringFieldButton;

    @FindBy(xpath = "//div[@class = 'vacancy-response-popup-subtitle']/following-sibling::textarea")
    private WebElement inputCoveringField;

    @FindBy(xpath = "//button[@data-qa = 'vacancy-response-submit-popup']")
    private WebElement sentCVButton;

    @FindBy(xpath = "//iframe[@id = 'ivishnu']")
    private WebElement iFrameResponse;

    public SentCvPopUp switchToCoveringPopUp() {
        driver.switchTo().frame(iFrameResponse);
        return this;
    }

    public SentCvPopUp letsChooseCv() {
        chooseCv.click();
        return this;
    }

    public SentCvPopUp inputCoveringText() {
        try {
            inputCoveringField.click();
            inputCoveringField.sendKeys(COVERING_TEXT);
        } catch (StaleElementReferenceException e) {
            e.getStackTrace();
        }
        return this;
    }

    public SentCvPopUp sentCvWithCoveringMassage() {
        sentCVButton.click();
        return this;
    }

    public SentCvPopUp openCoveringField() {
        openCoveringFieldButton.click();
        return this;
    }
}
