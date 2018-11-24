package com.example.itesca.lbeltran.miscontactos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        int foto = extras.getInt("Foto");
        String nombre = extras.getString("Nombre");
        String telefono = extras.getString("Telefono");
        String email = extras.getString("Email");
        String grupo = extras.getString("Grupo");
        ImageView imvFoto = findViewById(R.id.image_foto);
        TextView tvNombre = findViewById(R.id.tv_nombre);
        TextView tvTelefono = findViewById(R.id.tv_telefono);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvGrupo = findViewById(R.id.tv_grupo);
        imvFoto.setImageResource(foto);
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvGrupo.setText(grupo);
    }

}
