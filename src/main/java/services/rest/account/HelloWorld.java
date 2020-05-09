package services.rest.account;

import io.restassured.response.ValidatableResponse;

public class HelloWorld extends BaseAccount {
    private static final String HELLO_WORLD_URL = "/hello";

    public ValidatableResponse getHelloWorld() {
        return getRequestSpecification()
            .get(HELLO_WORLD_URL)
            .then();
    }
}
