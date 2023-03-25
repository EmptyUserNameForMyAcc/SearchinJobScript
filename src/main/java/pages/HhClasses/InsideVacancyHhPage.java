package pages.HhClasses;

import pages.base.BaseTestPage;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static constants.Constants.BoolVariables.*;

import static constants.Constants.TimeOutsVariables.countMatch;

import static constants.Constants.TextVariables.COVERING_TEXT;
import static constants.Constants.TextVariables.gradesChoice;
import static constants.Constants.TextVariables.requirementDescription;

public class InsideVacancyHhPage extends BaseTestPage {

    public InsideVacancyHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-qa='vacancy-experience']")
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
    private WebElement openCoveringLetterButton;

    @FindBy(xpath = "//form[contains(@action, 'vacancy_response/edit_ajax')]/input")
    private WebElement coveringLetterField;

    @FindBy(xpath = "//button[@data-qa = 'vacancy-response-letter-submit']")
    private WebElement sentCoveringLetterButton;

    @FindBy(xpath = "//a[@data-qa = 'vacancy-response-link-view-topic']/span")
    private WebElement buttonAfterSentCv; // For check changes in button text.

    /**
     * Толстенький метод проверяющий содержимое на соответствие заданным ключевым словам.
     * <p>
     * А именно:
     * Java && ( Automation || tests || development || Maven || TestNG || Junit || Docker || тестирования ||
     * тестирование || автоматизация || автоматизации || автоматизированного || xPath || Selenium || Selenoid ||
     * Selenide || тесты || тест || Git || GitLab || GitHub || покрытие || автотесты || автотестами || Agile || Scrum ||
     * IntellijIDEA || Intellij || SQL || MySQL)
     */
    public InsideVacancyHhPage sortVacancy() {
        driver.switchTo().window(vacancyHandle);

        boolean isLessThen6Years = !(waitElementIsVisible(experienceInfo).getText().equals("более 6 лет"));
        requirementDescription = " ";
        countMatch = 0;

        for (WebElement descriptionVacancyText : vacancyDescription) {
            requirementDescription += descriptionVacancyText.getText()
                    .toLowerCase()
                    .replace("null", " ")
                    .replace("\n", " ");
        }
        try {
            Assertions.assertNotNull(requirementDescription);

            for (String gradeOfChoice : gradesChoice) {
                if (requirementDescription.contains(gradeOfChoice)) {
                    countMatch++;
                }
            }

            System.out.println(requirementDescription + "\n" + IS_AUTOMATION + " я автоматизация\n"
                    + isLessThen6Years + " я меньше шести лет");

            if (IS_CONTAIN_JAVA_AUTOMATION_AND_MATCH_MORE_5 && isLessThen6Years) {
                insideVacancyHhPage
                        .sentCvOnVacancy()
                        .openConvertingLetter()
                        .pasteConvertingMassage()
                        .sentCoveringMassage();
            } else {
                hideVacancy();
                Thread.sleep(1000);
                driver.close();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public InsideVacancyHhPage hideVacancy() {
        vacancyHidingSelector.click();
        waitElementIsVisible(hideVacancyButton).click();
        return this;
    }

    public InsideVacancyHhPage sentCvOnVacancy() {
        sentCvButton.click();
        return this;
    }

    public InsideVacancyHhPage openConvertingLetter() {
        openCoveringLetterButton.click();
        return this;
    }

    public InsideVacancyHhPage pasteConvertingMassage() {
        coveringLetterField.sendKeys(COVERING_TEXT);
        return this;
    }

    public InsideVacancyHhPage sentCoveringMassage() {
        sentCoveringLetterButton.click();
        return this;
    }
}
