package com.biie.tenantfeedback.app;

import android.app.Application;
import android.content.Context;

import com.biie.tenantfeedback.api.API;
import com.orhanobut.hawk.Hawk;

public class MyApp extends Application {

    private Context context = this;

    @Override
    public void onCreate() {
        super.onCreate();
        API.init(this);
        Hawk.init(this).build();

    }
}
