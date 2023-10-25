package com.biie.tenantfeedback.api;

import android.content.Context;

import com.biie.tenantfeedback.model.BadRequest;
import com.orhanobut.hawk.Hawk;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String ROOT_URL = "http://10.0.2.2/api/";
    private static final String AUTHORIZATION = "Authorization";
    private static final boolean PRINT_DELAY = false;
    private static final boolean INTRO = false;
    private static final String ISDONE = "INTRO";
    private static final String N_PRINT = "PRINTING";
    private static APIService SERVICE;
    private static Retrofit RETROFIT;
    private static Converter<ResponseBody, BadRequest> ERROR_CONVERTER;
    private static final String USER = "USER";
    private static final boolean LOG = false;
    private static final String IS_LOGIN = "isLoging";
    private static final String IMG = "images/";


    public static void init(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String token = Hawk.get(AUTHORIZATION, "");
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .addHeader(AUTHORIZATION, token)
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);
                    }
                });
//        try {
//            builder.sslSocketFactory(getSSLContext(context).getSocketFactory());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        RETROFIT = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ERROR_CONVERTER = RETROFIT.responseBodyConverter(BadRequest.class, new Annotation[0]);
    }

    static Converter<ResponseBody, BadRequest> getErrorConverter() {
        return ERROR_CONVERTER;
    }

    public static Retrofit retrofit() {
        return RETROFIT;
    }

    public static APIService service() {
        if (SERVICE == null) {
            SERVICE = retrofit().create(APIService.class);
        }
        return SERVICE;
    }

    public static void setAccessToken(String token) {
        Hawk.put(AUTHORIZATION, token);
    }

    public static String getAccessToken() {
        return Hawk.get(AUTHORIZATION, "");
    }

    public static void logOut() {
        setAccessToken(null);
        //setCurrentUser(null);
    }

    public static String getRoot(){
        if (!ROOT_URL.isEmpty()){
            return ROOT_URL+IMG;
        }
        return null;
    }


    public static void setIntro(boolean ISTRO){Hawk.put(ISDONE, ISTRO);}

    public static boolean getIntro(){return Hawk.get(ISDONE, INTRO); }

    public static boolean isLogin(){
        return Hawk.get(IS_LOGIN, LOG);
    }

    public static void setIsLogin(boolean LOGIN){
        Hawk.put(IS_LOGIN, LOGIN );
    }
}
