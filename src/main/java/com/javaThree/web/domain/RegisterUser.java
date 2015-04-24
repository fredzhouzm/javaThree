package com.javaThree.web.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fred on 2015/4/23.
 */
public class RegisterUser {
    @NotEmpty(
            message = "{error.required.loginName}"
    )
    private String loginName;
    @NotEmpty(
            message = "{error.required.password}"
    )
    @Pattern(
            regexp = "[a-zA-Z0-9_@!]{8,32}",
            message = "{error.pattern.password}"
    )
    private String password;
    @NotEmpty(
            message = "{error.required.nickName}"
    )
    private String nickName;
    @NotEmpty(
            message = "{error.required.gender}"
    )
    @Pattern(
            regexp = "1|2",
            message = "{error.pattern.gender}"
    )
    private String gender;
    @NotNull(
            message = "{error.required.birthdate}"
    )
    private String birthdate;
    @Email(
            message = "{error.pattern.email}"
    )
    private String email;

    public RegisterUser() {
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String accName) {
        this.loginName = accName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public Date getBirthdateDB() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdateDB = new Date();

        try {
            birthdateDB = fmt.parse(this.getBirthdate());
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return birthdateDB;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "RegisterUser{accName=\'" + this.loginName + '\'' + ", password=\'" + this.password + '\'' + ", nickName=\'" + this.nickName + '\'' + ", gender=\'" + this.gender + '\'' + ", birthdate=" + this.birthdate + ", email=\'" + this.email + '\'' + '}';
    }
}
