package web.AutomationPractice.Checkout;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import web.AutomationPractice.Login.LoginLogic;

public class CheckoutSteps {

    public CheckoutLogic checkoutLogic;
    public LoginLogic loginLogic;

    public CheckoutSteps() {
        checkoutLogic = new CheckoutLogic();
        loginLogic = new LoginLogic();
    }

    @Dado("que estou logado no marketplace do AutomationPractice")
    public void que_estou_logado_no_marketplace_do_automation_practice() {
        loginLogic.loginFlow();
    }
    @Dado("na barra de pesquisa preencho com {string} e clico no ícone de lupa para pesquisar")
    public void na_barra_de_pesquisa_preencho_com_e_clico_no_ícone_de_lupa_para_pesquisar(String searchTerm) {
        checkoutLogic.fillSearchField(searchTerm);
    }
    @Dado("seleciono um produto clicando no botão More")
    public void seleciono_um_produto_clicando_no_botão_more() {
        checkoutLogic.selectingProductAndClickingOnMore();
    }

    @Dado("na tela do produto, seleciono um opção de tamanho e cor que tenha estoque disponível e clico em Add to Cart")
    public void naTelaDoProdutoSelecionoUmOpçãoDeTamanhoECorQueTenhaEstoqueDisponívelEClicoEmAddToCart() {
        checkoutLogic.selectColorWithStock();
    }

    @Dado("clicar no botão Proceed to Checkout")
    public void clicar_no_botão_proceed_to_checkout() {
        checkoutLogic.clickButtonProceedToCheckout();
    }
    @Dado("na tela de Summary clicar em Proceed to Checkout")
    public void na_tela_de_summary_clicar_em_proceed_to_checkout() {
        checkoutLogic.step1Page();
    }

    @Dado("selecionar ou cadastrar um endereço de entrega e avançar")
    public void selecionarOuCadastrarUmEndereçoDeEntregaEAvançar() {
        checkoutLogic.verifyRegisterOrSelectAddress();
    }

    @Dado("confirmar a opção de envio e concordar com os termos e avançar")
    public void confirmar_a_opção_de_envio_e_concordar_com_os_termos_e_avançar() {
        checkoutLogic.step4SelectShipping();
    }

    @Dado("na tela de pagamento, selecionar selecionar a opção Pay by bank wire")
    public void na_tela_de_pagamento_selecionar_selecionar_a_opção_pay_by_bank_wire() {
        checkoutLogic.step5SelectPaymentMethod();
    }
    @Quando("clicar no botão I confirm my order")
    public void clicar_no_botão_i_confirm_my_order() {
        checkoutLogic.step5OrderSummary();
    }
    @Entao("devo ver a tela de confirmação de pedido informando a mensagem {string}")
    public void devo_ver_a_tela_de_confirmação_de_pedido_informando_a_mensagem(String messageSuccess) {
        checkoutLogic.validateOrderSuccessAndMessage(messageSuccess);
    }



}
