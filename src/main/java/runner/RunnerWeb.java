package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/Web",
        glue = "classpath:web",
        tags = "",
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class RunnerWeb extends Runner{
}
