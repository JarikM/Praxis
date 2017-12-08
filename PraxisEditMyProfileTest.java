/*
POM: according to Page Object Model pattern tests are located in separate package (folder)
MVP: according to Minimum Viable Product pattern only needed tests were designed
 */

package tests;

import Managers.WebDriverManager;
import POM.Pages.PraxisLoginPage;
import POM.Pages.PraxisMyProfilePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class PraxisEditMyProfileTest {
    private static final String EMAIL_1 = "genius13@mailinator.com";
    private static final String EMAIL_2 = "thomas@mailinator.com";
    private static final String PASSWORD_1 = "password";
    private static final String PASSWORD_2 = "password1";

    @BeforeTest
    public void logIn() {
        PraxisMyProfilePage logIn = new PraxisLoginPage()
                .open()
                .login(EMAIL_1, PASSWORD_1);
        Assert.assertEquals(logIn.getUserWelcomeText(), "welkom Thomas Braune");
    }

    @AfterClass
    public void exit() {
        WebDriverManager.close();
    }

    @Test
    public void editEmail() {
        PraxisMyProfilePage email = new PraxisMyProfilePage()
                .open()
                .setChangeEmailAddressField(EMAIL_2)
                .setPasswordWhenChangeEmailField(PASSWORD_1)
                .clickChangeEmailAddressButton();
        Assert.assertEquals(email.getChangeEmailConfirmationText(), "Nice, email has been changed");
    }

    @Test
    public void editPassword() {
        PraxisMyProfilePage pass = new PraxisMyProfilePage()
                .open()
                .setCurrentPasswordField(PASSWORD_1)
                .setNewPasswordField(PASSWORD_2)
                .clickUpdatePasswordButton();
        Assert.assertEquals(pass.getChangePasswordConfirmationText(),"Nice, password has been changed");
    }
}
