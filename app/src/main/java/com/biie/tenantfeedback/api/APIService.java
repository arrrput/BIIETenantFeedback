package com.biie.tenantfeedback.api;

import com.biie.tenantfeedback.model.LoginModel;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.RequestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("login")
    Call<LoginModel> postLogin(@Body ReqLogin u);

    @GET("my_request")
    Call<List <RequestModel>> getRequest(@Query("status") String status);

//    @GET("products")
//    Call<Simplist> getProduct();


//    @Multipart
//    @POST("api/upload_api.php")
//    Call<SampleResp> callUploadApi(@Part MultipartBody.Part image, @Part("keterangan") RequestBody ket, @Part("pos") RequestBody pos, @Part("id_user") RequestBody idUser,
//                                   @Part("group") RequestBody group,
//                                   @Part("kargu") RequestBody kargu,
//                                   @Part("other") RequestBody other);

}
