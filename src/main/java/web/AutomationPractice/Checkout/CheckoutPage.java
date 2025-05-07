package web.AutomationPractice.Checkout;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

import static support.Context.driver;

@Getter
public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "input#search_query_top")
    private WebElement searchField;

    @FindBy(css = "button[name=submit_search]")
    private WebElement submitSearch;

    @FindBy(css = "ul.product_list")
    private WebElement productList;

    @FindBy(xpath = "(//div[@class='product-image-container'])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "(//span[contains(text(), 'More')]//..//..//a)[1]")
    private WebElement buttonMore;

    @FindBy(css = "p.our_price_display")
    private WebElement priceDisplay;

    @FindBy(css = "ul#color_to_pick_list")
    private WebElement colorOptions;

    @FindBy(css = "button[type=submit][class=exclusive]")
    private WebElement buttonAddToCart;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement buttonProceedToCheckout;

    @FindBy(css = "h1#cart_title")
    private WebElement stepTitle;

    @FindBy(css = "p.cart_navigation a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutCartNavigation;

    @FindBy(css = "ul#address_delivery")
    private WebElement boxAddressDelivery;

    @FindBy(css = "input#address1")
    private WebElement addressField1;

    @FindBy(css = "input#address2")
    private WebElement addressField2;

    @FindBy(css = "input#city")
    private WebElement cityField;

    @FindBy(css = "select#id_state")
    private WebElement selectState;

    @FindBy(css = "input#postcode")
    private WebElement zipcodeField;

    @FindBy(css = "input#phone")
    private WebElement homePhoneField;

    @FindBy(css = "input#phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(css = "input#alias")
    private WebElement nameAddress;

    @FindBy(css = "button#submitAddress")
    private WebElement buttonSave;

    @FindBy(css = "p.cart_navigation button[name='processAddress']")
    private WebElement buttonProceedToCheckoutAddressDeliveryPage;

    @FindBy(css = "form[name=carrier_area]")
    private WebElement formCarrierArea;

    @FindBy(css = "input[id*=delivery_option]")
    private WebElement radioTypeShipping;

    @FindBy(css = "p.checkbox input[type=checkbox]")
    private WebElement checkboxTermsOfService;

    @FindBy(css = "p.cart_navigation button[name='processCarrier']")
    private WebElement buttonProceedToCheckoutShippingPage;

    @FindBy(css = "p.payment_module a.bankwire")
    private WebElement optionPaymentBankWire;

    @FindBy(xpath = "//span[contains(text(), 'I confirm my order')]//..//..//button")
    private WebElement buttonConfirmOrder;

    @FindBy(css = "p.alert")
    private WebElement alertOrderSuccess;

}
