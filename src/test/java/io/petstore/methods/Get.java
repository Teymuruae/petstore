package io.petstore.methods;

import io.petstore.endpoints.UserEndPoints;
import io.petstore.pojo.requests.CreateUserRequest;
import io.petstore.pojo.responses.GetUserResponse;
import io.petstore.pojo.responses.LoginUserResponse;
import io.petstore.spec.Spec;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

public class Get {

    private UserEndPoints userEndPoints = new UserEndPoints();


    public GetUserResponse getUserInfo(String userName) {
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .get(userEndPoints.getGetUser() + "/" + userName)
                .then()
                .extract().as(GetUserResponse.class);
    }

    public GetUserResponse getUserInfoWithAssert(String userName, int id,  String firstName, String lastName,
                                                 String email, String password, String phone, int userStatus) {
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .given()
                .get(userEndPoints.getGetUser() + "/" + userName)
                .then()
                .body("username", Matchers.equalTo(userName))
                .body("id", Matchers.equalTo(id))
                .body("firstName", Matchers.equalTo(firstName))
                .body("lastName", Matchers.equalTo(lastName))
                .body("email", Matchers.equalTo(email))
                .body("password", Matchers.equalTo(password))
                .body("phone", Matchers.equalTo(phone))
                .body("userStatus", Matchers.equalTo(userStatus))
                .extract().as(GetUserResponse.class);
    }

    public void getUserInfo404WithAssert(String userName) {
        Spec.install(HttpStatus.SC_NOT_FOUND);
         RestAssured
                .given()
                .get(userEndPoints.getGetUser() + "/" + userName)
                .then()
                .body("code", Matchers.equalTo(1))
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.equalTo("User not found"));
    }

    public GetUserResponse getUserInfoWithAssert(CreateUserRequest createUserRequest
    ) {
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .given()
                .get(userEndPoints.getGetUser() + "/" + createUserRequest.getUsername())
                .then()
                .body("username", Matchers.equalTo(createUserRequest.getUsername()))
                .body("id", Matchers.equalTo(createUserRequest.getId()))
                .body("firstName", Matchers.equalTo(createUserRequest.getFirstName()))
                .body("lastName", Matchers.equalTo(createUserRequest.getLastName()))
                .body("email", Matchers.equalTo(createUserRequest.getEmail()))
                .body("password", Matchers.equalTo(createUserRequest.getPassword()))
                .body("phone", Matchers.equalTo(createUserRequest.getPhone()))
                .body("userStatus", Matchers.equalTo(createUserRequest.getUserStatus()))
                .extract().as(GetUserResponse.class);
    }

    public LoginUserResponse loginUser(String userName, String password){
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .given()
                .formParams("username", userName)
                .formParams("password", password)
                .get(userEndPoints.getLogin())
                .then()
                .extract().as(LoginUserResponse.class);
    }


    public LoginUserResponse loginUserWithAssert(String userName, String password){
        Spec.install(HttpStatus.SC_OK);
        return RestAssured
                .given()
                .formParams("username", userName)
                .formParams("password", password)
                .get(userEndPoints.getLogin())
                .then()
                .body("code", Matchers.equalTo(200))
                .body("message", Matchers.containsString("logged in user session"))
                .extract().as(LoginUserResponse.class);
    }

    public void logoutUserWithAssert(){
        Spec.install(HttpStatus.SC_OK);
        RestAssured
                .get(userEndPoints.getLogOut())
                .then()
                .body("code", Matchers.equalTo(200))
                .body("message", Matchers.equalTo("ok"));
    }
}