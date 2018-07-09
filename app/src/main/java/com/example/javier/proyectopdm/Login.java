package com.example.javier.proyectopdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javier.proyectopdm.Interfaces.adaptador;
import com.example.javier.proyectopdm.Modelos.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity{
    private EditText username;
    private EditText password;
    private Button initiate;
    private adaptador adaptador1;
    private Retrofit retrofit;
    private Call<Usuario> llamar;
    private String url;
    private static String token;
    private Intent vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);


        //Referencia
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        initiate = findViewById(R.id.sign_in_button);

        //URL
        url = "http://gamenewsuca.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //transformando interfaz a clase
        adaptador1 = retrofit.create(adaptador.class);


        initiate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                llamar = adaptador1.logrequest(username.getText().toString(), password.getText().toString());

                //Mandar solicitud
                llamar.enqueue(new Callback<Usuario>() {
                    //Se crea funcion onResponse
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                        if(response.code() !=401){
                            token = response.body().getToken().toString();
                            vista = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(vista);
                        }
                    }
                    //Aplicacion al no poder conectarse a internet
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"No hay Internet",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }


}