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
import com.example.lbeltran.restaurante.Modelo.Bebida;

import java.util.ArrayList;

public class BebidaAdapter extends RecyclerView.Adapter<BebidaAdapter.BebidaAdapterViewHolder> {
    private ArrayList<Bebida> bebidas;

    public BebidaAdapter(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    @NonNull
    @Override
    public BebidaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(
                viewGroup.getContext()).inflate(
                R.layout.cardview_producto,
                viewGroup,
                false);
        BebidaAdapterViewHolder bebidasViewHolder =
                new BebidaAdapterViewHolder(v);
        return bebidasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BebidaAdapterViewHolder bebidaAdapterViewHolder, int i) {
        final Bebida bebida = bebidas.get(i);
        bebidaAdapterViewHolder.foto.setImageResource(
                bebida.getFoto());
        bebidaAdapterViewHolder.nombre.setText(
                bebida.getNombre());
        bebidaAdapterViewHolder.precio.setText(
                String.valueOf(bebida.getPrecio()));
        bebidaAdapterViewHolder.cantidad.setText(
                String.valueOf(bebida.getCantidad()));
        bebidaAdapterViewHolder.subirCantidad.
                setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bebida.setCantidad(bebida.getCantidad()+1);
                bebidaAdapterViewHolder.cantidad.setText(
                        String.valueOf(bebida.getCantidad()));
            }
        });
        bebidaAdapterViewHolder.bajarCantidad.
                setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bebida.setCantidad(
                        bebida.getCantidad()==0?0:bebida.
                                getCantidad()-1);
                bebidaAdapterViewHolder.cantidad.setText(
                        String.valueOf(bebida.getCantidad()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }

    public class BebidaAdapterViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView precio;
        private ImageButton subirCantidad;
        private TextView cantidad;
        private ImageButton bajarCantidad;

        public BebidaAdapterViewHolder(@NonNull View itemView) {
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
