package practice.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import practice.helpers.ApiHelper;
import practice.pages.HomePage;
import practice.pages.LoginPage;

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
}

