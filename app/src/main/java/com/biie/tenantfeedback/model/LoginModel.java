package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("meta")
    private MetaLoginModel metaLogin;
    @SerializedName("data")
    private DataLoginModel dataLogin;

    public LoginModel(){}

    public MetaLoginModel getMeta() {
        return metaLogin;
    }

    public void setMeta(MetaLoginModel metaLogin) {
        this.metaLogin = metaLogin;
    }

    public DataLoginModel getData() {
        return dataLogin;
    }

    public void setData(DataLoginModel dataLogin) {
        this.dataLogin = dataLogin;
    }
}
