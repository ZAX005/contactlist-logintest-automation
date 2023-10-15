package contactlist;

import java.time.Duration;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
        this.driver=driver;
    }

    //POLJE ZA PRIJAVU- EMAIL
    //Nesiguran nacin za getter nad input poljem je pristup direktnim putem preko findElement metode (ovde nema cekanja).
    //Siguran nacin: cekamo da element bude vidljiv i enable-ovan pre nego sto ga pronadjemo selektorom.
    public WebElement getEmailInputField() {
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    //Pisanje setera za input polje
    public void setEmailInputField (String value) {
        WebElement emailInputPolje = this.getEmailInputField();
        emailInputPolje.clear();
        emailInputPolje.sendKeys(value);
    }

    //POLJE ZA PRIJAVU- LOZINKA
    public WebElement getPassword() {
        WebElement el= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        return el;
    }
    //Standardan nacin pisanja setera za input polje
    public void setPassword(String value) {
        WebElement lozinka=this.getPassword();
        lozinka.clear();
        lozinka.sendKeys(value);
    }

    //SUBMIT
    //Metoda pronalazi dugme Submit i vrsi klik na njega
    public void submit() {
        this.driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    //LOGOUT
    //Metoda pronalazi dugme Logout i vrsi klik na njega
    public void logout() {
        this.driver.findElement(By.xpath("//button[@id='logout']")).click();
    }

}