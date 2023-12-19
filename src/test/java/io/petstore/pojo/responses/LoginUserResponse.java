package io.petstore.pojo.responses;

public class LoginUserResponse {

    private Integer code;
    private String type;
    private String message;

    public LoginUserResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
