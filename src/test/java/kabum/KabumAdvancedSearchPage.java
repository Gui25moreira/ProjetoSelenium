package kabum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class KabumAdvancedSearchPage extends BasicPage {
    int statusCode;
    public KabumAdvancedSearchPage(WebDriver driver) throws IOException {
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
    public void getOrderBy() {
        WebElement comboboxElement = getPage().findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div[2]/div[1]/div[1]/div[1]/div[1]/select"));
        Select combobox = new Select(comboboxElement);
        combobox.selectByVisibleText("Mais procurados");
    }
    public String getStringPage() {
        return getPage().findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div[2]/div[1]/main/div[6]/a/div/button/div/h2/span")).getText();
    }
    public void search(String search) {
        enterSearch(search);
    }
    public void enterSearch(String search){
        getSearch().sendKeys(search);
        getSearch().submit();
    }
}
