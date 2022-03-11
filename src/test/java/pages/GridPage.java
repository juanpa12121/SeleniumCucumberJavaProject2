package pages;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridPage extends BasePage {

    private String cell = "//*[@id='root']/div/";
    private String mainTable = "//div[@id='root']//div//table"; //xpath de la tabla general

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

    //Funcion para verificar si la tabla está ahí
    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}