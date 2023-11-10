import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class MyStepdefs2 {
    private WebDriver driver;
    @Given("User is on Home page")
    public void userIsOnHomePage() {
        System.setProperty("webdriver.gecko.driver", "F:/OGL/TP3/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://51.83.167.193:8080/");
        System.out.println("User is on the Login page");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement connexionButton = driver.findElement(By.name("Envoyer"));
        usernameField.sendKeys("nabil");
        passwordField.sendKeys("test");
        connexionButton.click();
    }

    @When("User clicks on {string}")
    public void userClicksOn(String arg0) {
        WebElement ajouter = driver.findElement(By.linkText(arg0));
        ajouter.click();
    }

    @And("User enters the stagiaire details")
    public void userEntersTheStagiaireDetails() {
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
    }

    @And("User submits the form")
    public void userSubmitsTheForm() {
        WebElement val = driver.findElement(By.tagName("button"));
        val.click();
    }

    @Then("User sees the {string} link indicating successful addition")
    public void userSeesTheLinkIndicatingSuccessfulAddition(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement results =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Modifier")));
        assertEquals(results.getTagName(), "a");
    }

    @And("User enters the stagiaire details except firstname and lastname")
    public void userEntersTheStagiaireDetailsExceptFirstnameAndLastname() {
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
    }

    @Then("User sees two error messages")
    public void userSeesTwoErrorMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement resultsLastName =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lastName + span")));
        assertTrue(resultsLastName.isDisplayed());
        WebElement resultsFirstName =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName + span")));
        assertTrue(resultsFirstName.isDisplayed());
    }
}
