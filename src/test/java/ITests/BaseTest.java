package ITests;

import HhClasses.*;

import MailRuClasses.InsideMailRuBoxPage;
import MailRuClasses.MainMailRuPage;
import MailRuClasses.SignInMailRuPopUp;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public WebDriver driver;

    public MainHhPage mainHhPage;
    public SignInHhPage signInHhPage;
    public ProfileHhPage profileHhPage;
    public VacacysHhPage vacacysHhPage;
    public OtherCountryHhPopUp otherCountryHhPopUp;
    public InsideVacancyHhPage insideVacancyHhPage;

    public MainMailRuPage mainMailRuPage;
    public SignInMailRuPopUp signInMailRuPopUp;
    public InsideMailRuBoxPage insideMailRuBoxPage;

    public static String hhHandle;
    public static String mailRuHandle;
    public static String secretCode;

    @BeforeAll
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Deprecated
    @BeforeEach
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        mainHhPage = new MainHhPage(driver);
        signInHhPage = new SignInHhPage(driver);
        profileHhPage = new ProfileHhPage(driver);
        vacacysHhPage = new VacacysHhPage(driver);
        insideVacancyHhPage = new InsideVacancyHhPage(driver);
        otherCountryHhPopUp = new OtherCountryHhPopUp(driver);

        mainMailRuPage = new MainMailRuPage(driver);
        signInMailRuPopUp = new SignInMailRuPopUp(driver);
        insideMailRuBoxPage = new InsideMailRuBoxPage(driver);

        driver.get(ConfProperties.getProperty("hhUrl"));
        hhHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).navigate().to(ConfProperties.getProperty("mailRuUrl"));

        for (String differentHandle : driver.getWindowHandles()) {
            if(!hhHandle.contentEquals(differentHandle)) {
                mailRuHandle = differentHandle;
                break;
            }
        }
    }

    @AfterEach
    public void tearsDown() {
        driver.close();
        driver.quit();
    }
}
