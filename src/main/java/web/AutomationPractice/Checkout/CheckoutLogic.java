package web.AutomationPractice.Checkout;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import web.AutomationPractice.Login.LoginPage;

import java.util.List;

import static support.Context.webSupport;

@Log
public class CheckoutLogic {

    private LoginPage loginPage;
    private CheckoutPage checkoutPage;

    private String step;

    public CheckoutLogic() {
        loginPage = new LoginPage();
        checkoutPage = new CheckoutPage();
    }

    public void fillSearchField(String searchTerm){
        step = "Realizando busca de produto";
        log.info(step);

        webSupport().insertKeys(checkoutPage.getSearchField(), searchTerm);
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getSubmitSearch());

        webSupport().waitElementToBeVisible(checkoutPage.getProductList());
        webSupport().registerScreenshotAllureReport("Resultado da busca");
    }

    public void selectingProductAndClickingOnMore(){
        step = "Selecionando o produto e clicando no botão More";
        log.info(step);

        webSupport().hoverElement(checkoutPage.getFirstProduct());
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getButtonMore());
        webSupport().waitElementToBeClickable(checkoutPage.getPriceDisplay());
        webSupport().registerScreenshotAllureReport("Informações e preço do produto");
    }

    public void selectColorWithStock(){
        step = "Buscando cor do produto com estoque";
        log.info(step);

        List<WebElement> elements = checkoutPage.getColorOptions().findElements(By.tagName("li"));
        for(WebElement element : elements){
            webSupport().click(element);
            if(webSupport().elementIsVisible(checkoutPage.getButtonAddToCart())){
                webSupport().registerScreenshotAllureReport(step);
                webSupport().click(checkoutPage.getButtonAddToCart());
                break;
            }
        }
    }

    public void clickButtonProceedToCheckout(){
        step = "Clicando no botão Proceed To Checkout";
        log.info(step);

        webSupport().waitElementToBeClickable(checkoutPage.getButtonProceedToCheckout());
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getButtonProceedToCheckout());
    }

    public void step1Page(){
        step = "Tela de Resumo do Carrinho";
        log.info(step);

        webSupport().waitElementToBeVisible(checkoutPage.getStepTitle());
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getProceedToCheckoutCartNavigation());
    }

    public void verifyRegisterOrSelectAddress(){
        step = "Verificando se já existe um endereço de entrega cadastrado";
        log.info(step);

        if(webSupport().elementIsVisible(checkoutPage.getBoxAddressDelivery())){
            step = "Endereço de entrega existente, avançando para próxima etapa";
            log.info(step);
            webSupport().registerScreenshotAllureReport(step);
        } else {
            fillAddressData();
            step = "Endereço de entrega cadastrado";
            log.info(step);
            webSupport().registerScreenshotAllureReport(step);
        }
        webSupport().click(checkoutPage.getButtonProceedToCheckoutAddressDeliveryPage());
    }

    public void fillAddressData(){
        step = "Preenchendo dados de endereço";
        log.info(step);

        webSupport().waitElementToBeVisible(checkoutPage.getAddressField1());
        webSupport().insertKeys(checkoutPage.getAddressField1(), "W 48th St");
        webSupport().insertKeys(checkoutPage.getAddressField2(), "150");
        webSupport().insertKeys(checkoutPage.getCityField(), "New York");
        webSupport().selectOptionInSelectElement(checkoutPage.getSelectState(), "New York");
        webSupport().insertKeys(checkoutPage.getZipcodeField(), "10017");
        webSupport().insertKeys(checkoutPage.getHomePhoneField(), "1156748432");
        webSupport().insertKeys(checkoutPage.getMobilePhoneField(), "11956748432");
        checkoutPage.getNameAddress().clear();
        webSupport().insertKeys(checkoutPage.getNameAddress(), "Home");
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getButtonSave());
    }

    public void step4SelectShipping(){
//        webSupport().waitElementToBeVisible(checkoutPage.getRadioTypeShipping());

        step = "Selecionando forma de envio e concordando com termos e serviços";
        log.info(step);
        webSupport().elementIsVisible(checkoutPage.getButtonProceedToCheckoutShippingPage());
        webSupport().executeScript(checkoutPage.getCheckboxTermsOfService(), "arguments[0].click()");
        webSupport().registerScreenshotAllureReport(step);

        webSupport().click(checkoutPage.getButtonProceedToCheckoutShippingPage());
    }

    public void step5SelectPaymentMethod(){
        webSupport().waitElementToBeClickable(checkoutPage.getOptionPaymentBankWire());

        step = "Selecionando a opção de pagamento de transferência bancária";
        log.info(step);

        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getOptionPaymentBankWire());
    }

    public void step5OrderSummary(){
        webSupport().waitElementToBeClickable(checkoutPage.getButtonConfirmOrder());

        step = "Confirmando pedido";
        log.info(step);

        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(checkoutPage.getButtonConfirmOrder());
    }

    public void validateOrderSuccessAndMessage(String messageSuccess){
        webSupport().waitElementToBeVisible(checkoutPage.getAlertOrderSuccess());

        step = "Pedido realizado com sucesso";
        log.info(step);

        Assert.assertEquals(checkoutPage.getAlertOrderSuccess().getText(), messageSuccess);
        webSupport().registerScreenshotAllureReport(step);
    }
}
