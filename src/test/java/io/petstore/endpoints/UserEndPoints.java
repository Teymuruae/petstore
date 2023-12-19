package io.petstore.endpoints;

public class UserEndPoints {
    private String
            createUser = "/user",
            getUser = "/user",
            deleteUser = "/user",
            login = "/user/login",
            logOut = "/user/logout";

    public String getCreateUser() {
        return createUser;
    }

    public String getGetUser() {
        return getUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public String getLogin() {
        return login;
    }

    public String getLogOut() {
        return logOut;
    }
}
