package com.appfood.hung.payload;

import lombok.Data;

@Data
public class UserRegistrationReq {

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    private String email;

    private String confirmEmail;

    private Boolean terms;
}
