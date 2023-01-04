package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources",
                 glue = {"producttestcases", "categorytestcases"})
public final class SuitRunner extends AbstractTestNGCucumberTests{

}
