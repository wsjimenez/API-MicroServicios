package com.example.api.services;

import android.util.Log;

import com.example.api.services.dataResponse.InfoResponse;
import com.example.api.services.endpoints.InfoEndPoints;
import com.example.api.services.models.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoServices {
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://10.0.0.36:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // llamado a los metodos para consumir la API

    public Call<InfoResponse> getInfoService() {
        return this.getRetrofit().create(InfoEndPoints.class).getInfo();
    }

    public Call<InfoResponse> getDetailInfoService(String id) {
        return this.getRetrofit().create(InfoEndPoints.class).getDetailInfo(id);
    }

    public Call<InfoResponse> postInfoService(User user) {
        return this.getRetrofit().create(InfoEndPoints.class).postInfo(user);
    }

    public Call<InfoResponse> deleteInfoService(String id) {
        return this.getRetrofit().create(InfoEndPoints.class).deleteInfo(id);
    }

    public Call<InfoResponse> updateInfoService(String id, User user) {
        return this.getRetrofit().create(InfoEndPoints.class).updateInfo(id, user);
    }
}
