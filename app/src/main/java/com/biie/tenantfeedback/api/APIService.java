package com.biie.tenantfeedback.api;

import com.biie.tenantfeedback.model.LoginModel;
import com.biie.tenantfeedback.model.PostModel;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.RequestModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIService {

    @POST("login")
    Call<LoginModel> postLogin(@Body ReqLogin u);

    @GET("my_request")
    Call<List <RequestModel>> getRequest(@Query("status") String status);

    @Multipart
    @POST("request/store")
    Call<PostModel> callUploadApi(@Part MultipartBody.Part image,
                                  @Part("description") RequestBody description,
                                  @Part("id_department") RequestBody id_department,
                                  @Part("id_user") RequestBody id_user,
                                  @Part("progress_request") RequestBody progress_request,
                                  @Part("lokasi") RequestBody lokasi,
                                  @Part("no_unit") RequestBody no_unit,
                                  @Part("id_part") RequestBody id_part);


}
