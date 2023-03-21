package HhClasses;

import ITests.BaseTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacancysHhPage extends BaseTest {
    public WebDriver driver;

    public VacancysHhPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3")
    private List<WebElement> vacancysTitle;

    public void getVacancysDescription() {
        driver.switchTo().window(hhHandle);

        for (WebElement vacancyTitle : vacancysTitle) {
            if (driver.getWindowHandles().size() <= 1) {
                System.out.println(driver.getWindowHandles().size() + " я количество открытых табов");
                actions
                        .keyDown(vacancyTitle, Keys.LEFT_CONTROL)
                        .click()
                        .perform();
                vacancyHandle = driver.getWindowHandle();
                insideVacancyHhPage.sortVacancy();
            }
        }
    }
}
