package kabum;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class KabumPageTest {
    ChromeDriver chrome;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aylla\\Downloads\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chrome = new ChromeDriver(options);
    }

    @Test()
    public void testLogin() throws IOException {
        KabumLoginPage page = new KabumLoginPage(chrome);
        String email = "email@gmail.com";
        page.enterEmail(email);

        String senha = "123456";
        page.enterPassword(senha);
        Assert.assertEquals(403,page.getStatusCode());

    }

    @Test
    public void testSearch() throws IOException {
        KabumSearchPage page = new KabumSearchPage(chrome);
        String search = "nbbbbbb";
        page.enterSearch(search);
        String textElement = page.getStringPage();
        Assert.assertTrue(textElement.contains("Lamentamos, nenhum produto encontrado"));
    }

    @Test
    public void testAvancedSearch() throws IOException {
        KabumAdvancedSearchPage page = new KabumAdvancedSearchPage(chrome);
        String search = "notebook";
        page.enterSearch(search);
        page.getOrderBy();
        String textElement = page.getStringPage();
        Assert.assertTrue(textElement.contains("Notebook Gamer Acer Nitro 5"));
    }

}
