package web.AutomationPractice.Login;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

    private LoginLogic loginLogic;

    public LoginSteps() {
        loginLogic = new LoginLogic();
    }

    @Dado("que acesso a página principal do AutomationPractice")
    public void que_acesso_a_página_principal_do_automation_practice() {
        loginLogic.navigateToHome();
    }

    @Dado("clicar em Sign in")
    public void clicar_em_sign_in() {
        loginLogic.clickSignIn();
    }
    @Quando("na formulário de login preencher os campos de email address e password e clicar no botão Sign in")
    public void na_formulário_de_login_preencher_os_campos_de_email_address_e_password_e_clicar_no_botão_sign_in() {
        loginLogic.fillLoginFieldsAndSubmitForm();
    }
    @Entao("devo ser direcionado para a página My Account")
    public void devo_ser_direcionado_para_a_página_my_account() {
        loginLogic.assertPageMyAccount();
    }

}
