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

    public void getVacancysDescription() {
        try {
            for (WebElement oneVacancy : vacancysTitle) {
                String vacacyUrl = oneVacancy.getAttribute("href");
                System.out.println(vacacyUrl);

                driver.switchTo().newWindow(WindowType.TAB).navigate().to(vacacyUrl);
                vacancyHandle = driver.getWindowHandle();
                System.out.println("Я ID вакансии " + vacancyHandle + "\n" + "Я ID Hh " + hhHandle);
                insideVacancyHhPage.sortVacancy();
            }
        } catch (TimeoutException e) {
            e.getCause().getStackTrace();
        }
    }
}
