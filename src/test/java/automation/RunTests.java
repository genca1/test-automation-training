package automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/main/resources/features",
        glue = { "automation.glue" }
)
public class RunTests {

    public void tests(){}
}
