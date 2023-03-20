package ITests;

import MailRuClasses.InsideMailRuBoxPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
        InsideMailRuBoxPage.getSecretCode();

        signInHhPage.sendPasswordDataAndSubmit();

        System.out.println("крос");
        System.out.println(InsideMailRuBoxPage.getSecretCode());

    }
}
