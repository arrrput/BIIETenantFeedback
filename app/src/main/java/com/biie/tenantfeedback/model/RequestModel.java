package com.biie.tenantfeedback.model;

public class RequestModel {

    private int id;
    private String description;
    private int progress_request;
    private int id_user;
    private int id_department;
    private int id_part;
    private String created_at;
    private String updated_at;
    private String image;
    private String cancel;
    private int status_feedback;
    private String lokasi;
    private int no_unit;

    public RequestModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProgress_request() {
        return progress_request;
    }

    public void setProgress_request(int progress_request) {
        this.progress_request = progress_request;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public int getStatus_feedback() {
        return status_feedback;
    }

    public void setStatus_feedback(int status_feedback) {
        this.status_feedback = status_feedback;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getNo_unit() {
        return no_unit;
    }

    public void setNo_unit(int no_unit) {
        this.no_unit = no_unit;
    }
}
