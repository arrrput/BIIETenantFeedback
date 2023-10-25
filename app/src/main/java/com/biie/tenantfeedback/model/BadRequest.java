package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ari Putra on 10/14/2017.
 */
public class BadRequest {

    @SerializedName("pesan")
    private String message;

    public BadRequest(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
