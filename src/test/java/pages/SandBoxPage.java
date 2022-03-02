package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class SandBoxPage extends BasePage {

    private String locatorDropdown = "//select[@id='select-menu']";

    public SandBoxPage() {
        super((ChromeDriver) driver);
    }

    public void navigateToSandBox(){
        navigateTo("https://formy-project.herokuapp.com/form");
    }

    public void selectFromDropdownValue(String category){
        selectFromDropdownByValue(locatorDropdown, category);
    }

    public void selectFromDropdownIndex(int category){
        selectFromDropdownByIndex(locatorDropdown, category);
    }

    public void selectFromDropdownText(String category){
        selectFromDropdownByText(locatorDropdown, category);
    }
}
