package com.xyz.portal.domain.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class CustomerDTO {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

    @NotNull
    private String retypedPassword;

    @Email
    @NotNull
    private String email;


    private String phoneNumber;
}
