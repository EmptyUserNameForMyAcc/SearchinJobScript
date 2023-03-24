package ITests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.base.BaseTestPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchingJobScript extends BaseTestPage{
    /**
     * Данный тест проводит авторизацию на двух сервисах: Hh.ru и Mail.ru.
     */
    @Tag("authorizationTest")
    @Order(1)
    @Test
    public void authorizationTest() {
        mainHhPage
                .clickAndLetsSignIn();

        signInHhPage
                .sendLoginData()
                .submitLogin();

        mainMailRuPage
                .goToSignIn();

        signInMailRuPopUp
                .inputLogin()
                .submitLogin()
                .inputPassword()
                .submitPassword();

        insideMailRuBoxPage
                .readMassageWithSecretCode()
                .getSecretCode();

        signInHhPage
                .sendPasswordDataAndSubmit()
                .submitSignInData();

        System.out.println("крос");
    }

    /**
     * Данный тест осуществляет поиск, фильтрацию и откликается на/ скрывает вакансии по заданным параметрам.
     */
    @Tag("SearchingJobScript")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"разработчик", "программист", "QA Automation Engineer", "Тестировщик", "Автотестировщик", "Автоматическому тестированию",
            "Автоматизации тестирования", "AQA", "QA инженер", "QA engineer", "QA Engineer Automation", "Qa Java",
            "Тест"})
    public void searchingScriptTest(String testData) {
        profileHhPage
                .letsFindAJobYep(testData);

        vacancysHhPage
                .getVacancysDescription();

        insideVacancyHhPage
                .sortVacancy();

        profileHhPage
                .clearSearchingField();

        System.out.println("крос");
    }
}
