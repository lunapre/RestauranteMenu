package com.example.itesca.lbeltran.ciclovida;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"tuemail@gmail.com",
                        "otroemail@hotmail.com"});
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "texto del correo");
                startActivity(intent);
            }
        });

        EditText nombre = findViewById(R.id.et_nombre);
        EditText apellido = findViewById(R.id.et_apellido);
        EditText edad = findViewById(R.id.et_edad);
        Bundle extras = getIntent().getExtras();
        String strnombre = extras.getString("Nombre");
        String strapellido = extras.getString("Apellido");
        int intEdad = extras.getInt("Edad");
        nombre.setText(strnombre);
        apellido.setText(strapellido);
        edad.setText(""+intEdad);
    }

    public void funcionBoton(View view){
        EditText etNombre= findViewById(R.id.et_nombre);
        EditText etApellido= findViewById(R.id.et_apellido);
        EditText etEdad= findViewById(R.id.et_edad);
        String strNombre = etNombre.getText().toString();
        String strApellido = etApellido.getText().toString();
        String strEdad = etEdad.getText().toString();
        int intEdad = Integer.valueOf(strEdad);
        getIntent().putExtra("Nombre",strNombre);
        getIntent().putExtra("Apellido",strApellido);
        getIntent().putExtra("Edad",intEdad);
        setResult(MainActivity.RESULT_OK,getIntent());
        finish();
    }

}
