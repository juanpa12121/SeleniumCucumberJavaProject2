package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage extends BasePage{

    private String googleSearchButton = "//body/div/div/form[contains(@role,'search')]/div[contains(@jsmodel,'vWNDde')]/div[contains(@jscontroller,'cnjECf')]/div/center/input[1]";

    public GooglePage() {
        super((ChromeDriver) driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(googleSearchButton);
    }
}
