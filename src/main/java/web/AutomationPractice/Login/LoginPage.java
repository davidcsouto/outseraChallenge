package web.AutomationPractice.Login;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.Context.driver;

@Getter
public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(driver(), this);
    }

    @FindBy(css = "a[class=logout][title='Log me out']")
    private WebElement linkSignOut;

    @FindBy(css = "head title")
    private WebElement titlePage;

    @FindBy(css = "div.header_user_info a.login")
    private WebElement linkSignIn;

    @FindBy(css = "input#email")
    private WebElement fieldLoginEmail;

    @FindBy(css = "input#passwd")
    private WebElement fieldLoginPassword;

    @FindBy(css = "button#SubmitLogin")
    private WebElement buttonSignIn;

    @FindBy(css = "ul.myaccount-link-list")
    private WebElement listLinksMyAccount;

    @FindBy(css = "h1.page-heading")
    private WebElement h1;

}
