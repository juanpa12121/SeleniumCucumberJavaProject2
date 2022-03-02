package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //Static para que haya una sola instancia de webdriver compartida para todas las clases
    //protected solo se puede llamar dentro de la clase
    protected static WebDriver driver;
    private static WebDriverWait wait;

    //Bloque estatico donde se crea el driver 1 sola vez para todas las demas instancias
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_98.0.4758.102\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        //Se crea una espera(Wait) ya que al usar este objeto tendra espera de 10 seg
        //Ya que si pasan los 10 seg y no encontró nada tirará EXCEPCION;
        wait = new WebDriverWait(driver, 10); //Recibe driver y los segundos de espera
    }

    //Constructor
    public BasePage(ChromeDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Funcion de navegar
    public static void navigateTo(String url) {
        driver.get(url);
    }

    //Private: Solo se usará en esta clase
    //Manera única del profesor (instanciar una sola vez)
    //Metodo que devolverá un webelement
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    //Dado un elemento, darle click
    public void clickElement(String locator){
        Find(locator).click(); //click() la provee WebElement
    }

    //Funcion para escribir en campos de texto
    public void write(String locator, String textToWrite){
        Find(locator).clear(); //Limpiar campo de texto
        Find(locator).sendKeys(textToWrite); //Enviar algo, en este caso texto
    }

    //Funcion para dropdowns. (Izq: WebElement para encontrarlo, Der: Valor a seleccionar del dropdown)
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByValue(valueToSelect);
    }

    //Funcion para dropdowns por Index (el valor debe ser entero)
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByIndex(valueToSelect);
    }

    //Funcion para dropdowns por Texto
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByVisibleText(valueToSelect);
    }

}
