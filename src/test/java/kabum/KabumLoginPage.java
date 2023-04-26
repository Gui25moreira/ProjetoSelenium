package kabum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class KabumLoginPage extends BasicPage{
    WebElement element;
    int statusCode;
    public KabumLoginPage(WebDriver driver) throws IOException {
        super(driver);
        driver.get("https://www.kabum.com.br/login");
        String pageUrl = driver.getCurrentUrl();
        URL url = new URL(pageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        statusCode = connection.getResponseCode();
    }

    public WebElement getEmail() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div/div[1]/div/div/input"));
    }

    public WebElement getPassword() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div/div[2]/div/div/input"));
    }

    public WebElement getButtonLogin() {
        return getPage().findElement(By.xpath("/html/body/div[1]/main/div/div[1]/form/div/button"));
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public void enterEmail(String email){
        getEmail().sendKeys(email);
    }

    public void enterPassword(String pwd){
        getPassword().sendKeys(pwd);
        getButtonLogin().click();
    }
    public int getStatusCode() {
        return statusCode;
    }
}
