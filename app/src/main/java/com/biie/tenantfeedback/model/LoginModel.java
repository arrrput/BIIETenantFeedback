package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("meta")
    private MetaModel meta;
    @SerializedName("data")
    private DataModel data;

    public LoginModel(){}

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }
}
