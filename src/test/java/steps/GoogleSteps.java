package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.GooglePage;

// Clase para definir que haran cada step que definimos en el feature
public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle(); //Abrir instancia de GooglePage que navegara a google
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        google.enterSearchCriteria("Colombia");
    }

    @And("^Click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^The results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Colombia - Wikipedia, la enciclopedia libre", google.firstResult());
        //google.validate("Colombia - Wikipedia, la enciclopedia libre");
    }

}