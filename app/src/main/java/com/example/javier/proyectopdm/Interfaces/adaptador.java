package com.example.javier.proyectopdm.Interfaces;

import com.example.javier.proyectopdm.Pojos.Productos;
import com.example.javier.proyectopdm.Pojos.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface adaptador {



    @FormUrlEncoded
    @POST("login")
    Call<Usuario> logrequest(@Field("user") String username, @Field("password")String password);


    @GET("products")
    Call<List<Productos>> productslistrequest(@Header("Authorization") String token);
}
