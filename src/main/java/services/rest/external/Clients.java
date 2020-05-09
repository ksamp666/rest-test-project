package services.rest.external;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.product.Client;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Clients {
    private static final String CLIENTS_URL = "/clients";

    public ValidatableResponse getClients() {
        return when()
            .get(CLIENTS_URL)
            .then();
    }

    public ValidatableResponse createClient(Client client) {
        return
            given()
                .contentType(ContentType.JSON)
                .body(client)
                .when()
                .post(CLIENTS_URL)
                .then();
    }
}
