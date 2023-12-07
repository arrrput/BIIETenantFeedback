package com.biie.tenantfeedback.model;

public class ResponseLogin {

    public DataModel dataModel;
    public MetaModel metaModel;

    public DataModel targetData() {
        return dataModel;
    }

    public void setData(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public MetaModel targetMeta() {
        return metaModel;
    }

    public void setMeta(MetaModel metaModel) {
        this.metaModel = metaModel;
    }
}
