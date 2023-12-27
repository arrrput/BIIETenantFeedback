package com.biie.tenantfeedback.model;

public class ResponseLogin {

    public DataLoginModel dataloginModel;
    public MetaLoginModel metaloginModel;

    public DataLoginModel targetData() {
        return dataloginModel;
    }

    public void setData(DataLoginModel dataloginModel) {
        this.dataloginModel = dataloginModel;
    }

    public MetaLoginModel targetMeta() {
        return metaloginModel;
    }

    public void setMeta(MetaLoginModel metaloginModel) {
        this.metaloginModel = metaloginModel;
    }
}
