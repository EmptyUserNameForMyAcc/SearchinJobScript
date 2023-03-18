package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherCountryHhPopUp {
    public final WebDriver driver;

    public OtherCountryHhPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@data-qa = 'relocation-warning-confirm']")
    private WebElement submitSearchingButton;


}
