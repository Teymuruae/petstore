package io.petstore.tests;

import io.petstore.helpers.DataGenerator;
import io.petstore.pojo.requests.CreateUserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogInOutUserTest extends TestBase {

    private String
            userName = DataGenerator.getRandomUserName(),

    password = "123",

    firstName = DataGenerator.getRandomFirstName(),

    lastName = DataGenerator.getRandomLastName(),

    email = DataGenerator.getRandomEmail(),

    phone = DataGenerator.getRandomPhoneNumber();

    private int
            userStatus = 0,
            id = DataGenerator.getRandomId();

    private CreateUserRequest
            body = new CreateUserRequest(id, userName, firstName, lastName, email, password, phone, userStatus);

    @BeforeEach
    void setUp() {
        post.createUser(body);
    }

    @DisplayName("Тест login logout пользователя")
    @Test
    void logInOutUserTest() {
        get.loginUserWithAssert(body.getUsername(), body.getPassword());
        get.logoutUserWithAssert();
    }

    @AfterEach
    void clear() {
        delete.deleteUser(body.getUsername());
    }
}