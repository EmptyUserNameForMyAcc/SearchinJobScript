package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileHhPage {
    public final WebDriver driver;

    public ProfileHhPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "a11y-search-input")
    private WebElement searchVacancyField;

    @FindBy(xpath = "//button[@data-qa = 'search-button']")
    private WebElement searchVacancyButton;

    public void letsFindAJobYep(String parametersData) {
        searchVacancyField.sendKeys(parametersData);
        searchVacancyButton.click();
    }

    public void clearSearchingField() {
        searchVacancyField.clear();
    }
}
