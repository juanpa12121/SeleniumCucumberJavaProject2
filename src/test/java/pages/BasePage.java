package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BasePage {
    //Static para que haya una sola instancia de webdriver compartida para todas las clases
    //protected solo se puede llamar dentro de la clase
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    //Bloque estatico donde se crea el driver 1 sola vez para todas las demas instancias
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        //Se crea una espera(Wait) ya que al usar este objeto tendra espera de 10 seg
        //Ya que si pasan los 10 seg y no encontró nada tirará EXCEPCION;
        wait = new WebDriverWait(driver, 10); //Recibe driver y los segundos de espera
    }

    //Constructor
    public BasePage(ChromeDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        //Espera implícita, espera para TODO, NO RECOMENDABLE
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    //Metodo para escribir en campos de texto
    public void write(String locator, String textToWrite){
        Find(locator).clear(); //Limpiar campo de texto
        Find(locator).sendKeys(textToWrite); //Enviar algo, en este caso texto
    }

    //Metodo para dropdowns. (Izq: WebElement para encontrarlo, Der: Valor a seleccionar del dropdown)
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByValue(valueToSelect);
    }

    //Metodo para dropdowns por Index (el valor debe ser entero)
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByIndex(valueToSelect);
    }

    //Metodo para dropdowns por Texto
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator)); //Ya tenemos el dropdown
        dropdown.selectByVisibleText(valueToSelect);
    }

    //Metodo HoverOver (Pasar mouse por encima de un elemento)
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    //Metodo doble click
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    //Metodo click derecho
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //Función para devolver el valor de una celda de una tabla
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator + "/table/tbody/tr["+row+"]/td["+column+"]"; //locator es el xpath general de la tabla
        return Find(cellINeed).getText(); //Devolver texto que tenga ese webelement
    }

    //Metodo para setear valor de una celda (no de vuelve nada porque estamos seteando)
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator + "/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    //Metodo para subida de archivos a la web
    public void uploadFile(String locator, String path){
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        Find(locator).sendKeys(absolutePath);
        System.out.println(absolutePath);
    }

    //Cuando el input tiene un id pero su style no es visible.
    public void fileVisibleById(String idElement){
        String changeVisibility = "document.getElementById('"+idElement+"').style.visibility = 'visible';";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(changeVisibility);
    }

    //Método para escuchar un iFrame
    public void switchToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //Método para rechazar una alerta
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //Método para validar texto
    public void validateText(String locator, String textToValidate){
        Assert.assertEquals(textToValidate, Find(locator).getText());
    }

    //Función para devolver texto de webelement
    public String textFromElement(String locator){
        return Find(locator).getText();
    }


}