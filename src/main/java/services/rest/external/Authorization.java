package services.rest.external;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.rest.request.LoginRequest;

import static io.restassured.RestAssured.given;

public class Authorization {
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_URL = "/logout";

    public ValidatableResponse login(String username) {
        var loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        return given()
            .contentType(ContentType.JSON)
            .body(loginRequest)
            .when()
            .post(LOGIN_URL)
            .then();
    }

    public ValidatableResponse logout(String username) {
        var loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        return given()
            .contentType(ContentType.JSON)
            .body(loginRequest)
            .when()
            .post(LOGOUT_URL)
            .then();
    }
}
