package pages.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.HhClasses.*;
import pages.MailRuClasses.InsideMailRuBoxPage;
import pages.MailRuClasses.MainMailRuPage;
import pages.MailRuClasses.SignInMailRuPopUp;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import resources.ConfProperties;

import java.time.Duration;
import java.util.List;

import static constants.Constants.TimeOutsVariables.*;

public abstract class BaseTestPage {

    public static WebDriver driver;

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List<WebElement> waitElementIsVisible(List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT)).until(ExpectedConditions
                .visibilityOfAllElements(elements));
        return elements;
    }

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
    public static Actions actions;
    public static String secretCode;
    public static String vacancyHandle;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(LOADING_PAGE_WAIT));

        actions = new Actions(driver);

        driver.get(ConfProperties.getProperty("hhUrl"));
        hhHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).navigate().to(ConfProperties.getProperty("mailRuUrl"));
        mailRuHandle = driver.getWindowHandle();
    }

    @BeforeEach
    public void setup() {
        mainHhPage = new MainHhPage();
        signInHhPage = new SignInHhPage();
        profileHhPage = new ProfileHhPage();
        vacancysHhPage = new VacancysHhPage();
        insideVacancyHhPage = new InsideVacancyHhPage();
        otherCountryHhPopUp = new OtherCountryHhPopUp();

        mainMailRuPage = new MainMailRuPage();
        signInMailRuPopUp = new SignInMailRuPopUp();
        insideMailRuBoxPage = new InsideMailRuBoxPage();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}