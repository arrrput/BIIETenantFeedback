package com.biie.tenantfeedback.api;


import com.biie.tenantfeedback.model.ProductResp;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.ReqProduct;
import com.biie.tenantfeedback.model.UserResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("auth/login")
    Call<UserResp> postLogin(@Body ReqLogin u);

    @GET("auth/product")
    Call<ProductResp> GetProduct(@Body ReqProduct u);

}
