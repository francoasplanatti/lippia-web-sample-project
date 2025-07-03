package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.PracticeHomeService;


public class PracticeSteps {

    //  Registration Steps

    @Given("^The client is on automation practice page$")
    public void home() {
        PracticeHomeService.navigateWeb();
    }

    @And("^user clicks on \"My Account Menu\"$")
    public void userClicksOnMyAccountMenu() {
        PracticeHomeService.clickMyAccountMenu();
    }

    @And("^user enters as email(.*)$")
    public void userEntersAsEmail(String email) {
        PracticeHomeService.enterEmail(email);
    }

    @And("^user enters registration password(.*)$")
    public void userEntersRegPassword(String password) {
        PracticeHomeService.enterRegPassword(password);
    }

    @And("^user enters as login password(.*)$")
    public void userEntersAsLogPassword(String password) {
        PracticeHomeService.enterLogPassword(password);
    }

    @And("^user clicks on \"Register\" button$")
    public void userClicksOnRegisterButton() {
        PracticeHomeService.clickRegisterButton();
    }

    @Then("^user will be registered successfully$")
    public void userWillBeRegisteredSuccessfully() {
        PracticeHomeService.verifySuccessfulRegistration();
    }

    @And("^user will be navigated to the Home Page$")
    public void userWillBeNavigatedToTheHomePage() {
        PracticeHomeService.verifyNavigationToHomePage();
    }

    @Then("^user will fail registration$")
    public void userWillFailRegistration() {
        PracticeHomeService.verifyFailedRegistration();
    }

    @Then("^user will fail registration with empty email error$")
    public void userWillFailRegistrationWithEmptyEmailError() {
        PracticeHomeService.verifyEmptyEmailError();
    }

    @Then("^user will fail registration with empty password error$")
    public void userWillFailRegistrationWithEmptyPasswordError() {
        PracticeHomeService.verifyEmptyPasswordError();
    }

    // Login Steps

    @Given("^user enters as username (.*)$")
    public void userEntersAsUsername(String username) {
        PracticeHomeService.enterUsername(username);
    }

    @And("^user clicks on \"Login\" button$")
    public void userClicksOnLoginButton() {
        PracticeHomeService.clickLoginButton();
    }

    @Then("^user will login successfully$")
    public void userWillLoginSuccessfully() {
        PracticeHomeService.verifySuccessfulLogin();
    }

    @Then("^login must fail with a warning message (.*)$")
    public void loginMustFailWithAWarningMessage(String error) {
        PracticeHomeService.verifyFailedLogin(error);
    }

    @When("^user clicks on \"Logout\" link$")
    public void userClicksOnLogoutLink() {
        PracticeHomeService.clickLogoutLink();
    }

    @When("^user navigates back$")
    public void userNavigatesBack() {
        PracticeHomeService.navigateBack();
    }

    @Then("^user should see the account login page$")
    public void userShouldSeeTheAccountLoginPage() {
        PracticeHomeService.verifyLoginPageVisible();
    }

    @When("^user clicks on \"Account Details\"$")
    public void userClicksOnAccountDetails() {
        PracticeHomeService.clickAccountDetails();
    }

    @Then("^user should see the account details$")
    public void userShouldSeeTheAccountDetails() {
        PracticeHomeService.verifyAccountDetailsVisible();
    }

    // Shop Steps

    @And("^user clicks on \"Shop\"$")
    public void userClicksOnShop() {
        PracticeHomeService.clickShopMenu();
    }

    @And("^user selects (.*)$")
    public void userSelectsSorting(String sorting) {
        PracticeHomeService.selectSorting(sorting);
    }

    @Then("^user must see the top element (.*)$")
    public void userMustSeeTheTopElement(String expectedTitle) {
        PracticeHomeService.verifyTopElement(expectedTitle);
    }

    @When("^user clicks on \"Shop\" menu$")
    public void clickShopMenu() {
        PracticeHomeService.clickShopMenu();
    }

    @When("^user clicks on \"Add to basket\"$")
    public void clickAddToBasket() {
        PracticeHomeService.clickAddToBasket();
    }

    @Then("^the book should appear in cart with price$")
    public void verifyBookInCart() {
        PracticeHomeService.verifyBookInCart();
    }

    @When("^user clicks on \"View Basket\"$")
    public void clickViewBasket() {
        PracticeHomeService.clickViewBasket();
    }

    @Then("^verify subtotal is less than total$")
    public void verifySubtotalLessThanTotal() {
        PracticeHomeService.verifySubtotalLessThanTotal();
    }

    @When("^user clicks on \"Proceed to Checkout\"$")
    public void clickProceedToCheckout() {
        PracticeHomeService.clickProceedToCheckout();
    }

    @Then("user should see the billing details")
    public void verifyCheckoutDetails() {
        PracticeHomeService.verifyCheckoutDetails();
    }

    @When("^user fills billing details$")
    public void fillBillingDetails() {
        PracticeHomeService.fillBillingDetails();
    }

    @When("^user chooses \"Direct Bank Transfer\" as payment method$")
    public void chooseDirectBankTransfer() {
        PracticeHomeService.selectPaymentMethod();
    }

    @When("^user clicks on \"Place order\"$")
    public void clickPlaceOrder() {
        PracticeHomeService.clickPlaceOrder();
    }

    @Then("^order confirmation page should be displayed$")
    public void verifyOrderConfirmation() {
        PracticeHomeService.verifyOrderConfirmation();
    }

    @When("^user enters in the \"Billing Country\" field (.*)$")
    public void enterBillingCountry(String country) {
        PracticeHomeService.enterBillingCountry(country);
    }

    @Then("^the tax rate should be 2% for India or 5% for other country$")
    public void verifyTaxRate(String country) {
        PracticeHomeService.verifyTaxRate(country);
    }


}