package HhClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacacysHhPage {
    public WebDriver driver;
    public VacacysHhPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy
}
