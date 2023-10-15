package contactlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesPage {

    private WebDriver driver;

    public MessagesPage(WebDriver driver) {
        super();
        this.driver=driver;
    }

    public String getLoginMessage(){
        WebElement loginMessage = this.driver.findElement(By.xpath("//h1[normalize-space()='Contact List']"));
        return loginMessage.getText();
    }

    public String getLogoutMessage(){
        WebElement logoutMessage = this.driver.findElement(By.xpath("//h1[normalize-space()='Contact List App']"));
        return logoutMessage.getText();
    }

    public String getLoginErrorMessage(){
        WebElement loginErrorMessage = this.driver.findElement(By.xpath("//span[@id='error']"));
        return loginErrorMessage.getText();
    }
}