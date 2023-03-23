package pages.HhClasses;

import pages.base.BaseTestPage;

import org.openqa.selenium.*;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacancysHhPage extends BaseTestPage {

    public VacancysHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3//a")
    private List<WebElement> vacancysTitle;

    public void getVacancysDescription() {
        try {
            for (WebElement vacancyTitle : waitElementsIsVisible(vacancysTitle)) {
                System.out.println(vacancyTitle.toString() + " а я ссылка объекта на новую страницу");
                actions
                        .keyDown(Keys.LEFT_CONTROL)
                        .click(vacancyTitle)
                        .keyUp(Keys.LEFT_CONTROL)
                        .perform();

                for (String otherHandle : driver.getWindowHandles()) {
                    if (!hhHandle.contentEquals(otherHandle)) {
                        vacancyHandle = otherHandle;
                        System.out.println(otherHandle);
                        break;
                    }
                }

                System.out.println(" я ID вакансии\n" + vacancyHandle + " я ID хх" + hhHandle);
                driver.switchTo().window(vacancyHandle);
                insideVacancyHhPage.sortVacancy();
            }
        } catch (JsonException | TimeoutException e) {
            e.getCause().getStackTrace();
        }
    }
}
