 package Test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features/Customers_NOP.feature", ".//Features/Login_NOP.feature"},
					glue = "Step_Defenitions", 
					dryRun = true,
					plugin = {"pretty", "html:test-output"}, 
					tags = "@sanity"
					)
public class NOP_Test_Runner {

}
