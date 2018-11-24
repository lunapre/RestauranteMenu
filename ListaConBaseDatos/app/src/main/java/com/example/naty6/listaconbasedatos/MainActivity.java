package com.example.naty6.listaconbasedatos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Contacto>contactos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         final SwipeRefreshLayout swipeRefreshLayout= findViewById(R.id.srl_lista);
         swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 ListView lista= findViewById(R.id.lv_lista);
                 refrescarLista(lista);
                 lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        contactos.remove(position);
                         ListView lista= findViewById(R.id.lv_lista);
                         refrescarLista(lista);

                     }
                 });
                 swipeRefreshLayout.setRefreshing(false);
             }
         });

            }



    public String[] getDatos(){
        String datos[]= new String [contactos.size()];
        int i =0;
        for(Contacto contacto: contactos){
            datos[i++]=contacto.getId()+" "+contacto.getNombre();
        }
        return datos;
    }

    public void insertar(View view){
        EditText nombre= findViewById(R.id.et_item_nombre);
        EditText email = findViewById(R.id.et_item_email);
        EditText telefono = findViewById(R.id.et_item_telefono);
        Contacto contacto = new Contacto(nombre.getText().toString(),email.getText().toString(),telefono.getText().toString());
        contactos.add(contacto);
    }

    public void refrescarLista(ListView lista){
        String strLista[] = getDatos();
        final ArrayAdapter adaptador= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,strLista);
        lista.setAdapter(adaptador);
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
