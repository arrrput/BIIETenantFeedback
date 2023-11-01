package com.biie.tenantfeedback.api;


import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.UserResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("auth/login")
    Call<UserResp> postLogin(@Body ReqLogin u);
    
}
