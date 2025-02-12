package practice.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.auth0.jwt.JWT;

import practice.helpers.ApiHelper;
import practice.pages.HomePage;
import practice.pages.LoginPage;

import com.auth0.jwt.algorithms.Algorithm;
import org.openqa.selenium.Cookie;

public class LoginUITest extends BaseTest {

    @Test
    public void testLoginSuccess() {
        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("TestUser", "Password!1");

        String token = ApiHelper.loginAndGetToken("TestUser", "Password!1");

        Assert.assertNotNull(token, "El token no debe ser nulo");
        Assert.assertEquals(homePage.userNameLogged(), "TestUser");
        
    }

    @Test
    public void testLoginFail() {
        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("TestUser", "Password!2");
    
        Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
    }

    @Test
    public void testTokenExpired(){
        long expiredTime = System.currentTimeMillis() - 10 * 1000; 

        String expiredToken = JWT.create()
                .withClaim("exp", expiredTime / 1000)  
                .sign(Algorithm.HMAC256("fake-secret")); 

        System.out.println("Token Expirado: " + expiredToken);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");

        Cookie authCookie = new Cookie("token", expiredToken);
        driver.manage().addCookie(authCookie);

        driver.get("https://demoqa.com/profile");
        driver.quit();
    }


}

