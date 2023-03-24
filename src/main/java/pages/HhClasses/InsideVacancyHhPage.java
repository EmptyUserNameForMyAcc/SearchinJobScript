package pages.HhClasses;

import pages.base.BaseTestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InsideVacancyHhPage extends BaseTestPage {

    public InsideVacancyHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "vacancy-description-list-item")
    private WebElement experienceInfo;

    @FindBy(xpath = "//div[@data-qa='vacancy-description']/ul")
    private List<WebElement> vacancyDescription;

    @FindBy(xpath = "//div[@class = 'bloko-tag-list']/div/span")
    private WebElement keySkills;

    @FindBy(xpath = "//a[@data-qa = 'vacancy-response-link-top']")
    private WebElement sentCvButton;

    @FindBy(xpath = "//button[@data-qa = 'vacancy__blacklist-show-add']")
    private WebElement vacancyHidingSelector;

    @FindBy(xpath = "//a[@data-qa = 'vacancy__blacklist-menu-add-vacancy']")
    private WebElement hideVacancyButton;

    @FindBy(xpath = "//button[@data-qa = 'vacancy-response-letter-toggle']")
    private WebElement openCoveringLetterField;

    @FindBy(xpath = "//form[contains(@action, 'vacancy_response/edit_ajax')]/input")
    private WebElement coveringLetterField;

    @FindBy(xpath = "//button[@data-qa = 'vacancy-response-letter-submit']")
    private WebElement sentCoveringLetterButton;

    @FindBy(xpath = "//a[@data-qa = 'vacancy-response-link-view-topic']/span")
    private WebElement buttonAfterSentCv; // For check changes in button text.

    public InsideVacancyHhPage sortVacancy() {
        System.out.println("Я ТУТ, В СОРТ МЕТОДЕ!!!");
        driver.switchTo().window(vacancyHandle);

        for (WebElement descriptionVacancyText : vacancyDescription) {
            System.out.println(descriptionVacancyText.getText());
        }
        try {
            Thread.sleep(300);
            driver.close();
            driver.switchTo().window(hhHandle);
        } catch (InterruptedException e) {
            e.getCause().getStackTrace();
        }
        return this;
    }
}
