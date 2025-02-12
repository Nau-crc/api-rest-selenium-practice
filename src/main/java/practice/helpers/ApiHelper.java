package practice.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {

    public static String loginAndGetToken(String username, String password) {
        Response response = RestAssured
            .given()
            .baseUri("https://demoqa.com")
            .contentType("application/json")
            .body("{\"userName\": \"" + username + "\", \"password\": \"" + password + "\"}")
            .post("/Account/v1/Login");
            System.out.println("Código de respuesta: " + response.getStatusCode());
            
            String token = response.jsonPath().getString("token");
            if (token == null) {
                throw new RuntimeException("No se pudo obtener el token. Respuesta: " + response.getStatusCode());
            }
        return token;
    }

    public static int loginAndGetStatusCode(String username, String password) {
        Response response = RestAssured
            .given()
            .baseUri("https://demoqa.com")
            .contentType("application/json")
            .body("{\"userName\": \"" + username + "\", \"password\": \"" + password + "\"}")
            .post("/Account/v1/Login");
            System.out.println("Código de respuesta: " + response.getStatusCode());
        return response.getStatusCode();
    }
}

