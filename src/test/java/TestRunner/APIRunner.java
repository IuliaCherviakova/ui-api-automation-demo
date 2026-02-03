package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"APIStepDefinitions"},
        tags = "@apijsonworkflow",
        dryRun = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report/Cucumber.html",
                "json:target/cucumber-report/Cucumber.json",
                "rerun:target/failed.txt"
        }
)
public class APIRunner {


}
