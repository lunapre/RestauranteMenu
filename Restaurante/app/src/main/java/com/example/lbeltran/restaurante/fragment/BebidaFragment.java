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

import com.example.lbeltran.restaurante.R;
import com.example.lbeltran.restaurante.adapter.BebidaAdapter;
import com.example.lbeltran.restaurante.Modelo.Bebida;

import java.util.ArrayList;

public class BebidaFragment extends Fragment {
    ArrayList<Bebida> bebidas;

    public  BebidaFragment(){

    }
    @SuppressLint("ValidFragment")
    public BebidaFragment(ArrayList<Bebida> bebidas) {
       this.bebidas=bebidas;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.fragment_producto,
                container,
                false);
        String nombresBebidas[] ={
                "Americano",
                "Cold brew",
                "espresso",
                "Latte",
                "Moka",
                "Cafe de olla"};
        int fotosBebidas[]={
                R.drawable.americano,
                R.drawable.cold,
                R.drawable.espresso,
                R.drawable.latte,
                R.drawable.moka,
                R.drawable.olla};

        double precioBebidas[]={
                25.5,
                30.0,
                35.0,
                43.0,
                43.0,
                55.0
        };

       // ArrayList<Bebida> bebidas = new ArrayList<>();
        for (int i = 0; i < nombresBebidas.length; i++) {
            bebidas.add(new Bebida(
                    nombresBebidas[i],
                    fotosBebidas[i],
                    precioBebidas[i]));
        }
        RecyclerView listaBebidas= v.findViewById(R.id.recyclerview_producto);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaBebidas.setLayoutManager(llm);
        BebidaAdapter bebidaAdapter = new BebidaAdapter(bebidas);
        listaBebidas.setAdapter(bebidaAdapter);

        return v;
    }
}
