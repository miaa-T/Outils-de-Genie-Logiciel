import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private WebDriver driver;
    @Given("User is on Login page")
    public void userIsOnLoginPage() {
            System.setProperty("webdriver.gecko.driver", "F:/OGL/TP3/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("http://51.83.167.193:8080/");
            System.out.println("User is on the Login page");
    }

    @When("User enters valid credentials the username {string} and the password {string}")
    public void userEntersValidCredentialsTheUsernameAndThePassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement connexionButton = driver.findElement(By.name("Envoyer"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        connexionButton.click();
    }

    @Then("The main page is displayed")
    public void theMainPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastName")));
        assertEquals(results.getTagName(), "input");
    }

    @When("User enters invalid credentials the username {string} and the password {string}")
    public void userEntersInvalidCredentialsTheUsernameAndThePassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement connexionButton = driver.findElement(By.name("Envoyer"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        connexionButton.click();
    }

    @Then("The Login screen should display {string}")
    public void theLoginScreenShouldDisplay(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4")));
        assertEquals(results.getText(), arg0);
    }
}
