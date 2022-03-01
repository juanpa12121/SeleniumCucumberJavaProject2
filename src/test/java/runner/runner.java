package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", //Indicar donde estan los features
        glue = "steps" //Donde estan las definiciones de los steps
)

public class runner {
}