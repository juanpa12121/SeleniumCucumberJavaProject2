package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.GuruPage;

public class GuruSteps {

    GuruPage guru = new GuruPage();

    @Given("^I navigate to Guru99 Demo Site$")
    public void navigateToGoogle(){
        guru.navigateToGuruSite();
    }

    @And("^I do right click on button$")
    public void clickRightClickButton(){
        guru.rightClickGuruButton();
    }

    @And("^I do double click on button$")
    public void doubleClickButton(){
        guru.doubleClickGuruButton();
    }
}
