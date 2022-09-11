package com.genspark.SQRLNutRitionAPI.UserConf.Registration;

import com.genspark.SQRLNutRitionAPI.UserConf.Authentication.PasswordMatches;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@PasswordMatches
public class Dto    {
/*
*   This class will be used to handle transferring the bare minimum data
*   between different parts of the account management and creation infrastructure.
*   During account creation, passfields 1 and 2 will be compared against eachother
*   to verify the user has put in their intended password. During password updating,
*   they will contain the old password and the new password.
 */
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String passfield1;
    @NotNull
    @NotEmpty
    private String passfield2;

    public String getUsername() {
        return username;
    }

    public String getPassfield1() {
        return passfield1;
    }

    public String getPassfield2() {
        return passfield2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassfield1(String passfield1) {
        this.passfield1 = passfield1;
    }

    public void setPassfield2(String passfield2) {
        this.passfield2 = passfield2;
    }
}