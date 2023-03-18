package ITests;

import HhClasses.*;
import MailRuClasses.InsideMailRuBoxPage;

import MailRuClasses.MainMailRuPage;
import MailRuClasses.SignInMailRuPopUp;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchingJobScript {
    public WebDriver driver;
    public MainHhPage mainHhPage;
    public SignInHhPage signInHhPage;
    public VacancysHhPage vacancysHhPage;
    public OtherCountryHhPopUp otherCountryHhPopUp;
    public InsideVacancyHhPage insideVacancyHhPage;

    public MainMailRuPage mainMailRuPage;
    public SignInMailRuPopUp signInMailRuPopUp;
    public InsideMailRuBoxPage insideMailRuBoxPage;

    public static String hhHandle;
    public static String mailRuHandle;

    @BeforeAll
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        mainHhPage = new MainHhPage(driver);
        signInHhPage = new SignInHhPage(driver);
        vacancysHhPage = new VacancysHhPage(driver);
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

    @Tag("SearchingJobScript")
    @Test
    public void searchingTest() {
        mainHhPage.clickAndLetsSignIn();
        signInHhPage.sendLoginData();
        signInHhPage.submitLogin();
        signInHhPage.submitSignInData();
//        insideMailRuBoxPage.
    }

    @AfterEach
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }
}
