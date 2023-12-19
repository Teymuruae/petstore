package io.petstore.helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Random;

public class DataGenerator {

    private static Faker faker = new Faker();
    private static int time =  Integer.parseInt(new SimpleDateFormat("ddhhmmss").format(new java.util.Date()));

    public static String getRandomFirstName() {
        return faker.name().firstName() + faker.number().digits(3);
    }

    public static String getRandomLastName() {
        return faker.name().lastName() + faker.number().digits(3);
    }

    public static String getRandomUserName() {
        return faker.name().username() + faker.number().digits(3);
    }

    public static String getRandomEmail() {
        return getRandomFirstName() + getRandomLastName() + "@" + faker.internet().domainName();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static int getRandomId() {
        return new Random().nextInt(1000) + time;
    }
}