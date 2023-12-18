package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    private String access_token;
    private String token_type;

    @SerializedName("user")
    private UserDetails user;
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
