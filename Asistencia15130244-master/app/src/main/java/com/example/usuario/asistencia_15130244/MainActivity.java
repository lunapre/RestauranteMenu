package com.example.usuario.asistencia_15130244;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.EditText;
import android.util.Log;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Adaptador adapter;
    RecyclerView rV;
    private ArrayList<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); // BOTON QUE MOSTRARA LAS OPCIONES DEL TELEFONO
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sending email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                enviarCorreo(alumnos);
            }
        });

        alumnos = new ArrayList<>();
        alumnos.add(new Alumno(R.drawable.michael, "Michael Buble", "15130120", 1));
        alumnos.add(new Alumno(R.drawable.tom, "Tom Hiddleston", "15130121", 1));
        alumnos.add(new Alumno(R.drawable.gerard, "Gerard Butler", "15130122", 1));
        alumnos.add(new Alumno(R.drawable.patricio, "Patricio Estrella", "15130123", 1));
        alumnos.add(new Alumno(R.drawable.hilary, "Hilary Duff", "15130124", 1));
        alumnos.add(new Alumno(R.drawable.snoopy, "Snoopy", "15130125", 1));
        alumnos.add(new Alumno(R.drawable.claudia, "Claudia Luna", "15130126", 1));
        alumnos.add(new Alumno(R.drawable.dianita, "Diana Ruiz", "15130127", 1));
        alumnos.add(new Alumno(R.drawable.DianaP, "Diana Payan", "15130128", 1));
        alumnos.add(new Alumno(R.drawable.elsia, "Elsia Luna", "15130129", 1));

        adapter= new Adaptador(alumnos);
        rV= findViewById(R.id.listaAlumnos);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rV.setLayoutManager(llm);
        rV.setAdapter(adapter);




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
            getEmail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getEmail(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setTitle("Ingresar email:");
        final View dialoglayout = inflater.inflate(R.layout.email, null);
        builder.setView(dialoglayout)
                // SE AÑADEN BOTONES
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText etEmail = dialoglayout.findViewById(R.id.tCorreo);
                        String email = etEmail.getText().toString();
                        Log.d("EMAIL: ", ""+email);
                        SharedPreferences preferences  = getSharedPreferences("Email", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("email", email);
                        editor.commit();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void enviarCorreo(ArrayList<Alumno> alumno) {
        SharedPreferences preferences = getSharedPreferences("Email", Context.MODE_PRIVATE);
        String email = "";
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] to = {email};
        String[] cc = {""};
        String contenido = "";
        for (int i = 0; i < 10; i++) {
            if(i==0){
                contenido=contenido.concat("Matricula     Asistencia"+"\n");
            }else {
                contenido = contenido.concat(alumno.get(i).getMatricula() + "    " + alumno.get(i).getAsistencia() + "\n");
            }
        }
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Examen: app para pase de lista. Alumna: 15130244");
        intent.putExtra(Intent.EXTRA_TEXT,"LISTA DE ASISTENCIA. \n\n"+contenido);
        try {
            startActivity(Intent.createChooser(intent, "How to send mail?"));
        } catch (android.content.ActivityNotFoundException ex) {

        }

    }

    }
