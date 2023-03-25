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

    @FindBy(xpath = "//a[@data-qa='pager-next']")
    private WebElement nextButton;

    public void goToVacancyForOneAndSortThat() {
        try {
            short iterCounter = 0;
            for (WebElement oneVacancy : vacancysTitle) {
                driver.switchTo().window(hhHandle);

                iterCounter++;
                if (vacancysTitle.size() == iterCounter && vacancysTitle.size() != 6) {
                    iterCounter = 0;
                    nextButton.click();
                }
                String vacancyUrl = oneVacancy.getAttribute("href");
                System.out.println(vacancyUrl);

                driver.switchTo().newWindow(WindowType.TAB).navigate().to(vacancyUrl);
                vacancyHandle = driver.getWindowHandle();

                System.out.println(iterCounter + "<- я short каунтер - я инт сайз->  " + vacancysTitle.size());

                insideVacancyHhPage.sortVacancy();
            }
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
