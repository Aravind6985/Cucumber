package Test_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//Aravind Raj//eclipse-workspace//Cucumber_Selenium1//Features//OrangeHRM.feature", glue = "Step_Defenitions")

public class OrangeHRM_Test_Runner {

}
