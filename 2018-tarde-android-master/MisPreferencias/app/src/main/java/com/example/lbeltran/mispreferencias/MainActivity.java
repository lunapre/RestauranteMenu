package com.example.lbeltran.mispreferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void grabar(View view){
        EditText etUsuario = findViewById(R.id.et_nombre_usuario);
        EditText etClave = findViewById(R.id.et_clave);
        String usuario = etUsuario.getText().toString();
        String clave = etClave.getText().toString();
        SharedPreferences preferences =
                getSharedPreferences(usuario,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",usuario);
        editor.putString("clave",clave);
        editor.commit();
        etUsuario.setText("");
        etClave.setText("");
    }

    public void entrar(View view){
        EditText etUsuario = findViewById(R.id.et_nombre_usuario);
        EditText etClave = findViewById(R.id.et_clave);
        String usuario = etUsuario.getText().toString();
        SharedPreferences preferences =
                getSharedPreferences(usuario,Context.MODE_PRIVATE);
        String clave = etClave.getText().toString();
        String claveGrabada = preferences.getString("clave","None");
        if(clave.equals(claveGrabada)){
            Snackbar.make(view, "Exito", Snackbar.LENGTH_LONG)
                    .show();
        }
        else{
            Snackbar.make(view, "Clave Incorrecta", Snackbar.LENGTH_LONG)
                    .show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
