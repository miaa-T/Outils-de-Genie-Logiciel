import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SecTestPart2 {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static AjouterStagiairePage ajouterStagiairePage;

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
        driver.get("http://51.83.167.193:8080/.");
        loginPage = new LoginPage(driver);

    }


    @Test
    public void testAuthentication2() {
        loginPage.login("aa", "bb");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results=loginPage.verifyLogin2();
        assertEquals(results.getText(), "Les identifications sont erronées");
    }



    @Test
    public void testAjouterStagiaire2() {
        loginPage.login("nabil", "test");
        ajouterStagiairePage = new AjouterStagiairePage(driver);
        WebElement ajouter = driver.findElement(By.linkText("Nouveau Stagiaire"));
        ajouter.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Stagiaire stag= new Stagiaire("","" , "addressss", "2002-12-04", "DZA", "cityy",
                "1", "mail@gmail.com", "+213012304560789", "ااا", "ااا", "مممم");
        ajouterStagiairePage.ajouterStagiaire(stag);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("span")));
        assertTrue(results.isDisplayed());
    }
}
