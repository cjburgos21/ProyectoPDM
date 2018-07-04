package com.example.javier.proyectopdm.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("token")
    @Expose

    private String token;
    public Usuario(String token) {this.token = token;}
    public String getToken() {return token;}


}


