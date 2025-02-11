package practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(tagName = "title")  
    private WebElement pageTitle;

    @FindBy(id = "userName-value")
    private WebElement userNameLogged;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getText(pageTitle);
    }

    public String userNameLogged() {
        return getText(userNameLogged);
    }

}

