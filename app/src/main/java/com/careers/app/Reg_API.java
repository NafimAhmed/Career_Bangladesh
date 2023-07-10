package com.careers.app;

public class Reg_API {
    String name,Email,UserType;

    public Reg_API(String name, String email, String userType) {
        this.name = name;
        Email = email;
        UserType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
