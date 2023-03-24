package airnz.gen2.devicefarmpoc.autotests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        //This specifies the type and location of the desired reports.

        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        //This is the location of the Features folder
        features = {"src/test/java/airnz/gen2/devicefarmpoc/autotests/features/"},
        //This is the location of the StepDefs folder
        glue = {"airnz.gen2.devicefarmpoc.autotests.stepdefs"},
        publish = true,
        tags = "@level1")

@RunWith(Cucumber.class)

public class TestRunner {
}
