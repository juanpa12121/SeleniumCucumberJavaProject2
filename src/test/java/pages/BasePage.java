package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    //Static para que haya una sola instancia de webdriver compartida para todas las clases
    //protected solo se puede llamar dentro de la clase
    protected static WebDriver driver;
    //private static webDriverWait wait;

    //Bloque estatico donde se crea el driver 1 sola vez para todas las demas instancias
    static{
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_98.0.4758.102\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        //Se crea una espera(Wait) ya que al usar este objeto tendra espera de 10 seg
        //Ya que si pasan los 10 seg y no encontró nada tirará EXCEPCION;
        //wait = new webDriverWait(driver, 10);
    }
    //Constructor
    public BasePage(ChromeDriver driver){
        BasePage.driver = driver;
        //wait = new webDriverWait(driver,10);
    }
    //Funcion de navegar
    public static void navigateTo(String url){
        driver.get(url);
    }
}
