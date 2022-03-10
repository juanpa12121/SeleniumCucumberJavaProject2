package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class GuruPage extends BasePage{

    public GuruPage() {
        super((ChromeDriver) driver);
    }

    public void navigateToGuruSite(){
        navigateTo("https://demo.guru99.com/test/simple_context_menu.html");
    }

    public void rightClickGuruButton(){
        rightClick("//span[@class='context-menu-one btn btn-neutral']");
        clickElement("//div[@id='context-menu-layer']"); //Click espacio en blanco
    }
    public void doubleClickGuruButton(){
        doubleClick("//button[normalize-space()='Double-Click Me To See Alert']");
    }
}
