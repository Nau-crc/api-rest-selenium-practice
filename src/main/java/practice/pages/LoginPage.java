package practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")  
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(loginButton);
    }

    public String errorMessage() {
        return getText(error);
    }
    
}
