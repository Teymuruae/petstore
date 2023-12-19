package io.petstore.methods;

import io.petstore.endpoints.UserEndPoints;
import io.petstore.pojo.requests.CreateUserRequest;
import io.petstore.pojo.responses.CreateUserResponse;
import io.petstore.spec.Spec;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.List;

public class Post {

    private Get get = new Get();
    private UserEndPoints userEndPoints = new UserEndPoints();

    /**
     * метод создания пользователя
     *
     * @param body
     * @return
     */
    public CreateUserResponse createUser(CreateUserRequest body) {
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(userEndPoints.getCreateUser())
                .then()
                .extract().as(CreateUserResponse.class);
    }

    /**
     * метод создания и проверки пользователей
     * @param bodies
     */
    public void createUsersAndCheck(List<CreateUserRequest> bodies) {
        for (CreateUserRequest body : bodies) {
            createUser(body);
            new Get().getUserInfoWithAssert(body);
        }
//        bodies.forEach(x-> new Get().getUserInfoWithAssert(x));
    }
}
