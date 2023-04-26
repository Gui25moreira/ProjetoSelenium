package kabum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class KabumSearchPage extends BasicPage {
    int statusCode;
    public KabumSearchPage (WebDriver driver) throws IOException {
       super(driver);
       driver.get("https://www.kabum.com.br");
        String pageUrl = driver.getCurrentUrl();
        URL url = new URL(pageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        statusCode = connection.getResponseCode();
   }
    public WebElement getSearch() {
        return getPage().findElement(By.id("input-busca"));
    }
    public String getStringPage() {
        return getPage().findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div")).getText();
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void search(String search) {
        enterSearch(search);
    }
    public void enterSearch(String search){
        getSearch().sendKeys(search);
        getSearch().submit();
    }
}
