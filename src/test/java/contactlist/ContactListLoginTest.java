package contactlist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class ContactListLoginTest {

    //Kreiranje Selenium WebDriver-a (u ovom slucaju ChromeDriver).
    WebDriver driver = new ChromeDriver();

    //Kreiranje Selenium WebDriver-a (u ovom slucaju FirefoxDriver).
    //private WebDriver driver;

    private LoginPage loginPage;
    private MessagesPage messagesPage;

    @BeforeSuite
    public void initalize() {


        //Kreiranje Selenium WebDriver instance
        //FirefoxDriver driver= new FirefoxDriver();

        //Konfiguracija browser-a
        //1. maximize browser window
        //driver.manage().window().maximize();
        //2. wait 5 seconds for loading the page before Exception
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //3. wait 1 second before very action
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Putanja do trazene web strane
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/");

        //inicijalizacija novih stranica
        loginPage = new LoginPage(driver);
        messagesPage = new MessagesPage(driver);

    }

    //LOG IN
    @Test
    public void prijavljivanje() {

        loginPage.setEmailInputField("usethiscontacts@gmail.com");
        loginPage.setPassword("Blaster1985+");

        loginPage.submit();

        assertTrue(messagesPage.getLoginMessage().contains("Contact List"));
    }


    //USPESNO PRIJAVLJIVANJE POMOCU DATA PROVIDER-A
    @Test(dataProvider="successful", dataProviderClass=DataProviderPage.class)
    public void loginTestSuccessful(String username, String password) {

        loginPage.setEmailInputField(username);
        loginPage.setPassword(password);
        loginPage.submit();
        assertTrue(messagesPage.getLoginMessage().contains("Contact List"));
        loginPage.logout();
        assertTrue(messagesPage.getLogoutMessage().contains("Contact List App"));
    }

    //NEUSPESNO PRIJAVLJIVANJE POMOCU DATA PROVIDER-a
    @Test(dataProvider="failed", dataProviderClass=DataProviderPage.class)
    public void loginTestFailed(String username, String password) {

        loginPage.setEmailInputField(username);
        loginPage.setPassword(password);
        loginPage.submit();
        assertTrue(messagesPage.getLogoutMessage().contains("App"));
        //VIDETI
        //assertTrue(messagesPage.getLoginErrorMessage().contains("Incorrect username or password"));

    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }

}