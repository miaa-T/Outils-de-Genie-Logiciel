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
        loginPage.login("nabil", "test");
    }


    @Test
    public void testAuthentication() {

        WebElement results=loginPage.verifyLogin1();
        assertEquals(results.getTagName(), "input");
    }


    @Test
    public void testAjouterStagiaire() {
        ajouterStagiairePage = new AjouterStagiairePage(driver);
        WebElement ajouter = driver.findElement(By.linkText("Nouveau Stagiaire"));
        ajouter.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Stagiaire stag= new Stagiaire("Nom","Prenom" , "addressss", "2002-12-04", "DZA", "cityy",
                "1", "mail@gmail.com", "+213012304560789", "ااا", "ااا", "مممم");
        ajouterStagiairePage.ajouterStagiaire(stag);
        WebElement results= ajouterStagiairePage.verify1();
        assertEquals(results.getTagName(), "a");
    }

}
