/*
POM: according to Page Object Model pattern only several pages were created
MVP: according to Minimum Viable Product pattern only needed methods were declared and implemented
 */

package POM.Pages;

import org.openqa.selenium.By;
import utils.Logger;

public class PraxisLoginPage extends AbstractPage {
    private static final String PAGE_NAME = "Login Page > ";

    private static final By EMAIL_ADRESS_FIELD_LOCATOR = By.id("username");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("submit");

    public PraxisLoginPage() {
        url = "https://www.acc.praxis.nl/voordemakers/login";
    }

    @Override
    public PraxisLoginPage open() {
        super.open();
        return this;
    }

    public PraxisLoginPage setEmailAdress(String emailAdress) {
        Logger.STEP(PAGE_NAME + "Filling the email address");
        getInput(EMAIL_ADRESS_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(EMAIL_ADRESS_FIELD_LOCATOR).sendKeys(emailAdress);
        return this;
    }

    public PraxisLoginPage setPassword(String password) {
        Logger.STEP(PAGE_NAME + "Filling the password");
        getInput(PASSWORD_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(PASSWORD_FIELD_LOCATOR).sendKeys(password);
        return this;
    }

    public PraxisLoginPage clickLoginButton() {
        Logger.ACTION(PAGE_NAME + "Clicking the Login button");
        getButton(LOGIN_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return this;
    }

    public PraxisMyProfilePage login(String emailAddress, String password) {
        setEmailAdress(emailAddress);
        setPassword(password);
        clickLoginButton();
        return new PraxisMyProfilePage();
    }
}
