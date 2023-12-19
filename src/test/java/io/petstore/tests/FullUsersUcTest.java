package io.petstore.tests;

import io.petstore.helpers.DataGenerator;
import io.petstore.pojo.requests.CreateUserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class FullUsersUcTest extends TestBase {

    private String
            userName = DataGenerator.getRandomUserName(),
            userName2 = DataGenerator.getRandomUserName(),
            userName3 = DataGenerator.getRandomUserName(),
            password = "123",
            password2 = "153",
            password3 = "763",
            firstName = DataGenerator.getRandomFirstName(),
            firstName2 = DataGenerator.getRandomFirstName(),
            firstName3 = DataGenerator.getRandomFirstName(),
            lastName = DataGenerator.getRandomLastName(),
            lastName2 = DataGenerator.getRandomLastName(),
            lastName3 = DataGenerator.getRandomLastName(),
            email = DataGenerator.getRandomEmail(),
            email2 = DataGenerator.getRandomEmail(),
            email3 = DataGenerator.getRandomEmail(),
            phone = DataGenerator.getRandomPhoneNumber(),
            phone2 = DataGenerator.getRandomPhoneNumber(),
            phone3 = DataGenerator.getRandomPhoneNumber();

    private int
            userStatus = 0,
            userStatus2 = 1,
            userStatus3 = 2,
            id = DataGenerator.getRandomId(),
            id2 = DataGenerator.getRandomId(),
            id3 = DataGenerator.getRandomId();

    private CreateUserRequest
            body = new CreateUserRequest(id, userName, firstName, lastName, email, password, phone, userStatus),
            body2 = new CreateUserRequest(id2, userName2, firstName2, lastName2, email2, password2, phone2, userStatus2),
            body3 = new CreateUserRequest(id3, userName3, firstName3, lastName3, email3, password3, phone3, userStatus3);
    private List<CreateUserRequest> bodies = Arrays.asList(body, body2, body3);

    @DisplayName("Тест создания пользователей. Создание, login, logout, удаление")
    @Test
    void createUsersTest() {
        step("Создание пользователей", () -> {
            post.createUsersAndCheck(bodies);
        });
        step("Login пользователя", () -> {
            get.loginUserWithAssert(bodies.get(0).getUsername(), bodies.get(0).getPassword());
        });
        step("Logout пользователя", () -> {
            get.logoutUserWithAssert();
        });
    }

    @AfterEach
    void clear() {
        step("Удаление пользователей", () -> {
            bodies.forEach(x -> {
                delete.deleteUser(x.getUsername());
                get.getUserInfo404WithAssert(x.getUsername());
            });
        });
    }
}