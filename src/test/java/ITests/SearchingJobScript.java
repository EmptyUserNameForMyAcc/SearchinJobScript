package ITests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.StaleElementReferenceException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchingJobScript extends BaseTest {
    /**
     * Данный тест проводит авторизацию на двух сервисах: Hh.ru и Mail.ru.
     */
    @Tag("authorizationTest")
    @Order(1)
    @Test
    public void authorizationTest() throws InterruptedException, StaleElementReferenceException {
        mainHhPage.clickAndLetsSignIn();

        signInHhPage.sendLoginData();
        signInHhPage.submitLogin();

        mainMailRuPage.goToSignIn();

        signInMailRuPopUp.inputLogin();
        signInMailRuPopUp.submitLogin();
        signInMailRuPopUp.inputPassword();
        signInMailRuPopUp.submitPassword();

        insideMailRuBoxPage.readMassageWithSecretCode();
        insideMailRuBoxPage.getSecretCode();

        signInHhPage.sendPasswordDataAndSubmit();
        signInHhPage.submitSignInData();
        System.out.println("крос");
    }

    /**
     * Данный тест осуществляет поиск, филтрацию и откликается на/ скрывает вакансии по заданным параметрам.
     */
    @Tag("SearchingJobScript")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"QA Automation Engineer Тестировщик", "Автотестировщик", "Автоматическому тестированию",
            "Автоматизации тестирования", "AQA", "QA инженер", "QA engineer", "QA Engineer Automation", "Qa Java",
            "Тест"})
    public void searchingScriptTest(String testData) {
        profileHhPage.letsFindAJobYep(testData);

        vacancysHhPage.getVacancysDescription();
        insideVacancyHhPage.sortVacancy();

        profileHhPage.clearSearchingField();
        System.out.println("крос");
    }
}
