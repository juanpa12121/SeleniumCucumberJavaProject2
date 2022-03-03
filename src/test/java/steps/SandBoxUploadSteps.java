package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.SandBoxUploadPage;

public class SandBoxUploadSteps {

    SandBoxUploadPage sandboxUpload = new SandBoxUploadPage();

    @Given("^I navigate to the sandbox upload page$")
    public void navigateToTheSandBoxUploadSite(){
        sandboxUpload.navigateToSandboxUpload();
    }

    //ByValue
    @And("^I upload a document$")
    public void uploadDocument(){
        sandboxUpload.uploadF();
    }

}
