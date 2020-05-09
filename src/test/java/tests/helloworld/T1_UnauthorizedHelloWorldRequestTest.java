package tests.helloworld;

import base.BaseApiTest;
import models.rest.response.HelloWorldResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.rest.account.HelloWorld;

import static enums.ResultCodes.UNAUTHORIZED;

public class T1_UnauthorizedHelloWorldRequestTest extends BaseApiTest {
    @Test(description = "Unauthorized hello world test")
    public void test() {
        var helloWorldService = new HelloWorld();
        var response = helloWorldService.getHelloWorld()
            .statusCode(401)
            .extract().as(HelloWorldResponse.class);
        Assert.assertEquals(response.getResultCode(), UNAUTHORIZED.getTextValue());
    }
}
