package POM.Pages;

import org.openqa.selenium.By;
import utils.Logger;

public class PraxisMyProfilePage extends AbstractPage {
    private static final String PAGE_NAME = "MyProfile Page > ";

    private static final By EMAIL_FIELD_LOCATOR = By.id("email");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
    private static final By CURRENT_PASSWORD_FIELD_LOCATOR = By.id("old-password");
    private static final By NEW_PASSWORD_FIELD_LOCATOR = By.id("new-password");
    private static final By CHANGE_EMAIL_ADRESS_BUTTON_LOCATOR = By.xpath("//*[@data-webdriver='update-email-submit']");
    private static final By UPDATE_PASSWORD_BUTTON_LOCATOR = By.xpath("//*[@data-webdriver='update-password-submit']");
    private static final By WELCOME_USER_TEXT_LOCATOR = By.xpath("//span[@data-reactid='110']");
    private static final By CHANGE_EMAIL_CONFIRMATION_TEXT_LOCATOR = By.xpath("//*[@data-reactid='132' and @class='mxd-grid']/div[@class='mxd-notification mxd-notification-success mxd-icon mxd-icon-info']/div");
    private static final By CHANGE_PASSWORD_CONFIRMATION_TEXT_LOCATOR = By.xpath("//*[@data-reactid='160' and @class='mxd-grid']/div[@class='mxd-notification mxd-notification-success mxd-icon mxd-icon-info']/div");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("");

    public PraxisMyProfilePage() {
        url = "https://www.acc.praxis.nl/voordemakers/myprofile/edit";
    }

    @Override
    public PraxisMyProfilePage open() {
        super.open();
        return this;
    }

    public String getUserWelcomeText() {
        Logger.STEP(PAGE_NAME + "Get User's welcome text");
        return getText(WELCOME_USER_TEXT_LOCATOR).getText(3);
    }

    public String getChangeEmailConfirmationText() {
        Logger.STEP(PAGE_NAME + "Get confirmation text after email was changed");
        return getText(CHANGE_EMAIL_CONFIRMATION_TEXT_LOCATOR).getText(3);
    }

    public String getChangePasswordConfirmationText() {
        Logger.STEP(PAGE_NAME + "Get confirmation text after password was changed");
        return getText(CHANGE_PASSWORD_CONFIRMATION_TEXT_LOCATOR).getText(3);
    }

    public PraxisMyProfilePage setPasswordWhenChangeEmailField(String password) {
        Logger.STEP(PAGE_NAME + "Filling the password");
        getInput(PASSWORD_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(PASSWORD_FIELD_LOCATOR).sendKeys(password);
        return this;
    }

    public PraxisMyProfilePage setCurrentPasswordField(String currentPassword) {
        Logger.STEP(PAGE_NAME + "Filling the current password");
        getInput(CURRENT_PASSWORD_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(CURRENT_PASSWORD_FIELD_LOCATOR).sendKeys(currentPassword);
        return this;
    }

    public PraxisMyProfilePage setNewPasswordField(String newPassword) {
        Logger.STEP(PAGE_NAME + "Filling the new password");
        getInput(NEW_PASSWORD_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(NEW_PASSWORD_FIELD_LOCATOR).sendKeys(newPassword);
        return this;
    }

    public PraxisMyProfilePage setChangeEmailAddressField(String newEmail) {
        Logger.STEP(PAGE_NAME + "Filling new email address to be changed");
        getInput(EMAIL_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(EMAIL_FIELD_LOCATOR).sendKeys(newEmail);
        return this;
    }

    public PraxisMyProfilePage clickChangeEmailAddressButton() {
        Logger.ACTION(PAGE_NAME + "Clicking the Change Email Address button");
        getButton(CHANGE_EMAIL_ADRESS_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return this;
    }

    public PraxisMyProfilePage clickUpdatePasswordButton() {
        Logger.ACTION(PAGE_NAME + "Clicking the Update Password button");
        getButton(UPDATE_PASSWORD_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return this;
    }

    public PraxisHomePage logout() {
        Logger.STEP(PAGE_NAME + "Logging out");
        getButton(LOGOUT_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return new PraxisHomePage();
    }
}
