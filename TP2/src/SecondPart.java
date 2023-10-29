import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SecondPart {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static AjouterStagiairePage ajouterStagiairePage;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
        driver.get("http://51.83.167.193:8080/.");
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Modifier")));
        assertEquals(results.getClass(), "btn btn-primary");
        ajouterStagiairePage = new AjouterStagiairePage(driver);

        // Login before all tests
        loginPage.login("nabil", "test");
    }


    @Test
    public void testAuthentication() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastName")));
        assertEquals(results.getTagName(), "input");
    }

    @Test
    public void testAjouterStagiaire() {
        ajouterStagiairePage.ajouterStagiaire("LMMM", "FFF", "addressss", "2002-12-04", "DZA", "cityy",
                "1", "mail@gmail.com", "+213012304560789", "ااا", "ااا", "مممم");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Modifier")));
        assertEquals(results.getClass(), "btn btn-primary");
    }

}
