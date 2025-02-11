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

        // Obtener el token de la API
        String token = ApiHelper.loginAndGetToken("TestUser", "Password!1");

        // Validar que el token no sea nulo y tiene un formato esperado (Ejemplo de validación)
        Assert.assertNotNull(token, "El token no debe ser nulo");
        Assert.assertTrue(token.startsWith("Bearer "), "El token debería comenzar con 'Bearer '");

        // Validar que el nombre de usuario esté correctamente mostrado en la UI
        Assert.assertEquals(homePage.userNameLogged(), "TestUser");
        
   
    }
}

