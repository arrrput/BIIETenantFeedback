package com.biie.tenantfeedback.api;


import com.biie.tenantfeedback.model.BadRequest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ari Putra on 2/25/2018.
 */
public abstract class APICallback<T> implements Callback<T> {

    @Deprecated
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        }
        else {
            try {
                BadRequest error = API.getErrorConverter().convert(response.errorBody());
                onError(error);

            } catch (IOException e) {
                onError(new BadRequest(e.getMessage()));
            }
        }
    }


    @Deprecated
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(new BadRequest(t.getLocalizedMessage()));
    }

    protected abstract void onSuccess(T t);

    protected abstract void onError(BadRequest error);
}
