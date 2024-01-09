package com.biie.tenantfeedback.api;

import com.biie.tenantfeedback.model.LoginModel;
import com.biie.tenantfeedback.model.LogoutModel;
import com.biie.tenantfeedback.model.PostModel;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.RequestModel;
import com.biie.tenantfeedback.model.TimeLineModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @POST("login")
    Call<LoginModel> postLogin(@Body ReqLogin u);

    @POST("logout")
    Call<LogoutModel> postLogout();

    @GET("my_request")
    Call<List <RequestModel>> getRequest(@Query("status") String status);

    @GET("request/{id}/timeline")
    Call<TimeLineModel> getTimeline(@Path("id") String id);

    @Multipart
    @POST("request/store")
    Call<PostModel> callUploadApi(@Part MultipartBody.Part image,
                                  @Part("lokasi") RequestBody lokasi,
                                  @Part("no_unit") RequestBody no_unit,
                                  @Part("id_department") RequestBody id_department,
                                  @Part("id_part") RequestBody id_part,
                                  @Part("description") RequestBody description);




}
