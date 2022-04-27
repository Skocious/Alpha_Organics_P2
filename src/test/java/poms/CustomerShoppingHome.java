package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerShoppingHome {
    private WebDriver driver;
    //    private By item_id = By.name("item_id");
    public CustomerShoppingHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);;
    }
    @FindBy(id = "item-id-field")
    public WebElement ItemID;
    @FindBy(id = "addToCartButton")
    public WebElement AddToCart;
    @FindBy(id = "BuyItems")
    public WebElement Buy;
    @FindBy(id = "Logout")
    public WebElement Logout;


//    public void sendKeysToItemId(String input){
//        driver.findElement(item_id).sendkeys(input);
//
//    }


}