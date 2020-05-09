package base;

import configuration.properties.Props;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {
    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = Props.getApiUrl();
    }
}
