package steps;

import io.cucumber.java.en.*;
import pages.SandBoxPage;

public class SandboxSteps {

    SandBoxPage sandbox = new SandBoxPage();

    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandBoxSite(){
        sandbox.navigateToSandBox();
    }

    //ByValue
    @And("^Select a value from the dropdown$")
    public void selectValueFromTheDropdown(){
        sandbox.selectFromDropdownValue("4");
    }

/*    //By Index (posicion)
    @And("^Select a value from the dropdown$")
    public void selectValueFromTheDropdown(){
        sandbox.selectFromDropdownIndex(1);
    }*/

/*    //By Text (Texto visible que aparece en el option del select)
    @And("^Select a value from the dropdown$")
    public void selectValueFromTheDropdown(){
        sandbox.selectFromDropdownText("5-9");
    }*/
}
