package kabum;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage{
    private WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitulo(){
        return driver.getTitle();
    }

    public WebDriver getPage(){
        return driver;
    }
}
