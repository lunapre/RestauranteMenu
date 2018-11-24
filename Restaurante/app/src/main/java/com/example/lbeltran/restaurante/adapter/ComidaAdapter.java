package com.example.lbeltran.restaurante.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lbeltran.restaurante.R;
import com.example.lbeltran.restaurante.Modelo.Comida;

import java.util.ArrayList;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ComidaAdapterViewHolder> {
    private ArrayList<Comida> comidas;//variable para el arreglo de objeto comida

    public ComidaAdapter(ArrayList<Comida> comidas) { //constructor
        this.comidas = comidas;
    }

    public ComidaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // REGRESA EN EL LAYOUT LA INFORMACION
        View v = LayoutInflater.from(
                viewGroup.getContext()).inflate(
                R.layout.cardview_producto,
                viewGroup,
                false);
        ComidaAdapterViewHolder comidasViewHolder =
                new ComidaAdapterViewHolder(v);
        return comidasViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final ComidaAdapterViewHolder comidaAdapterViewHolder, int i) {
        final Comida comida = comidas.get(i);
        comidaAdapterViewHolder.foto.setImageResource(comida.getFoto());
        comidaAdapterViewHolder.nombre.setText(comida.getNombre());
        comidaAdapterViewHolder.precio.setText(String.valueOf(comida.getPrecio()));
        comidaAdapterViewHolder.cantidad.setText(String.valueOf(comida.getCantidad()));
        comidaAdapterViewHolder.subirCantidad.
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        comida.setCantidad(comida.getCantidad()+1);
                        comidaAdapterViewHolder.cantidad.setText(
                                String.valueOf(comida.getCantidad()));
                    }
                });
        comidaAdapterViewHolder.bajarCantidad.
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        comida.setCantidad(
                                comida.getCantidad()==0?0:comida.
                                        getCantidad()-1);
                        comidaAdapterViewHolder.cantidad.setText(
                                String.valueOf(comida.getCantidad()));
                    }
                });
    }

    public int getItemCount() {
        return comidas.size();
    }

    public class ComidaAdapterViewHolder extends RecyclerView.ViewHolder{//SE OBTIENEN LOS DATOS QUE ESTAN EN LOS ELEMENTOS DEL LAYOUT
        private ImageView foto;
        private TextView nombre;
        private TextView precio;
        private ImageButton subirCantidad;
        private TextView cantidad;
        private ImageButton bajarCantidad;

        public ComidaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.iv_producto);
            nombre = itemView.findViewById(R.id.tv_nombre);
            precio = itemView.findViewById(R.id.tv_precio);
            subirCantidad = itemView.findViewById(R.id.ib_subir_cantidad);
            bajarCantidad = itemView.findViewById(R.id.ib_bajar_cantidad);
            cantidad = itemView.findViewById(R.id.tv_cantidad_producto);
        }
    }
}


