package com.example.javier.proyectopdm.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javier.proyectopdm.Modelos.Productos;
import com.example.javier.proyectopdm.R;

import java.util.List;

public class Product_adapter extends RecyclerView.Adapter<Product_adapter.MyViewHolder>{

   private Context context;
   private List<Productos> Productsdata;

    public Product_adapter(Context context, List<Productos> productsdata){
        this.context = context;
        this.Productsdata = productsdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.lista_productos,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
        }


        @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.nombre.setText(Productsdata.get(position).getNombre());


}

@Override
public int getItemCount () {return Productsdata.size();}

public static class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView nombre;

    public MyViewHolder (View views) {
        super(views);

        nombre = (TextView) views.findViewById(R.id.nombre);
    }
}

}