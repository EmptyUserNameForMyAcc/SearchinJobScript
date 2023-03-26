package pages.HhPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.base.BaseTestPage;

public class MainHhPage extends BaseTestPage {

    public MainHhPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-qa = 'login']")
    private WebElement redirectToInputSignInData;

    public MainHhPage clickAndLetsSignIn() {
        driver.switchTo().window(BaseTestPage.hhHandle);
        redirectToInputSignInData.click();
        return this;
    }
}
