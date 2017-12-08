/*

POM: according to Page Object Model pattern only several pages were created
MVP: according to Minimum Viable Product pattern only needed methods were declared and implemented

 */

package POM.Pages;

import org.openqa.selenium.By;
import utils.Logger;

public class PraxisHomePage extends AbstractPage {
    private static final String PAGE_NAME = "Home Page > ";

    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//*[@data-reactid='108']");
    private static final By REGISTER_BUTTON_LOCATOR = By.xpath("//*[@data-reactid='113']");

    public PraxisHomePage() {
        url = "https://www.acc.praxis.nl/voordemakers";
    }

    @Override
    public PraxisHomePage open() {
        super.open();
        return this;
    }

    public PraxisLoginPage clickLogin() {
        Logger.ACTION(PAGE_NAME + "Clicking the Login button");
        getButton(LOGIN_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return new PraxisLoginPage();
    }

    public PraxisRegistartionPage clickRegister() {
        Logger.ACTION(PAGE_NAME + "Clicking the Register button");
        getButton(REGISTER_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return new PraxisRegistartionPage();
    }
}
