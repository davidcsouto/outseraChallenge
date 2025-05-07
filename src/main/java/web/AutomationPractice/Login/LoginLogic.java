package web.AutomationPractice.Login;

import lombok.extern.java.Log;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static support.Context.webSupport;

@Log
public class LoginLogic {

    private Map<String, String> dadosLogin;

    public String step;

    public LoginPage loginPage;

    public LoginLogic() {
        loginPage = new LoginPage();

        dadosLogin = new HashMap<>(){{
            put("email", "avaliacaoutsera@gmail.com");
            put("password", "avaliacaooutsera");
        }};
    }

    public void logoff(){
        step = "Usuário logado identificado, realizando logoff";
        log.info(step);

        webSupport().registerScreenshotAllureReport(step);
        if(webSupport().elementIsVisible(loginPage.getLinkSignOut())){
            webSupport().click(loginPage.getLinkSignOut());
        }
    }

    public void navigateToHome(){
        step = "Navegando para a HomePage do marketPlace do AutomationPractice";
        log.info(step);
        webSupport().navigateToUrl("http://www.automationpractice.pl/index.php");
        logoff();
        webSupport().waitElementToBeClickable(loginPage.getLinkSignIn());
        Assert.assertEquals(webSupport().getPageTitle(), "My Shop");
        webSupport().registerScreenshotAllureReport(step);
    }

    public void clickSignIn(){
        step = "Clicando no link para navegar para a tela de Login";
        log.info(step);
        webSupport().click(loginPage.getLinkSignIn());
        webSupport().waitElementToBeVisible(loginPage.getFieldLoginEmail());
        Assert.assertEquals(webSupport().getPageTitle(), "Login - My Shop");
        webSupport().registerScreenshotAllureReport(step);
    }

    public void fillLoginFieldsAndSubmitForm(){
        step = "Preenchendo campos de login e senha";
        log.info(step);

        webSupport().insertKeys(loginPage.getFieldLoginEmail(), dadosLogin.get("email"));
        webSupport().insertKeys(loginPage.getFieldLoginPassword(), dadosLogin.get("password"));
        webSupport().registerScreenshotAllureReport(step);
        webSupport().click(loginPage.getButtonSignIn());
        webSupport().waitElementToBeVisible(loginPage.getListLinksMyAccount());
    }

    public void assertPageMyAccount(){
        step = "Validar que estou na página de gerenciamento da conta";
        log.info(step);

        Assert.assertTrue(webSupport().elementIsVisible(loginPage.getListLinksMyAccount()));
        Assert.assertEquals(webSupport().getPageTitle(), "My account - My Shop");
        Assert.assertTrue(loginPage.getH1().getText().equalsIgnoreCase("My account"));

        webSupport().registerScreenshotAllureReport(step);
    }

    public void loginFlow(){
        navigateToHome();
        clickSignIn();
        fillLoginFieldsAndSubmitForm();
        assertPageMyAccount();
    }
}
