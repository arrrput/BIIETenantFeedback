package com.biie.tenantfeedback.api;

import com.biie.tenantfeedback.model.LoginModel;
import com.biie.tenantfeedback.model.ReqLogin;
import com.biie.tenantfeedback.model.Simplist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("login")
    Call<LoginModel> postLogin(@Body ReqLogin u);

    @GET("products")
    Call<Simplist> getProduct();

//    @Multipart
//    @POST("api/upload_api.php")
//    Call<SampleResp> callUploadApi(@Part MultipartBody.Part image, @Part("keterangan") RequestBody ket, @Part("pos") RequestBody pos, @Part("id_user") RequestBody idUser,
//                                   @Part("group") RequestBody group,
//                                   @Part("kargu") RequestBody kargu,
//                                   @Part("other") RequestBody other);

}
