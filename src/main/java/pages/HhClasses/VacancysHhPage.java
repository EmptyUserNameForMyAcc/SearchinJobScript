package pages.HhClasses;

import pages.base.BaseTestPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacancysHhPage extends BaseTestPage {

    public VacancysHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3//a")
    private List<WebElement> vacancysTitle;

    public void goToVacancyForOne() {
        try {
            for (WebElement oneVacancy : vacancysTitle) {
                driver.switchTo().window(hhHandle);
                String vacancyUrl = oneVacancy.getAttribute("href");
                System.out.println(vacancyUrl);

                driver.switchTo().newWindow(WindowType.TAB).navigate().to(vacancyUrl);
                vacancyHandle = driver.getWindowHandle();

                insideVacancyHhPage
                        .hideVacancyIfExperienceMore6Years()
                        .sortVacancy()
                        .openConvertingLetter();
            }
        } catch (TimeoutException e) {
            e.getCause().getStackTrace();
        }
    }
}
