package com.eric.annotation;

import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 11:05 AM
 */
public class PasswordUtils {

    @UserCase(id = 45,description = "Passwords must contain at least one numeric")
    public boolean validate(String pwd){
        return pwd.matches("\\w*\\d\\w*");
    }
    @UserCase(id = 48)
    public String encryptPassword(String pwd) {
        return new StringBuilder(pwd).reverse().toString();
    }

    @UserCase(id = 49, description =
            "New passwords can’t equal previously used ones")
    public boolean checkForNewPassword(List<String> prevpwd,String newPwd) {
        return !prevpwd.contains(newPwd);
    }
}
