package practice.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {

    public static String loginAndGetToken(String username, String password) {
        Response response = RestAssured
            .given()
            .baseUri("https://demoqa.com/api")
            .contentType("application/json")
            .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
            .post("/login");
        
        // Imprimir la respuesta para verificar el contenido
        System.out.println("Respuesta de la API: " + response.getBody().asString());

        // Recuperar el token de la respuesta JSON
        String token = response.jsonPath().getString("token");
        return token;
    }
}

