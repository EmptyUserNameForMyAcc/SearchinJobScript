package pages.HhClasses;

import constants.Constants;

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

    @FindBy(xpath = "//h3")
    private List<WebElement> vacancysTitle;

    public void getVacancysDescription() {
        try {
            for (WebElement vacancyTitle : waitElementsIsVisible(vacancysTitle)) {
                System.out.println(vacancyTitle.toString());
                actions
                        .keyDown(Keys.LEFT_CONTROL)
                        .click(waitElementIsVisible(vacancyTitle))
                        .build()
                        .perform();

                for (String otherHandle : driver.getWindowHandles()) {
                    if (!hhHandle.contentEquals(otherHandle)) {
                        vacancyHandle = otherHandle;
                        driver.switchTo().window(vacancyHandle);
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
