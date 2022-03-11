package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage extends BasePage{

    private String searchTextField = "//input[@title='Buscar']";
    private String googleSearchButton = "//input[@value='Buscar con Google']";//Este lo saque manualmente
    private String firstResult = "//h3[normalize-space()='Colombia - Wikipedia, la enciclopedia libre']";

    public GooglePage() {
        super(driver);
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

    //Forma recomendada para Validar resultados (Con la validacion en los Steps)
    public String firstResult(){
        return textFromElement(firstResult);
    }

    //Segunda forma de hacerlo con metodo de validar de una vez en el BasePage
//    public void validate(String textToValidate){
//        validateText(firstResult, textToValidate );
//    }

}