import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AjouterStagiairePage extends PageObject  {
    @FindBy(id="lastName") WebElement lastnameElement;
    @FindBy(id="firstName") WebElement firstnameElement;
    @FindBy(id="address") WebElement addressElement;
    @FindBy(id="civility") WebElement civilityElement;
    @FindBy(id="txtDate") WebElement dateElement;
    @FindBy(id="birthCity") WebElement birthCityElement;
    @FindBy(id="email") WebElement emailElement;
    @FindBy(id="phone") WebElement phoneElement;
    @FindBy(id="lastNameAr") WebElement lastnameArElement;
    @FindBy(id="firstNameAr") WebElement firstnameArElement;
    @FindBy(id="birthCityAr") WebElement birthCityArElement;
    @FindBy(tagName="button") WebElement val;
    @FindBy(partialLinkText="Modifier") WebElement modif;


    public AjouterStagiairePage(WebDriver driver) {
        super(driver);
    }

    public void ajouterStagiaire(Stagiaire stagiaire) {
        Select civility = new Select(civilityElement);
        civility.selectByValue("Mme");
        lastnameElement.sendKeys(stagiaire.getLastName());
        firstnameElement.sendKeys(stagiaire.getFirstName());
        addressElement.sendKeys(stagiaire.getAddress());
        dateElement.sendKeys(stagiaire.getDate());
        Select countryCodeSelect = new Select(driver.findElement(By.id("birthCountry.countryCode")));
        countryCodeSelect.selectByValue(stagiaire.getCountryCode());
        birthCityElement.sendKeys(stagiaire.getBirthCity());
        Select company = new Select(driver.findElement(By.id("idCompany")));
        company.selectByValue(stagiaire.getCompanyId());
        emailElement.sendKeys(stagiaire.getEmail());
        phoneElement.sendKeys(stagiaire.getPhone());
        lastnameArElement.sendKeys(stagiaire.getLastName());
        firstnameArElement.sendKeys(stagiaire.getFirstNameAr());
        birthCityArElement.sendKeys(stagiaire.getBirthCityAr());
        val.click();
    }
    public WebElement verify1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.visibilityOf(modif));
    }
}
