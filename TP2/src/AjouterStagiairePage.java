import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AjouterStagiairePage {
    private final WebDriver driver;

    public AjouterStagiairePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ajouterStagiaire(String lastName, String firstName, String address, String date, String countryCode,
                                 String birthCity, String companyId, String email, String phone, String lastNameAr,
                                 String firstNameAr, String birthCityAr) {
        Select civility = new Select(driver.findElement(By.id("civility")));
        civility.selectByValue("Mme");
        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        lastnameElement.sendKeys(lastName);
        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        firstnameElement.sendKeys(firstName);
        WebElement addressElement = driver.findElement(By.id("address"));
        addressElement.sendKeys(address);
        WebElement dateElement = driver.findElement(By.id("txtDate"));
        dateElement.sendKeys(date);
        Select countryCodeSelect = new Select(driver.findElement(By.id("birthCountry.countryCode")));
        countryCodeSelect.selectByValue(countryCode);
        WebElement birthCityElement = driver.findElement(By.id("birthCity"));
        birthCityElement.sendKeys(birthCity);
        Select company = new Select(driver.findElement(By.id("idCompany")));
        company.selectByValue(companyId);
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);
        WebElement phoneElement = driver.findElement(By.id("phone"));
        phoneElement.sendKeys(phone);
        WebElement lastnameArElement = driver.findElement(By.id("lastNameAr"));
        lastnameArElement.sendKeys(lastNameAr);
        WebElement firstnameArElement = driver.findElement(By.id("firstNameAr"));
        firstnameArElement.sendKeys(firstNameAr);
        WebElement birthCityArElement = driver.findElement(By.id("birthCityAr"));
        birthCityArElement.sendKeys(birthCityAr);
        WebElement val = driver.findElement(By.tagName("button"));
        val.click();
    }
}
