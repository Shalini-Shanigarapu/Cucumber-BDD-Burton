package com.learn.Runners;




//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/com/learn/Resources/Features",
        glue={"com/learn/StepDefinitions"},
        monochrome=true,
        dryRun = false,
        plugin = {"pretty"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

}

