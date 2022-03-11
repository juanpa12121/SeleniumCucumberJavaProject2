package steps;

import io.cucumber.java.en.*;
import pages.ListPage;

import java.util.List;

public class ListSteps {

    ListPage listPage = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToPage(){
        listPage.navigateToListPage();
    }

    @When("^I search the list$")
    public void searchList() throws InterruptedException {
        listPage.enterSearchCriteria();
    }

    @Then("^I can find the text in the list$")
    public void findTextInTheList(){
        List<String> lista = listPage.getAllSearchResults();
        boolean textIsThere = lista.contains("Seattle, Washington");

        if(textIsThere){
            System.out.println("The text is on the List. PASSED.");
        }else{
            throw new Error("The text isn't on the List. FAILED!");
        }
    }
}