package tests.clients;

import base.BaseApiTest;
import models.product.Client;
import models.rest.response.ClientsListResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.DataGenerator;
import services.rest.external.Clients;

public class T3_CreateClientRequestTest extends BaseApiTest {
    private Clients clientsService = new Clients();

    private Client client = DataGenerator.generateClient();

    @Test(description = "Create client request")
    public void positiveResponseTest() {
        clientsService.createClient(client).statusCode(200);
        Assert.assertTrue(
            clientsService.getClients()
                .statusCode(200)
                .extract()
                .as(ClientsListResponse.class)
                .getClients()
                .stream()
                .anyMatch(clientName -> clientName.equals(client.getUsername()))
        );
    }
}
