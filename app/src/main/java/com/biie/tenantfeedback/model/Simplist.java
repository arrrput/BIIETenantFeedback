package com.biie.tenantfeedback.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Simplist {

    @SerializedName("products")
    private ArrayList <ProductResp> list ;
    public Simplist () {
    }

    public ArrayList<ProductResp> getList() {
        return list;
    }

    public void setList(ArrayList<ProductResp> list) {
        this.list = list;
    }
}
