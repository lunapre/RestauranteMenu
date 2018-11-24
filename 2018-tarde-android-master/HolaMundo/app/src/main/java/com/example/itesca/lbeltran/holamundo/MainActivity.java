package com.example.itesca.lbeltran.holamundo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean estado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
    }

    public void funcionUno(View view){
        TextView tv_uno = (TextView) findViewById(R.id.tv_uno);
        estado = !estado;
        tv_uno.setAllCaps(estado);
    }

    public void funcionDos(View view){
        Context context = getApplicationContext();
        CharSequence text = "presionaste el boton 2";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void funcionTres(View view){
        Snackbar snackbar = Snackbar
                .make(view, "Presionaste el boton 3", Snackbar.LENGTH_INDEFINITE);

        snackbar.show();
    }
}
