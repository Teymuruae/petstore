package io.petstore.spec;

import io.petstore.helpers.configs.Configs;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

public class Spec {
    private static Configs configs = ConfigFactory.create(Configs.class, System.getProperties());
    private static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(configs.getBaseUrl())
                .build();
    }

    private static ResponseSpecification response(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void install(int statusCode) {
        RestAssured.requestSpecification = request();
        RestAssured.responseSpecification = response(statusCode);
    }
}