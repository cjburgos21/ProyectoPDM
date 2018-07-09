package com.example.javier.proyectopdm.Fragmentos;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.proyectopdm.Adaptadores.Product_adapter;
import com.example.javier.proyectopdm.Interfaces.adaptador;
import com.example.javier.proyectopdm.Modelos.Productos;
import com.example.javier.proyectopdm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Productsfragment extends Fragment {

    View view;
    private String url;
    private adaptador conexion;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private Call<List<Productos>> llamar;
    public static List<Productos> listproduct;
    public static String token;
    private List<Productos> lista1 = null;
    private String nombre;
    private String imagen;
    private float precio;
    private String categoria;
    private int id;



    public Productsfragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.productos_fragment, container, false);

        loadProducts(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public void loadProducts(final View view2){
        url = "";

    if(retrofit == null){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    conexion = retrofit.create(adaptador.class);

    llamar = conexion.productslistrequest("Bearer" +token);
    llamar.enqueue(new Callback<List<Productos>>() {

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onResponse(Call<List<Productos>> llamar, Response<List<Productos>> response){
                lista1 = response.body();
                listproduct =  new ArrayList<>();




                for(int i=0; i<lista1.size(); i++){

                    if(lista1.get(i).getNombre() == null){
                        nombre = "Producto sin nombre";
                    }
                    else{
                        nombre = lista1.get(i).getNombre();}

                    if(lista1.get(i).getCategoria() == null){
                    categoria = "Producto sin categoria";
                    }
                    else{
                    categoria = lista1.get(i).getCategoria();}

                    if(lista1.get(i).getImagen() == null){
                    imagen = "Producto sin imagen";
                    }
                    else{
                    imagen = lista1.get(i).getImagen();}

                    if(lista1.get(i).getPrecio() == null){
                    precio = "Producto sin precio";
                    }
                    else{
                    precio = lista1.get(i).getPrecio();}

                    listproduct.add(
                            new Productos(nombre
                            ,categoria
                            ,imagen
                            ,precio
                            ,lista1.get(i).getId()
                            ,lista1.get(i).get__v()));
                }

                    recyclerView = (RecyclerView) view2.findViewById(R.id.product_recyclerview);
                    Product_adapter product_adapter= new Product_adapter(getContext(), listproduct);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(product_adapter);

            }
            @Override
            public void onFailure(Call<List<Productos>> llamar, Throwable t){

        }

    });


    }

}
