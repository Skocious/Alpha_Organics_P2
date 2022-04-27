package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginHome {
    private WebDriver driver;
    public CustomerLoginHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username-field")
    public WebElement LoginName;

    @FindBy(id = "password-field")
    public WebElement Password;
    @FindBy(id = "customerLoginButton")
    public WebElement CustomerLogin;




}
