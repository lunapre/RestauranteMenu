package com.example.lbeltran.restaurante.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lbeltran.restaurante.Modelo.Bebida;
import com.example.lbeltran.restaurante.Modelo.Comida;
import com.example.lbeltran.restaurante.Modelo.Total;
import com.example.lbeltran.restaurante.R;
import com.example.lbeltran.restaurante.adapter.ComidaAdapter;
import com.example.lbeltran.restaurante.adapter.TotalAdapter;

import java.util.ArrayList;

public class TotalFragment extends Fragment {

    ArrayList<Comida> comidas;
    ArrayList<Bebida> bebidas;
    public TotalFragment(){

    }
    @SuppressLint("ValidFragment")
    public TotalFragment(ArrayList<Comida> comidas, ArrayList<Bebida> bebidas) {//constructor
        this.comidas=comidas;
        this.bebidas=bebidas;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_total,container,false);
        ArrayList<Total> pedido =  new ArrayList();
        for (int i =0; i<comidas.size();i++){
            if(comidas.get(i).getCantidad()>0){
                Double subtotal=comidas.get(i).getCantidad()*comidas.get(i).getPrecio();
                pedido.add(new Total(comidas.get(i).getNombre(),comidas.get(i).getCantidad(),subtotal));
            }
        }
        for (int i =0; i<bebidas.size();i++){
            if(bebidas.get(i).getCantidad()>0){
                Double subtotal=bebidas.get(i).getCantidad()*bebidas.get(i).getPrecio();
                pedido.add(new Total(bebidas.get(i).getNombre(),bebidas.get(i).getCantidad(),subtotal));
            }
        }

        TextView sub=v.findViewById(R.id.txt_total);
        sub.setText(""+subtotal(pedido));

        RecyclerView listaPedido= v.findViewById(R.id.rv_pedido);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPedido.setLayoutManager(llm);
        TotalAdapter totalAdapter = new TotalAdapter(pedido);
        listaPedido.setAdapter(totalAdapter);

        // creas los objetos arraylist


        return v;
    }
    public double subtotal(ArrayList<Total> pedido){
        double t=0;
        for(int i=0;i<pedido.size();i++){
            t+=pedido.get(i).getTo();
        }
        return t;
    }
}
