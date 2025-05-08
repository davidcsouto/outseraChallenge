package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/Api",
        glue = "classpath:api",
        tags = "",
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class RunnerApi extends Runner {

}