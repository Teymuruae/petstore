package io.petstore.methods;

import io.petstore.endpoints.UserEndPoints;
import io.petstore.pojo.requests.CreateUserRequest;
import io.petstore.pojo.responses.GetUserResponse;
import io.petstore.pojo.responses.LoginUserResponse;
import io.petstore.spec.Spec;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

public class Delete {

    private UserEndPoints userEndPoints = new UserEndPoints();
    public void deleteUserWithAssert(String userName){
        Spec.install(HttpStatus.SC_OK);
        RestAssured
                .given()
                .delete(userEndPoints.getDeleteUser() + "/" + userName)
                .then()
                .body("code", Matchers.equalTo(200))
                .body("message", Matchers.equalTo(userName));
    }

    public void deleteUser(String userName){
        Spec.install(HttpStatus.SC_OK);
        RestAssured
                .given()
                .delete(userEndPoints.getDeleteUser() + "/" + userName);
    }
}