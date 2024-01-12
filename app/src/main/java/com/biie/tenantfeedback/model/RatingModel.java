package com.biie.tenantfeedback.model;

public class RatingModel {
    private int id_request;
    private float rate_point;
    private String message;

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public float getRate_point() {
        return rate_point;
    }

    public void setRate_point(float rate_point) {
        this.rate_point = rate_point;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
