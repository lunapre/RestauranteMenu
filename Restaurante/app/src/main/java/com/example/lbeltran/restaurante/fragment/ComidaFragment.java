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
import com.example.lbeltran.restaurante.adapter.ComidaAdapter;
import com.example.lbeltran.restaurante.Modelo.Comida;

import java.util.ArrayList;

public class ComidaFragment extends Fragment {

    ArrayList<Comida> comidas;

    public ComidaFragment(){

    }

    @SuppressLint("ValidFragment")
    public ComidaFragment(ArrayList<Comida> comidas) {//constructor
        this.comidas = comidas;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.fragment_producto,
                container,
                false);
        String nombresComidas[] ={
                "Pay de calabaza",
                "Cheesecake",
                "Dona",
                "Galletas",
                "Pastel",
                "Roles de canela"};
        int fotosComidas[]={
                R.drawable.calabaza,
                R.drawable.cheesecake,
                R.drawable.dona,
                R.drawable.galletas,
                R.drawable.pastel,
                R.drawable.roles};

        double precioComidas[]={
                30.0,
                43.0,
                15.5,
                10.0,
                30.0,
                55.0
        };

        //ArrayList<Comida> comidas = new ArrayList<>();
        for (int i = 0; i < nombresComidas.length; i++) {
            comidas.add(new Comida(
                    nombresComidas[i],0,
                    fotosComidas[i],
                    precioComidas[i]));
        }
        RecyclerView listaComidas= v.findViewById(R.id.recyclerview_producto);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaComidas.setLayoutManager(llm);
        ComidaAdapter comidaAdapter = new ComidaAdapter(comidas);
        listaComidas.setAdapter(comidaAdapter);

        return v;
    }
}
