package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import support.Context;
import support.Utils;

import java.io.File;

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeClassMethod(){
        Utils.deleteFolder(new File(Utils.getRootPath() + "\\allure-results"));
        Context.setup();
    }

    @AfterSuite
    public static void afterClassMethod(){
        Context.closeWebDriver();
    }

}
