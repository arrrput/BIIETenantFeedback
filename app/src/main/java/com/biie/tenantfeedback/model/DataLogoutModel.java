package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

public class DataLogoutModel {

    @SerializedName("true")
    private boolean pesan;

    public boolean isPesan() {
        return pesan;
    }

    public void setPesan(boolean pesan) {
        this.pesan = pesan;
    }
}
