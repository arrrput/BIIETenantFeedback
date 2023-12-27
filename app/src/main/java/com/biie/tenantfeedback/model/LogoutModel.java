package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;

public class LogoutModel {

    @SerializedName("meta")
    private MetaLogoutModel metaLogout;
    @SerializedName("data")
    private DataLogoutModel dataLogout;

    public LogoutModel(){}

    public MetaLogoutModel getMetaLogout() {
        return metaLogout;
    }

    public void setMetaLogout(MetaLogoutModel metaLogout) {
        this.metaLogout = metaLogout;
    }

    public DataLogoutModel getDataLogout() {
        return dataLogout;
    }

    public void setDataLogout(DataLogoutModel dataLogout) {
        this.dataLogout = dataLogout;
    }
}
