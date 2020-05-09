package services.rest.account;

import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static services.rest.Headers.SESSION_ID_HEADER;

class BaseAccount {
    @Setter
    @Getter
    private String sessionId;

    protected RequestSpecification getRequestSpecification() {
        return Optional.ofNullable(sessionId)
            .map(sId -> given().header(SESSION_ID_HEADER, sId))
            .orElse(given());
    }
}
