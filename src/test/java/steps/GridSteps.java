package steps;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GridPage;

public class GridSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() {
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3,2);
        System.out.println(value);

        Assert.assertEquals("r: 2, c: 1", value);
    }
}
