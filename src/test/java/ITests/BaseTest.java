package ITests;

import HhClasses.*;

import MailRuClasses.InsideMailRuBoxPage;
import MailRuClasses.MainMailRuPage;
import MailRuClasses.SignInMailRuPopUp;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import resources.ConfProperties;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static WebDriver driver;

    public MainHhPage mainHhPage;
    public SignInHhPage signInHhPage;
    public ProfileHhPage profileHhPage;
    public VacancysHhPage vacancysHhPage;
    public OtherCountryHhPopUp otherCountryHhPopUp;
    public InsideVacancyHhPage insideVacancyHhPage;

    public MainMailRuPage mainMailRuPage;
    public SignInMailRuPopUp signInMailRuPopUp;
    public InsideMailRuBoxPage insideMailRuBoxPage;

    public static String hhHandle;
    public static String mailRuHandle;
    public static String vacancyHandle;
    public static Actions actions;
    public static String secretCode;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);

        driver.get(ConfProperties.getProperty("hhUrl"));
        hhHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).navigate().to(ConfProperties.getProperty("mailRuUrl"));
        mailRuHandle = driver.getWindowHandle();
    }

    @Deprecated
    @BeforeEach
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        mainHhPage = new MainHhPage(driver);
        signInHhPage = new SignInHhPage(driver);
        profileHhPage = new ProfileHhPage(driver);
        vacancysHhPage = new VacancysHhPage(driver);
        insideVacancyHhPage = new InsideVacancyHhPage(driver);
        otherCountryHhPopUp = new OtherCountryHhPopUp(driver);

        mainMailRuPage = new MainMailRuPage(driver);
        signInMailRuPopUp = new SignInMailRuPopUp(driver);
        insideMailRuBoxPage = new InsideMailRuBoxPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
