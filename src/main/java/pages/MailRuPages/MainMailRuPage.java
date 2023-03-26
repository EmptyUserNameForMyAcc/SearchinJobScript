package pages.MailRuPages;

import pages.base.BaseTestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMailRuPage extends BaseTestPage {
    public MainMailRuPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement buttonOpenSignInPopUp;

    public void goToSignIn() {
        driver.switchTo().window(BaseTestPage.mailRuHandle);
        buttonOpenSignInPopUp.click();
    }
}
