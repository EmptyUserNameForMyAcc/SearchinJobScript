package pages.HhPages;

import org.junit.jupiter.api.Assertions;
import pages.base.BaseTestPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static constants.Constants.TextVariables.nextPage;

public class VacancysHhPage extends BaseTestPage {

    public VacancysHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3//a")
    private List<WebElement> vacancysTitle;

    @FindBy(xpath = "//a[@data-qa='pager-next']")
    private WebElement nextButton;

    public void goToVacancyAndSortThatForOne() {
        try {
            short vacancyCounter = 0;
            boolean isVacancysOnThePageIsOver = vacancysTitle.size() == vacancyCounter;
            boolean isAllPageIsOver = !(waitElementIsVisible(nextButton).isDisplayed());

            for (WebElement oneVacancy : waitElementsIsVisible(vacancysTitle)) {
                driver.switchTo().window(hhHandle);

                String vacancyUrl = "";
                vacancyCounter++;

                if (isVacancysOnThePageIsOver) {
                    vacancyCounter = 0;
                    nextPage = nextButton.getAttribute("href");
                    open(nextPage);
                    goToVacancyAndSortThatForOne();

                    System.out.println(vacancysTitle.size());
                } else if (isAllPageIsOver) {
                    profileHhPage.clearSearchingField();
                    Assertions.fail("Test finished successfully!");
                }

                System.out.println(vacancyCounter + "<- я short каунтер - я инт сайз ->  " + vacancysTitle.size());

                vacancyUrl = waitElementIsVisible(oneVacancy).getAttribute("href");
                System.out.println(vacancyUrl);
                openInNewTab(vacancyUrl);
                vacancyHandle = driver.getWindowHandle();
                insideVacancyHhPage.sortVacancy();

            }
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
