package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/featureFile/personalHomeLoad.feature"},
        format = {"pretty", "html:target/cucumber"},
        glue = {"src/test/java/stepDefinationFile/StepDefinition.java"},
        tags = "@krishna"
)
public class runnerFile {
}

