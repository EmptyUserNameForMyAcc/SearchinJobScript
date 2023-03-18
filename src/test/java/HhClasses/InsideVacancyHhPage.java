package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsideVacancyHhPage {
    public final WebDriver driver;

    public InsideVacancyHhPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "vacancy-description-list-item")
    private WebElement experienceInfo;

    @FindBy(xpath = "//div[@data-qa = 'vacancy-description']")
    private WebElement vacancyDescription;

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
}
