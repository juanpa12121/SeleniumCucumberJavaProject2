package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage extends BasePage{


    private String searchTextField = "//input[@title='Buscar']";
    private String googleSearchButton = "//input[@value='Buscar con Google']";//Este lo saque manualmente

    public GooglePage() {
        super((ChromeDriver) driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(googleSearchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

}
