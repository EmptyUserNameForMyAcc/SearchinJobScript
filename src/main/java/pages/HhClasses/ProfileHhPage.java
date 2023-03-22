package pages.HhClasses;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.base.BaseTestPage;

public class ProfileHhPage extends BaseTestPage {
    public ProfileHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "a11y-search-input")
    private WebElement searchVacancyField;

    @FindBy(xpath = "//button[@data-qa = 'search-button']")
    private WebElement searchVacancyButton;

    public void letsFindAJobYep(String parametersData) {
        try {
            waitElementIsVisible(searchVacancyField).sendKeys(parametersData);
            waitElementIsVisible(searchVacancyButton).click();
        } catch (StaleElementReferenceException | TimeoutException | NullPointerException e) {
            e.getStackTrace();
        }
    }

    public void clearSearchingField() {
        waitElementIsVisible(searchVacancyField).clear();
    }
}
