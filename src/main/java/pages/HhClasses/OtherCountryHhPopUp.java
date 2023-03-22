package pages.HhClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.base.BaseTestPage;

public class OtherCountryHhPopUp extends BaseTestPage {

    public OtherCountryHhPopUp() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-qa = 'relocation-warning-confirm']")
    private WebElement submitSearchingButton;
}
