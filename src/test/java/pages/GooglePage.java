package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage extends BasePage{


    public GooglePage() {
        super((ChromeDriver) driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
}
