package pages.base;

import constants.Constants;
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
    public static String secretCode;
    public static String vacancyHandle;
    public static Actions actions;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT10S));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(LOADING_PAGE_WAIT30S));

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

    public void open(String url) {
        driver.get(url);
    }

    /**
     *
     *
     * НАЧАЛО БЛОКА ОЖИДАНИЯ ПОЯВЛЕНИЯ И ИСЧЕСЗОВЕНИЯ ЭЛЕМЕНТОВ.
     *
     *
     *
     */

    /**
     * Задаёт явное ожидание для ПОЯВЛЕНИЯ ОДНОГО элемента. (По умолчанию 10 сек.)
     */
    public WebElement waitElementIsVisible(WebElement visibilityOfElement) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT_TIME10S))
                .until(ExpectedConditions.visibilityOf(visibilityOfElement));
        return visibilityOfElement;
    }

    /**
     * Явное ожидание для ПОЯВЛЕНИЯ МНОЖЕСТВА элементов. (По умолчанию 10 сек.)
     */
    public List<WebElement> waitElementsIsVisible(List<WebElement> longVisibilityOfElements) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT_TIME10S))
                .until(ExpectedConditions.visibilityOfAllElements(longVisibilityOfElements));
        return longVisibilityOfElements;
    }

    /**
     * ЗАДАВАЕМОЕ время ожидания для ПОЯВЛЕНИЯ ОДНОГО элемента. (Позволяет задавать произвольные
     * значения ожидания.)
     */
    public WebElement adaptiveWaitElementIsVisible(WebElement longWaitElement, short TIME) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME))
                .until(ExpectedConditions.visibilityOf(longWaitElement));
        return longWaitElement;
    }

    /**
     * ЗАДАВАЕМОЕ время ожидания для ПОЯВЛЕНИЯ МНОЖЕСТВА элементов. (Позволяет задавать произвольные
     * значения ожидания.)
     */
    public List<WebElement> adaptiveWaitElementsIsVisible(List<WebElement> visibilityOElements, short TIME) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME))
                .until(ExpectedConditions.visibilityOfAllElements(visibilityOElements));
        return visibilityOElements;
    }

    /**
     * Ожидание ИСЧЕЗНОВЕНИЯ ОДНОГО элемента. (По умолчанию 10 сек.)
     */
    public WebElement waitInvisibilityOfElement(WebElement invisOfElement) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT_TIME10S))
                .until(ExpectedConditions.invisibilityOf(invisOfElement));
        return invisOfElement;
    }

    /**
     * ЗАДАВАЕМОЕ ожидание времени ИСЧЕЗНОВЕНИЯ ОДНОГО элемента. (Позволяет задавать произвольные значения ожидания.)
     */
    public WebElement adaptiveWaitInvisibilityOfElement(WebElement invisOfElement, short TIME) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME))
                .until(ExpectedConditions.invisibilityOf(invisOfElement));
        return invisOfElement;
    }

    /**
     * ЗАДАВАЕМОЕ ожидание времени ИСЧЕЗНОВЕНИЯ МНОЖЕСТВА элементов. (Позволяет задавать произвольные значения ожидания.)
     */
    public List<WebElement> adaptiveWaitInvisibilityOfElements(List<WebElement> invisOfElements) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_EXPLICITLY_WAIT5M))
                .until(ExpectedConditions.invisibilityOfAllElements());
        return invisOfElements;
    }

    /**
     *
     *
     * КОНЕЦ БЛОКА С МЕТОДАМИ ОЖИДАНИЯ.
     *
     *
     * */


    /*
     *
     * НАЧАЛО БЛОКА РАНДОМА
     *
     */

    /**
     * Задаёт рандомное время ожидания треда.
     */
    public void randomWait() {
        try {
            Thread.sleep((short) Constants.TimeOutsVariables.RANDOM_WAIT_TO4S);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     *
     * КОНЕЦ БЛОКА РАНДОМА
     *
     **/
}