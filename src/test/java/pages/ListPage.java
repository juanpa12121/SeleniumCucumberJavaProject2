package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListPage extends BasePage {

    private String searchField = "//input[@placeholder='City or State']";
    private String byClassName = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria() throws InterruptedException {
        try {
            Thread.sleep(600); //
            write(searchField, "Washington");
        }catch (NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found");
            e.printStackTrace();
        }
    }

    //Funcion que retonará los webelements como strings
    public List<String> getAllSearchResults(){
        List<WebElement> list = bringAllElements(byClassName);
        List<String> stringsFromList = new ArrayList<String>();

        //Otra forma de recorrer la lista
/*        for (int i = 0; i < list.size(); i++) {
            stringsFromList.add(list.get(i).getText());
            System.out.println(list.get(i).getText());
        }*/
        //Mas sencillo
        for (WebElement item: list){
            stringsFromList.add(item.getText());
        }
        System.out.println(stringsFromList);
        return stringsFromList;
    }
}
