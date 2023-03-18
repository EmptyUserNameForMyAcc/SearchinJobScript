package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacancysHhPage {
    public final WebDriver driver;

    public VacancysHhPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "a11y-search-input")
    private WebElement searchVacancyField;

    @FindBy(xpath = "//button[@data-qa = 'search-button']")
    private WebElement searchVacancyButton;
}
