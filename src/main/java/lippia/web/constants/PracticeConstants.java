package lippia.web.constants;

public class PracticeConstants {

    // For Registration
    public static final String MY_ACCOUNT_MENU_XPATH = "xpath://*[@id=\"menu-item-50\"]/a";
    public static final String EMAIL_REG_INPUT_XPATH = "xpath://*[@id=\"reg_email\"]";
    public static final String PASSWORD_REG_INPUT_XPATH = "xpath://*[@id=\"reg_password\"]";
    public static final String REGISTER_BUTTON_XPATH = "xpath://input[@name='register']";
    public static final String REGISTRATION_SUCCESS_XPATH = "xpath://div[contains(@class,'woocommerce-MyAccount-content')]//p[contains(text(),'Hello')]";
    public static final String ERROR_MESSAGE_XPATH = "xpath://ul[@class='woocommerce-error']/li";
    public static final String EMPTY_EMAIL_ERROR = "Error: Please provide a valid email address.";
    public static final String EMPTY_PASSWORD_ERROR = "Error: Please enter an account password.";

    // For Login
    public static final String LOGIN_USERNAME_INPUT_XPATH = "xpath://input[@id='username']";
    public static final String PASSWORD_LOG_INPUT_XPATH = "xpath://*[@id=\"password\"]";
    public static final String LOGIN_BUTTON_XPATH = "xpath://input[@name='login']";
    public static final String LOGIN_SUCCESS_XPATH = "xpath://div[contains(@class,'woocommerce-MyAccount-content')]//p[contains(text(),'Hello')]";
    public static final String LOGIN_ERROR_XPATH = "xpath://ul[@class='woocommerce-error']/li";
    public static final String LOGOUT_LINK_XPATH = "xpath://a[contains(text(),'Logout')]";
    public static final String LOGIN_FORM_XPATH = "xpath://*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]";
    public static final String ACCOUNT_DETAILS_XPATH = "xpath://a[contains(text(),'Account Details')]";
    public static final String NEW_PASSWORD_XPATH = "xpath://input[@id='password_1']";

    // For Shop
    public static final String SHOP_MENU_XPATH = "xpath://a[contains(text(),'Shop')]";
    public static final String SORT_DROPDOWN_XPATH = "xpath://select[@name='orderby']";
    public static final String PRODUCT_GRID_XPATH = "xpath://ul[@class='products masonry-done']/li";
    public static final String PRODUCT_TITLE_XPATH = "xpath:.//h3";

    // For Shop → Sorting
    public static final String SORT_POPULARITY_VALUE = "popularity";
    public static final String SORT_AVG_RATING_VALUE = "rating";
    public static final String SORT_NEWNESS_VALUE = "date";
    public static final String SORT_PRICE_LOW_TO_HIGH_VALUE = "price";

    public static final String BILLING_FIRST_NAME_ID = "id:billing_first_name";
    public static final String BILLING_LAST_NAME_ID = "id:billing_last_name";
    public static final String BILLING_PHONE_ID = "id:billing_phone";
    public static final String BILLING_EMAIL_ID = "id:billing_email";
    public static final String BILLING_COUNTRY_DROPDOWN_ID = "id:s2id_billing_country";
    public static final String BILLING_COUNTRY_INPUT_ID = "id:s2id_autogen1_search";
    public static final String COUNTRY_OPTION_FIRST_XPATH = "xpath://*[@id=\"select2-results-1\"]/li[1]";
    public static final String COUNTRY_OPTION_SECOND_XPATH = "xpath://*[@id=\"select2-results-1\"]/li[2]";
    public static final String BILLING_ADDRESS_ID = "id:billing_address_1";
    public static final String BILLING_CITY_ID = "id:billing_city";
    public static final String BILLING_STATE_DROPDOWN_ID = "id:s2id_billing_state";
    public static final String BILLING_STATE_INPUT_ID = "id:s2id_autogen2_search";
    public static final String STATE_OPTION_FIRST_XPATH = "xpath://*[@id=\"select2-results-2\"]/li[1]";
    public static final String BILLING_POSTCODE_ID = "id:billing_postcode";

    public static final String PAYMENT_METHOD_XPATH = "id:payment_method_bacs";

    public static final String PLACE_ORDER_BUTTON_ID = "id:place_order";
    public static final String ORDER_DETAILS_XPATH = "xpath://*[@id=\"page-35\"]/div/div[1]/p[1]";

    public static final String ITEM_PRICE_XPATH = "xpath://*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span";
    public static final String TAX_AMOUNT_XPATH = "xpath://*[@id=\"order_review\"]/table/tfoot/tr[2]/td/span";

    public static final String PRODUCT_XPATH = "xpath://a[text()='Thinking in HTML']";
    public static final String ADD_BASKET_BUTTON_XPATH = "xpath://*[@id=\"product-163\"]/div[2]/form/button";
    public static final String CART_ITEM_BUTTON = "xpath://a[@class='cart-contents']";
    public static final String VIEW_BASKET_BUTTON_XPATH = "xpath://a[text()='View Basket']";
    public static final String CHECKOUT_BUTTON_XPATH = "xpath://a[text()='Proceed to Checkout']";
    public static final String CHECKOUT_FORM_ID = "id:customer_details";
    public static final String ITEM_PRICE_CART_XPATH = "xpath://td[@class='product-price']/span";
    public static final String SUBTOTAL_XPATH = "xpath://tr[@class='cart-subtotal']//span";
    public static final String TOTAL_XPATH = "xpath://tr[@class='order-total']//span";
}


