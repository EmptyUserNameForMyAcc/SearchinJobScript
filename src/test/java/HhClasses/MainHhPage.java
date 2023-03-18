package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ITests.SearchingJobScript.hhHandle;
public class MainHhPage {
    public final WebDriver driver;

    public MainHhPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@data-qa = 'login']")
    private WebElement redirectToInputSignInData;

    public void clickAndLetsSignIn() {
        driver.switchTo().window(hhHandle);
        redirectToInputSignInData.click();
    }
}
