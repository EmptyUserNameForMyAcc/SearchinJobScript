package pages.HhPages;

import pages.base.BaseTestPage;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.BoolVariables.IS_AUTOMATION;
import static constants.Constants.TextVariables.*;
import static constants.Constants.TimeOutsVariables.countMatch;

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
        IS_AUTOMATION = false;
        countMatch = 0;

        for (WebElement descriptionVacancyText : vacancyDescription) {
            requirementDescription += descriptionVacancyText.getText()
                    .toLowerCase()
                    .replace("null", " ")
                    .replace("\n", " ");
        }

        Assertions.assertNotNull(requirementDescription);

        for (String containsValue : IS_AUTOMATION_REQUIREMENT) {
            if (requirementDescription.contains(containsValue)) {
                IS_AUTOMATION = true;
                break;
            }
        }

        try {
            for (String oneGrade : gradesOfChoice) {
                if (requirementDescription.contains(oneGrade)) {
                    countMatch++;
                    System.out.println(oneGrade + " -> я удовлетворённое требование и содержусь в тексте");
                }
            }

            boolean IS_CONTAIN_JAVA_AUTOMATION_AND_MATCH_MORE_4 =
                    countMatch >= 5
                            && requirementDescription.contains("java")
                            && !(requirementDescription.contains("javascript"))
                            && IS_AUTOMATION;

            System.out.println(
                    "я описываю всю вакансию -> " + requirementDescription + "\n"
                            + "\n я автоматизация -> " + IS_AUTOMATION
                            + "\n я меньше шести лет -> " + isLessThen6Years
                            + "\n а я бул для матчей -> " + IS_CONTAIN_JAVA_AUTOMATION_AND_MATCH_MORE_4
                            + "\n я матч счётчик -> " + countMatch
                            + "\n я требование на Java -> " + requirementDescription.contains("java")
                            + "\n я требование на !JS -> " + !(requirementDescription.contains("javascript")));

            if (IS_CONTAIN_JAVA_AUTOMATION_AND_MATCH_MORE_4 && isLessThen6Years) {
                sentCvOnVacancy();
                sentCvPopUp
                        .letsChooseCv()
                        .openCoveringField()
                        .inputCoveringText()
                        .sentCvWithCoveringMassage();
                Thread.sleep(1000);
                driver.close();
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
