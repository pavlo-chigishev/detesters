package tests.content;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features",glue={"src/test/java/tests/StepDefinition"},plugin = {"pretty"})
public class CucumberTest
{
    // do not code here anything,
    // all gonna be coded in the steps definitions
}
