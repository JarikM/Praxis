/*
POM: according to Page Object Model pattern tests are located in separate package (folder)
MVP: according to Minimum Viable Product pattern only needed tests were designed
Scope: Cover scenarios of my profile edit and email/password edit. Please decide by yourself what cases are needed.
Tests done:
    - check changing password (happy path)
    - check changing email (happy path)
Test to be designed:
    - check when setting the same email/password
    - check changing allowed email/password (positive tests) - use Equivalence Partitioning test design pattern
    - check changing forbidden email/password (negative tests) - use Equivalence Partitioning test design pattern
 */

package tests;

import Managers.WebDriverManager;
import POM.Pages.PraxisLoginPage;
import POM.Pages.PraxisMyProfilePage;
import POM.Pages.PraxisRegistartionPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.User;

public class PraxisEditMyProfileTest {
    private User user;

    @BeforeClass
    public void generateNewCredentials() {
        // Generating email address
        String email = RandomStringUtils.randomAlphanumeric(10).toUpperCase() + "@mail.com";
        // Generating password
        String pass = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
        user = new User(email, pass);
//        user = new User().setEmail().setPassword(); // (1) alternative to setters
    }

    @AfterMethod
    public void logout() {
        new PraxisMyProfilePage().logout();
    }

    @Test
    public void registerNewUser() {
        PraxisRegistartionPage reg = new PraxisRegistartionPage()
                .open()
                .selectGender(user.getGender())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPostCode(user.getPostCode())
                .setAddress(user.getAddress())
                .setStreet(user.getStreet())
                .setHouseNumber(user.getHouseNumber())
                .setEmailAddress(user.getEmail())
                .setPassword(user.getPassword())
                .clickCreateNewAccountButton();
        Assert.assertEquals("", "");  // actual & expected to be added
    }

    @Test
    public void editEmail() {
        new PraxisLoginPage()
                .open()
                .login(user.getEmail(), user.getPassword());

        user.setEmail(RandomStringUtils.randomAlphanumeric(10).toUpperCase() + "@mail.com");
        PraxisMyProfilePage email = new PraxisMyProfilePage()
                .open()
                .setChangeEmailAddressField(user.getEmail())
                .setPasswordWhenChangeEmailField(user.getPassword())
                .clickChangeEmailAddressButton();
        Assert.assertEquals(email.getChangeEmailConfirmationText(), "Nice, email has been changed");
    }

    @Test
    public void editPassword() {
        new PraxisLoginPage()
                .open()
                .login(user.getEmail(), user.getPassword());

        PraxisMyProfilePage pass = new PraxisMyProfilePage()
                .open()
                .setCurrentPasswordField(user.getPassword())
                .setNewPasswordField(user.setPassword(RandomStringUtils.randomAlphanumeric(10).toUpperCase()).getPassword())
                .clickUpdatePasswordButton();
        Assert.assertEquals(pass.getChangePasswordConfirmationText(),"Nice, password has been changed");
    }

    @Test
    public void checkLoginWithNewPassword() {
        PraxisMyProfilePage login = new PraxisLoginPage()
                .open()
                .login(user.getEmail(), user.getPassword());
        Assert.assertEquals(login.getUserWelcomeText(), "welkom " + user.getFirstName() + " " + user.getLastName());
    }

    /**
    This test is to show DDT (Data Driven Testing) pattern
    Test will cover login functionality only
    Scope: to test email addresses of different providers(domains)
     Prerequisites: all the users were already registered
     */
    @Test(dataProvider = "checkDifferentEmailDomains")
    public void loginWithDifferentEmailDomains(String mail, String pass) {
        PraxisMyProfilePage login = new PraxisLoginPage()
                .open()
                .login(mail, pass);
        Assert.assertEquals(login.getUserWelcomeText(), "welkom " + user.getFirstName() + " " + user.getLastName());
    }

    @DataProvider
    public Object [][] checkDifferentEmailDomains() {
        return new Object[][] {
                {"thomas@gmail.com", "password"},
                {"andrew@yahoo.com", "password"},
                {"tanya@mail.ru", "password"},
                {"john@outlook.com", "password"},
                {"zina@aol.com", "password"},
                {"ursula@yandex.com", "password"},
                {"andreas@protonmail.com", "password"}
        };
    }

    @AfterClass
    public void exit() {
        WebDriverManager.close();
    }
}
