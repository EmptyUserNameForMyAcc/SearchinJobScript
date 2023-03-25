package pages.HhClasses;

import pages.base.BaseTestPage;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
     * Толстенький метод проверяющий содержимое на соответствие заданным кличевым словам.
     * <p>
     * А именно:
     * Java && ( Automation || tests || development || Maven || TestNG || Junit || Docker || тестирования ||
     * тестирование || автоматизация || автоматизации || автоматизированного || xPath || Selenium || Selenoid ||
     * Selenide || тесты || тест || Git || GitLab || GitHub || покрытие || автотесты || автотестами || Agile || Scrum ||
     * IntellijIDEA || Intellij || SQL || MySQL)
     */
    public InsideVacancyHhPage sortVacancy() {
        driver.switchTo().window(vacancyHandle);
        String requirementDescription = null;

        for (WebElement descriptionVacancyText : waitElementsIsVisible(vacancyDescription)) {
            requirementDescription += descriptionVacancyText.getText().toLowerCase();
        }
        try {
            byte countMatch = 0;
            Assertions.assertNotNull(requirementDescription);
            if (!requirementDescription.contains("java")) {
                hideVacancy();
            } else if (requirementDescription.contains("java")) {
                countMatch++;
            } else if (requirementDescription.contains("junit")) {
                countMatch++;
            } else if (requirementDescription.contains("docker")) {
                countMatch++;
            } else if (requirementDescription.contains("maven")) {
                countMatch++;
            } else if (requirementDescription.contains("xpath")) {
                countMatch++;
            } else if (requirementDescription.contains("selenium")
                    || requirementDescription.contains("selenoid")
                    || requirementDescription.contains("selenide")) {
                countMatch++;
            } else if (requirementDescription.contains("git")
                    || requirementDescription.contains("github")
                    || requirementDescription.contains("gitlab")
                    || requirementDescription.contains("bitbucket")) {
                countMatch++;
            } else if (requirementDescription.contains("agile")) {
                countMatch++;
            } else if (requirementDescription.contains("scrum")) {
                countMatch++;
            } else if (requirementDescription.contains("intellijIDEA")
                    || requirementDescription.contains("intellij idea")) {
                countMatch++;
            } else if (requirementDescription.contains("автоматизации")
                    || requirementDescription.contains("автоматизация")
                    || requirementDescription.contains("автоматизированного")
                    || requirementDescription.contains("автоматизирование")
                    || requirementDescription.contains("автоматизированное")
                    || requirementDescription.contains("automation")) {
                countMatch++;
            } else if (requirementDescription.contains("sql")
                    || requirementDescription.contains("mysql")) {
                countMatch++;
            }
            if (countMatch > 5) {

            }
            Thread.sleep(1000);
            driver.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public InsideVacancyHhPage hideVacancyIfExperienceMore6Years() {
        if (experienceInfo.getText().equals("более 6 лет")) {
            hideVacancy();
        }
        return this;
    }

    public InsideVacancyHhPage hideVacancy() {
        vacancyHidingSelector.click();
        waitElementIsVisible(hideVacancyButton).click();
        return this;
    }

    public InsideVacancyHhPage openConvertingLetter() {
        openCoveringLetterButton.click();
        return this;
    }
}
