package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.PracticeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class PracticeHomeService {

    public static void navigateWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    // Registration Steps

    public static void clickMyAccountMenu() {
        WebActionManager.click(PracticeConstants.MY_ACCOUNT_MENU_XPATH);
    }

    public static void enterEmail(String email) {
        WebActionManager.setInput(PracticeConstants.EMAIL_REG_INPUT_XPATH, email);
    }

    public static void enterRegPassword(String password) {
        WebActionManager.setInput(PracticeConstants.PASSWORD_REG_INPUT_XPATH, password);
    }

    public static void enterLogPassword(String password) {
        WebActionManager.setInput(PracticeConstants.PASSWORD_LOG_INPUT_XPATH, password);
    }

    public static void clickRegisterButton() {
        WebActionManager.click(PracticeConstants.REGISTER_BUTTON_XPATH);
    }

    public static void verifySuccessfulRegistration() {
        WebActionManager.waitVisibility(PracticeConstants.REGISTRATION_SUCCESS_XPATH);
        WebElement successElement = WebActionManager.getElement(PracticeConstants.REGISTRATION_SUCCESS_XPATH);
        Assert.assertTrue(successElement.isDisplayed(), "Registration was not successful");
    }

    public static void verifyNavigationToHomePage() {
        WebDriver driver = DriverManager.getDriverInstance();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practice.automationtesting.in"), "Not on home page");
    }

    public static void verifyFailedRegistration() {
        WebActionManager.waitVisibility(PracticeConstants.ERROR_MESSAGE_XPATH);
        List<WebElement> errorElements = WebActionManager.getElements(PracticeConstants.ERROR_MESSAGE_XPATH);
        if (errorElements.isEmpty()) {
            Assert.fail("No se mostraron mensajes de error durante el registro fallido");
        }
    }

    public static void verifyEmptyEmailError() {
        WebActionManager.waitVisibility(PracticeConstants.ERROR_MESSAGE_XPATH);
        String errorText = WebActionManager.getText(PracticeConstants.ERROR_MESSAGE_XPATH);
        Assert.assertTrue(errorText.contains(PracticeConstants.EMPTY_EMAIL_ERROR),
                "El mensaje de error no coincide con el esperado para email vacío");
    }

    public static void verifyEmptyPasswordError() {
        WebActionManager.waitVisibility(PracticeConstants.ERROR_MESSAGE_XPATH);
        String errorText = WebActionManager.getText(PracticeConstants.ERROR_MESSAGE_XPATH);
        Assert.assertTrue(errorText.contains(PracticeConstants.EMPTY_PASSWORD_ERROR),
                "El mensaje de error no coincide con el esperado para contraseña vacía");
    }

    // Login Steps

    public static void enterUsername(String username) {
        WebActionManager.setInput(PracticeConstants.LOGIN_USERNAME_INPUT_XPATH, username);
    }

    public static void clickLoginButton() {
        WebActionManager.click(PracticeConstants.LOGIN_BUTTON_XPATH);
    }

    public static void verifySuccessfulLogin() {
        WebActionManager.waitVisibility(PracticeConstants.LOGIN_SUCCESS_XPATH);
        WebElement successElement = WebActionManager.getElement(PracticeConstants.LOGIN_SUCCESS_XPATH);
        Assert.assertTrue(successElement.isDisplayed(), "Login was not successful");
    }

    public static void verifyFailedLogin(String expectedError) {
        WebActionManager.waitVisibility(PracticeConstants.LOGIN_ERROR_XPATH);
        WebElement errorElement = WebActionManager.getElement(PracticeConstants.LOGIN_ERROR_XPATH);
        Assert.assertEquals(errorElement.getText(), expectedError, "Error message does not match");
    }

    public static void clickLogoutLink() {
        WebActionManager.waitClickable(PracticeConstants.LOGOUT_LINK_XPATH);
        WebActionManager.click(PracticeConstants.LOGOUT_LINK_XPATH);
    }

    public static void navigateBack() {
        WebActionManager.navigateTo(PropertyManager.getProperty("web.base.url") + "/my-account");
    }

    public static void verifyLoginPageVisible() {
        WebActionManager.waitVisibility(PracticeConstants.LOGIN_FORM_XPATH);
    }

    public static void clickAccountDetails() {
        WebActionManager.waitClickable(PracticeConstants.ACCOUNT_DETAILS_XPATH);
        WebActionManager.click(PracticeConstants.ACCOUNT_DETAILS_XPATH);
    }

    public static void verifyAccountDetailsVisible() {
        WebActionManager.waitVisibility(PracticeConstants.NEW_PASSWORD_XPATH);
    }

    // Shop Steps

    public static void clickShopMenu() {
        WebActionManager.click(PracticeConstants.SHOP_MENU_XPATH);
    }

    public static void selectSorting(String sorting) {
        String sortValue = "";
        switch (sorting.toLowerCase()) {
            case "popularity":
                sortValue = PracticeConstants.SORT_POPULARITY_VALUE;
                break;
            case "average rating":
                sortValue = PracticeConstants.SORT_AVG_RATING_VALUE;
                break;
            case "newness":
                sortValue = PracticeConstants.SORT_NEWNESS_VALUE;
                break;
            case "price: low to high":
                sortValue = PracticeConstants.SORT_PRICE_LOW_TO_HIGH_VALUE;
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting option: " + sorting);
        }
        WebActionManager.setDropdownByValue(PracticeConstants.SORT_DROPDOWN_XPATH, sortValue);
        WebActionManager.waitVisibility(PracticeConstants.PRODUCT_GRID_XPATH);
        // Por las dudas agregué un tiempo de espera para que se carguen los elementos
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void verifyTopElement(String expectedTitle) {
        // Acá obtengo todos los productos
        List<WebElement> products = WebActionManager.getElements(PracticeConstants.PRODUCT_GRID_XPATH);
        Assert.assertFalse(products.isEmpty(), "No products found in the grid");

        // Acá me traigo el título del primer producto
        WebElement firstProduct = products.get(0);
        WebElement titleElement = firstProduct.findElement(
                By.xpath(PracticeConstants.PRODUCT_TITLE_XPATH.replace("xpath:", "")));

        String actualTitle = titleElement.getText();

        // Hago un log para verificar las pruebas en consola
        System.out.println("=== VERIFICACIÓN DE SORTING ===");
        System.out.println("Valor esperado (Gherkin): '" + expectedTitle + "'");
        System.out.println("Valor encontrado (página): '" + actualTitle + "'");
        System.out.println("Coinciden? " + actualTitle.equals(expectedTitle));

        Assert.assertEquals(actualTitle, expectedTitle,
                String.format("El primer producto debería ser '%s' pero es '%s'",
                        expectedTitle, actualTitle));
    }

    public static void selectProduct() {
        click(PracticeConstants.PRODUCT_XPATH);
    }

    public static void clickAddToBasket() {
        selectProduct();
        click(PracticeConstants.ADD_BASKET_BUTTON_XPATH);
    }

    public static void verifyBookInCart() {
        WebElement cartItem = WebActionManager.getElement(PracticeConstants.CART_ITEM_BUTTON);
        Assert.assertTrue(cartItem.isDisplayed(), "Cart icon not displayed");
        WebElement price = WebActionManager.getElement(PracticeConstants.ITEM_PRICE_CART_XPATH);
        Assert.assertTrue(price.isDisplayed(), "Price not displayed in cart menu");
    }

    public static void clickViewBasket() {
        click(PracticeConstants.VIEW_BASKET_BUTTON_XPATH);
    }

    public static void verifySubtotalLessThanTotal() {
        WebElement subtotal = WebActionManager.getElement(PracticeConstants.SUBTOTAL_XPATH);
        WebElement total = WebActionManager.getElement(PracticeConstants.TOTAL_XPATH);
        double subtotalValue = Double.parseDouble(subtotal.getText().replace("₹", ""));
        double totalValue = Double.parseDouble(total.getText().replace("₹", ""));
        Assert.assertTrue(subtotalValue < totalValue,
                "Subtotal (" + subtotalValue + ") should be less than total (" + totalValue + ")");
    }

    public static void clickProceedToCheckout() {
        click(PracticeConstants.CHECKOUT_BUTTON_XPATH);
    }

    public static void verifyCheckoutDetails() {
        WebElement checkoutForm = WebActionManager.getElement(PracticeConstants.CHECKOUT_FORM_ID);
        Assert.assertTrue(checkoutForm.isDisplayed(), "Checkout form not displayed");
    }

    public static void fillBillingDetails() {
        setInput(PracticeConstants.BILLING_FIRST_NAME_ID, "Franco");
        setInput(PracticeConstants.BILLING_LAST_NAME_ID, "Asplanatti");
        setInput(PracticeConstants.BILLING_PHONE_ID, "123456879");
        setInput(PracticeConstants.BILLING_EMAIL_ID, "francoasplanatti@gmail.com");
        click(PracticeConstants.BILLING_COUNTRY_DROPDOWN_ID);
        setInput(PracticeConstants.BILLING_COUNTRY_INPUT_ID, "Argentina");
        click(PracticeConstants.COUNTRY_OPTION_FIRST_XPATH);
        setInput(PracticeConstants.BILLING_ADDRESS_ID, "Belgrano 1234");
        setInput(PracticeConstants.BILLING_CITY_ID, "Concordia");
        click(PracticeConstants.BILLING_STATE_DROPDOWN_ID);
        setInput(PracticeConstants.BILLING_STATE_INPUT_ID, "ER");
        click(PracticeConstants.STATE_OPTION_FIRST_XPATH);
        setInput(PracticeConstants.BILLING_POSTCODE_ID, "3200");
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectPaymentMethod() {
        waitClickable(PracticeConstants.PAYMENT_METHOD_XPATH);
    }

    public static void clickPlaceOrder() {
        click(PracticeConstants.PLACE_ORDER_BUTTON_ID);
    }

    public static void verifyOrderConfirmation() {
        WebElement orderDetails = WebActionManager.getElement(PracticeConstants.ORDER_DETAILS_XPATH);
        Assert.assertTrue(orderDetails.isDisplayed(), "Order confirmation details are not visible");
    }

    public static void enterBillingCountry(String pais){
        click(PracticeConstants.BILLING_COUNTRY_DROPDOWN_ID);
        setInput(PracticeConstants.BILLING_COUNTRY_INPUT_ID, pais);
        if (Objects.equals(pais, "India")){
            click(PracticeConstants.COUNTRY_OPTION_SECOND_XPATH);
        } else if (Objects.equals(pais, "Argentina")) {
            click(PracticeConstants.COUNTRY_OPTION_FIRST_XPATH);
        }
    }

    public static void verifyTaxRate(String country) {
        if ("India".equals(country)) {
            verifyIndiaTaxRate();
        } else {
            verifyInternationalTaxRate();
        }
    }

    private static void verifyIndiaTaxRate() {
        float expectedTax = calculateExpectedTax(0.02f);
        float actualTax = getActualTaxValue();

        Assert.assertEquals(expectedTax, actualTax, 0.01,
                "Tax rate in India should be 2%");
    }

    private static void verifyInternationalTaxRate() {
        float expectedTax = calculateExpectedTax(0.05f);
        float actualTax = getActualTaxValue();

        Assert.assertEquals(expectedTax, actualTax, 0.01,
                "International tax rate should be 5%");
    }

    private static float calculateExpectedTax(float rate) {
        WebElement priceElement = WebActionManager.getElement(PracticeConstants.ITEM_PRICE_XPATH);
        String priceText = priceElement.getText().replace("₹", "");
        return Float.parseFloat(priceText) * rate;
    }

    private static float getActualTaxValue() {
        WebElement taxElement = WebActionManager.getElement(PracticeConstants.TAX_AMOUNT_XPATH);
        String taxText = taxElement.getText().replace("₹", "");
        return Float.parseFloat(taxText);
    }

    private static void click(String locator) {
        WebActionManager.waitClickable(locator);
        WebActionManager.click(locator);
    }

    private static void setInput(String locator, String value) {
        WebActionManager.setInput(locator, value);
    }

    private static void waitClickable(String locator) {
        WebActionManager.waitClickable(locator);
    }
}
