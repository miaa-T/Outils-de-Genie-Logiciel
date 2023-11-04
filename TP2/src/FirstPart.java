import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstPart {

    private static WebDriver driver;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
        driver.get("http://51.83.167.193:8080/.");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("nabil");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("test");
        WebElement connexion = driver.findElement(By.name("Envoyer"));
        connexion.click();
    }

    @Test
    public void testAuthentication() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastName")));
        assertEquals(results.getTagName(), "input");
    }

    @Test
    public void testtAjouterStagiaire() {

        WebElement ajouter = driver.findElement(By.linkText("Nouveau Stagiaire"));
        ajouter.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select civility = new Select(driver.findElement(By.id("civility")));
        civility.selectByValue("Mme");
        WebElement lastname = driver.findElement(By.id("lastName"));
        lastname.sendKeys("NAMMMME");
        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("FFF");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("addressss");
        WebElement date = driver.findElement(By.id("txtDate"));
        date.sendKeys("2002-12-04");
        Select CC = new Select(driver.findElement(By.id("birthCountry.countryCode")));
        CC.selectByValue("DZA");
        WebElement birthCity = driver.findElement(By.id("birthCity"));
        birthCity.sendKeys("cityy");
        Select Company = new Select(driver.findElement(By.id("idCompany")));
        Company.selectByValue("1");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mail@gmail.com");
        WebElement Tel = driver.findElement(By.id("phone"));
        Tel.sendKeys("+213012304560789");
        WebElement lastnamear = driver.findElement(By.id("lastNameAr"));
        lastnamear.sendKeys("ااا");
        WebElement firstnamear = driver.findElement(By.id("firstNameAr"));
        firstnamear.sendKeys("ااا");
        WebElement birthCityAr = driver.findElement(By.id("birthCityAr"));
        birthCityAr.sendKeys("مممم");
        WebElement val = driver.findElement(By.tagName("button"));
        val.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Modifier")));
        assertEquals(results.getTagName(), "a");


    }

    @Test
    public void testRecherche() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement firstnameRe = driver.findElement(By.name("firstName"));
        firstnameRe.sendKeys("FFF");
        WebElement recherche = driver.findElement(By.tagName("button"));
        recherche.click();

        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        assertTrue(rows.size() > 2); // avoir au moins 2 result
        for (WebElement row : rows) { // tous les prenoms = 'FFF'
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() >= 3) {
                WebElement prenomColumn = columns.get(2);
                String prenomValue = prenomColumn.getText();
                assertEquals(prenomValue, "FFF");
            }
        }

    }
}
