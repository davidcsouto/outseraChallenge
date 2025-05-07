package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:web",
        tags = "@AutomationPractice",
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class RunnerWeb extends Runner{
}
