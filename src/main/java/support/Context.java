package support;

import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

public class Context {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final ThreadLocal<PageSupport> webSupport = new ThreadLocal<>();
    private static final ThreadLocal<RequestSpecification> rest = new ThreadLocal<>();

    public static void setup(){
        DriverManager.setupClass();
        DriverManager.setupDriver();
        RestManager.setupRest();
        webDriver.set(DriverManager.driver);
        webSupport.set(new PageSupport(webDriver.get()));
        rest.set((RequestSpecification) RestManager.getRest());
    }

    public static WebDriver driver(){
        return webDriver.get();
    }

    public static PageSupport webSupport(){
        return webSupport.get();
    }

    public static RequestSpecification rest(){
        return rest.get();
    }

    public static void closeWebDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
