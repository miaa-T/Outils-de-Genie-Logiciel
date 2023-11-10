import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPage extends PageObject {
    @FindBy(id="username") WebElement usernameField;
    @FindBy(id="password") WebElement passwordField;
    @FindBy(name="Envoyer") WebElement envoyerButt;
    @FindBy(name="lastName") WebElement LastName;
    @FindBy(tagName="h4") WebElement H4;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        envoyerButt.click();
    }
   public WebElement verifyLogin1(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
       return wait.until(ExpectedConditions.visibilityOf(LastName));

   }
    public WebElement verifyLogin2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOf(H4));

    }

}

   /* WebElement results =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastName")));
    assertEquals(results.getTagName(), "input");*/
