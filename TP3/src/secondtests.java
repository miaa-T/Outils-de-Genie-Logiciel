import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class secondtests {

    private static WebDriver driver;

    @Test
    public void testAuthentication() {
            WebDriver driver = new FirefoxDriver();
            driver.get("http://51.83.167.193:8080/.");
            WebElement username= driver.findElement(By.id("username"));
            username.sendKeys("aa");
            WebElement password= driver.findElement(By.id("password"));
            password.sendKeys("bb");
            WebElement connexion= driver.findElement(By.name("Envoyer"));
            connexion.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4")));
            assertEquals(results.getText(), "Les identifications sont erronées");
        }
        @Test
        public void testAjouterStag2(){
            WebDriver driver = new FirefoxDriver();
            driver.get("http://51.83.167.193:8080/.");
            WebElement username= driver.findElement(By.id("username"));
            username.sendKeys("nabil");
            WebElement password= driver.findElement(By.id("password"));
            password.sendKeys("test");
            WebElement connexion= driver.findElement(By.name("Envoyer"));
            connexion.click();
            WebElement btn1= driver.findElement(By.linkText("Nouveau Stagiaire"));
            btn1.click();
            Select civility = new Select (driver.findElement(By.id("civility")));
            civility.selectByValue("Mme");
            WebElement address= driver.findElement(By.id("address"));
            address.sendKeys("addressss");
            WebElement date= driver.findElement(By.id("txtDate"));
            date.sendKeys("2002-12-04");
            Select CC = new Select (driver.findElement(By.id("birthCountry.countryCode")));
            CC.selectByValue("DZA");
            WebElement birthCity= driver.findElement(By.id("birthCity"));
            birthCity.sendKeys("cityy");
            Select Company = new Select (driver.findElement(By.id("idCompany")));
            Company.selectByValue("1");
            WebElement email= driver.findElement(By.id("email"));
            email.sendKeys("mail@gmail.com");
            WebElement Tel= driver.findElement(By.id("phone"));
            Tel.sendKeys("+213012304560789");
            WebElement lastnamear= driver.findElement(By.id("lastNameAr"));
            lastnamear.sendKeys("ااا");
            WebElement firstnamear= driver.findElement(By.id("firstNameAr"));
            firstnamear.sendKeys("ااا");
            WebElement birthCityAr= driver.findElement(By.id("birthCityAr"));
            birthCityAr.sendKeys("مممم");
            WebElement val= driver.findElement(By.tagName("button"));
            val.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement resultsLastName =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lastName + span")));
            assertTrue(resultsLastName.isDisplayed());
            WebElement resultsFirstName =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName + span")));
            assertTrue(resultsFirstName.isDisplayed());
        }

    }

