package ITests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SearchingJobScript extends BaseTest{

    @Tag("SearchingJobScript")
    @Test
    public void searchingTest() throws InterruptedException{
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

//    @ParameterizedTest
//    @ValueSource
}
