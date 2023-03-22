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
            for (WebElement vacancyTitle : waitElementIsVisible(vacancysTitle)) {
                if (driver.getWindowHandles().size() == 1) {
                    System.out.println(driver.getWindowHandles().size() + " я количество открытых табов");
                    BaseTestPage.actions
                            .keyDown(waitElementIsVisible(vacancyTitle), Keys.LEFT_CONTROL)
                            .clickAndHold()
                            .perform();

                    for (String otherHandle : driver.getWindowHandles()) {
                        if (!hhHandle.contentEquals(otherHandle)) {
                            vacancyHandle = otherHandle;
                            driver.switchTo().window(vacancyHandle);
                            break;
                        }
                    }
                }
                insideVacancyHhPage.sortVacancy();
            }
        } catch (JsonException | TimeoutException e) {
            e.getCause().getStackTrace();
        }
    }

    public void randomWait() {
        try {
            Thread.sleep((int) Constants.TimeOutsVariables.RANDOM_WAIT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
