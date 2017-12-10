/*
POM: according to Page Object Model pattern only several pages were created
MVP: according to Minimum Viable Product pattern only needed methods were declared and implemented
 */

package POM.Pages;

import org.openqa.selenium.By;
import utils.Logger;

public class PraxisRegistartionPage extends AbstractPage {
    private static final String PAGE_NAME = "Registration page > ";

    // to be added
    private static final By EMAIL_ADDRESS_FIELD_LOCATOR = By.xpath("");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("");
    private static final By CREATE_NEW_ACCOUNT_BUTTON_LOCATOR = By.xpath("");
    private static final By POST_CODE_FIELD_LOCATOR = By.xpath("");
    private static final By FIRST_NAME_FIELD_LOCATOR = By.xpath("");
    private static final By LAST_NAME_FIELD_LOCATOR = By.xpath("");
    private static final By ADDRESS_FIELD_LOCATOR = By.xpath("");
    private static final By HOUSE_NUMBER_FIELD_LOCATOR = By.xpath("");
    private static final By STREET_NAME_FIELD_LOCATOR = By.xpath("");
    private static final By GENDER_LOCATOR = By.xpath("");
    private static final By PASSWORD_CONFIRMATION_FIELD_LOCATOR = By.xpath("");

    public PraxisRegistartionPage() {
        url = "https://www.acc.praxis.nl/voordemakers/myprofile/register";
    }

    @Override
    public PraxisRegistartionPage open() {
        super.open();
        return this;
    }

    public PraxisRegistartionPage setEmailAddress(String email) {
        Logger.STEP(PAGE_NAME + "Filling email address field");
        getInput(EMAIL_ADDRESS_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(EMAIL_ADDRESS_FIELD_LOCATOR).sendKeys(email);
        return this;
    }

    public PraxisRegistartionPage setPassword(String pass) {
        Logger.STEP(PAGE_NAME + "Filling password field");
        getInput(PASSWORD_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(PASSWORD_FIELD_LOCATOR).sendKeys(pass);
        return this;
    }

    public PraxisRegistartionPage setPasswordConfirmation(String passConfirm) {
        Logger.STEP(PAGE_NAME + "Filling password confirmation field");
        getInput(PASSWORD_CONFIRMATION_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(PASSWORD_CONFIRMATION_FIELD_LOCATOR).sendKeys(passConfirm);
        return this;
    }

    public PraxisRegistartionPage selectGender(String gender) {
        Logger.STEP(PAGE_NAME + "Selecting gender");
        getSelect(GENDER_LOCATOR).waitForElementVisible(3);
        getSelect(GENDER_LOCATOR).selectByVisibleText(gender);
        return this;
    }

    public PraxisRegistartionPage setFirstName(String firstName) {
        Logger.STEP(PAGE_NAME + "Filling first name field");
        getInput(FIRST_NAME_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(FIRST_NAME_FIELD_LOCATOR).sendKeys(firstName);
        return this;
    }

    public PraxisRegistartionPage setLastName(String lastName) {
        Logger.STEP(PAGE_NAME + "Filling last name field");
        getInput(LAST_NAME_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(LAST_NAME_FIELD_LOCATOR).sendKeys(lastName);
        return this;
    }

    public PraxisRegistartionPage setAddress(String address) {
        Logger.STEP(PAGE_NAME + "Filling address field");
        getInput(ADDRESS_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(ADDRESS_FIELD_LOCATOR).sendKeys(address);
        return this;
    }

    public PraxisRegistartionPage setHouseNumber(String houseNumber) {
        Logger.STEP(PAGE_NAME + "Filling house number field");
        getInput(HOUSE_NUMBER_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(HOUSE_NUMBER_FIELD_LOCATOR).sendKeys(houseNumber);
        return this;
    }

    public PraxisRegistartionPage setStreet(String street) {
        Logger.STEP(PAGE_NAME + "Filling street name field");
        getInput(STREET_NAME_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(STREET_NAME_FIELD_LOCATOR).sendKeys(street);
        return this;
    }

    public PraxisRegistartionPage setPostCode(String postCode) {
        Logger.STEP(PAGE_NAME + "Filling post code field");
        getInput(POST_CODE_FIELD_LOCATOR).waitForElementVisible(3);
        getInput(POST_CODE_FIELD_LOCATOR).sendKeys(postCode);
        return this;
    }

    public PraxisRegistartionPage clickCreateNewAccountButton() {
        Logger.ACTION(PAGE_NAME + "Clicking create new accoynt button");
        getButton(CREATE_NEW_ACCOUNT_BUTTON_LOCATOR).waitForClickableAndClick(3);
        return this;
    }
}
