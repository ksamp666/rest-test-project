package tests.helloworld;

import base.BaseApiTest;
import models.product.Client;
import models.rest.response.HelloWorldResponse;
import org.testng.Assert;
import org.testng.annotations.*;
import services.DataGenerator;
import services.rest.account.HelloWorld;
import services.rest.external.Authorization;
import services.rest.external.Clients;

import static enums.ResultCodes.OK;
import static enums.ResultCodes.UNAUTHORIZED;
import static services.rest.Headers.SESSION_ID_HEADER;

public class T2_AuthorizedHelloWorldRequestTest extends BaseApiTest {
    private HelloWorld helloWorldService = new HelloWorld();
    private Authorization authorizationService = new Authorization();
    private Clients clientsService = new Clients();

    private Client client = DataGenerator.generateClient();
    private final String EXPECTED_HELLO_WORLD_MESSAGE = "Hello, " + client.getFullName() + "!";

    @BeforeClass
    public void beforeClass() {
        clientsService.createClient(client).statusCode(200);
    }

    @BeforeMethod
    public void beforeMethod() {
        String sessionId = authorizationService.login(client.getUsername())
            .statusCode(200)
            .extract()
            .header(SESSION_ID_HEADER);
        helloWorldService.setSessionId(sessionId);
    }

    @AfterMethod
    public void afterMethod() {
        authorizationService.logout(client.getUsername())
            .statusCode(200);
    }

    @Test(description = "Positive response for authorized user")
    public void positiveResponseTest() {
        var response = helloWorldService.getHelloWorld()
            .statusCode(200)
            .extract().as(HelloWorldResponse.class);
        Assert.assertEquals(response.getResultCode(), OK.getTextValue());
        Assert.assertEquals(response.getMessage(), EXPECTED_HELLO_WORLD_MESSAGE);
    }

    @Test(description = "Access hello world after logout")
    public void accessHelloWorldAfterLogoutTest() {
        authorizationService.logout(client.getUsername()).statusCode(200);
        var response = helloWorldService.getHelloWorld()
            .statusCode(401)
            .extract().as(HelloWorldResponse.class);
        Assert.assertEquals(response.getResultCode(), UNAUTHORIZED.getTextValue());
    }

    @Test(description = "Access hello world after logout")
    public void accessHelloWorldAfterSecondLoginTest() {
        authorizationService.login(client.getUsername()).statusCode(200);
        var response = helloWorldService.getHelloWorld()
            .statusCode(401)
            .extract().as(HelloWorldResponse.class);
        Assert.assertEquals(response.getResultCode(), UNAUTHORIZED.getTextValue());
    }
}
