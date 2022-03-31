package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", //Indicar donde estan los features
        glue = "steps", //Donde estan las definiciones de los steps
        tags = "@Test"
)

public class runner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}