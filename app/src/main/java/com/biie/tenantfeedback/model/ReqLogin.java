package com.biie.tenantfeedback.model;

public class ReqLogin {

    private String username;
    private String password;

    public ReqLogin(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
