package com.example.lbeltran.restaurante.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lbeltran.restaurante.Modelo.Comida;
import com.example.lbeltran.restaurante.Modelo.Total;
import com.example.lbeltran.restaurante.R;

import java.util.ArrayList;

public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.TotalAdapterViewHolder> {
            private ArrayList<Total> total;//variable para el arreglo de objeto comida

            public TotalAdapter(ArrayList<Total> total){ //constructor
                this.total = total;
            }

            public TotalAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // REGRESA EN EL LAYOUT LA INFORMACION
                View v = LayoutInflater.from(
                        viewGroup.getContext()).inflate(
                        R.layout.cardview_costos,
                        viewGroup,
                        false);
                TotalAdapterViewHolder totalViewHolder =
                        new TotalAdapterViewHolder(v);
                return totalViewHolder;
            }
            @Override
            public void onBindViewHolder(@NonNull final TotalAdapterViewHolder totalAdapterViewHolder, int i) {
                final Total producto = total.get(i);
                totalAdapterViewHolder.producto.setText(producto.getProducto());
                totalAdapterViewHolder.precio.setText(String.valueOf(producto.getTo()));
                totalAdapterViewHolder.cantidad.setText(String.valueOf(producto.getCantidad()));
            }

            public int getItemCount() {
                return total.size();
            }

            public class TotalAdapterViewHolder extends RecyclerView.ViewHolder{//SE OBTIENEN LOS DATOS QUE ESTAN EN LOS ELEMENTOS DEL LAYOUT
                private TextView producto;
                private TextView precio;
                private TextView cantidad;
                private TextView t;

                public TotalAdapterViewHolder(@NonNull View itemView) {
                    super(itemView);
                    producto = itemView.findViewById(R.id.txt_producto);
                    precio = itemView.findViewById(R.id.txt_precioXproductos);
                    cantidad=itemView.findViewById(R.id.txt_cantidad);
                    t=itemView.findViewById(R.id.txt_total);
                }
            }
        }



