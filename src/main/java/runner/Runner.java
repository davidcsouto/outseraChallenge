package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import support.Context;
import support.Utils;

import java.io.File;

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforeClassMethod(){
        Utils.deleteFolder(new File(Utils.getRootPath() + "\\allure-results"));
        Context.setup();
    }

    @AfterTest
    public static void afterClassMethod(){
        Context.closeWebDriver();
    }

}
