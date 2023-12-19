package io.petstore.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase extends PageManager {

    @BeforeAll
    static void beforeAll() {
        RestAssured.filters(new AllureRestAssured());
    }
}
