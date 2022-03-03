package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class SandBoxUploadPage extends BasePage{

    //ToolsQA
    private String buttonUpload = "//input[@id='uploadPicture']";


    public SandBoxUploadPage() {
        super((ChromeDriver) driver);
    }

    public void navigateToSandboxUpload(){
        navigateTo("https://demoqa.com/automation-practice-form");
    }

    public void uploadF(){
        //fileVisibleById("uploadPicture");
        uploadFile(buttonUpload, "D:\\Prueba.txt");
    }
}
