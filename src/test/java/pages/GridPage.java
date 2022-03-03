package pages;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridPage extends BasePage {

    private String cell = "//*[@id='root']/div/";

    //Instancia de webdriver
    public GridPage() {
        super((ChromeDriver) driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }
}