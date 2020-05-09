package services;

import models.product.Client;

import java.util.Random;

public class DataGenerator {
    public static Client generateClient() {
        var client = new Client();
        client.setUsername(generateUserName());
        client.setFullName("Test Client " + generateRandomNumber(1000, 9999));
        return client;
    }

    public static String generateUserName() {
        return "user_" + System.currentTimeMillis() + generateRandomNumber(1000, 9999);
    }

    public static int generateRandomNumber(int start, int end) {
        var rand = new Random();
        return start + rand.nextInt(end - start + 1);
    }
}
