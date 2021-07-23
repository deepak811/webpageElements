package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:/selenium/WebPageElements/src/test/java/features/WebFeatures.feature",
		glue= {"stepdef"},
		plugin = {"pretty", "html:target/test-output.html"},
		tags= "@Smoketest11"
		)
public class Runner {

}
