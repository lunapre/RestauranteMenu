package com.example.itesca.lbeltran.miscontactos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactos = new ArrayList<>();

        String nombres[] ={
                "aishwarya_rai",
                "angelina_jolie",
                "cameron_diaz",
                "catherine_zeta_jones",
                "charlize_teron",
                "eva_longoria",
                "eva_mendes",
                "halle_barry",
                "jessica_alba",
                "jlopez",
                "kate_winslet",
                "katie_holme",
                "kristin_kreuk",
                "megan_fox",
                "monica_bellucci",
                "natalie_portman",
                "nicole_kidmam",
                "salma_hayek",
                "sandra_bullock",
                "scarlett_johansson"};

        String emails[] = new String[nombres.length];
        int telefonos[] = new int[nombres.length];
        int fotos[]={
                R.drawable.aishwarya_rai,
                R.drawable.angelina_jolie,
                R.drawable.cameron_diaz,
                R.drawable.catherine_zeta_jones,
                R.drawable.charlize_teron,
                R.drawable.eva_longoria,
                R.drawable.eva_mendes,
                R.drawable.halle_barry,
                R.drawable.jessica_alba,
                R.drawable.jlopez,
                R.drawable.kate_winslet,
                R.drawable.katie_holme,
                R.drawable.kristin_kreuk,
                R.drawable.megan_fox,
                R.drawable.monica_bellucci,
                R.drawable.natalie_portman,
                R.drawable.nicole_kidmam,
                R.drawable.salma_hayek,
                R.drawable.sandra_bullock,
                R.drawable.scarlett_johansson};
        int i=0;
        for (String nombre:nombres) {
            emails[i++]=nombre+"@gmail.com";
        }
        for(int iter=0;iter<nombres.length;iter++){
            telefonos[iter]= 33333;
        }

        contactos = new ArrayList<>();
        for(int iter=0;iter<nombres.length;iter++){
            contactos.add(new Contacto(nombres[iter],emails[iter],"Amiga",String.valueOf(telefonos[iter]),fotos[iter]));
        }
        /*
        contactos.add(new Contacto("Nicole Kidman", "nicolekidman@gmail.com","644512487","Amigos",R.drawable.nicole_kidmam));
        contactos.add(new Contacto("Halley Barry", "hbarrey@gmail.com","6410011101","Amigos",R.drawable.halle_barry));
        contactos.add(new Contacto("Angelina Jolie", "angelina_jolie@gmail.com","644533333","Amigos",R.drawable.angelina_jolie));
        contactos.add(new Contacto("Cameron Diaz", "camerond@gmail.com","6445555555","Amigos",R.drawable.cameron_diaz));
        contactos.add(new Contacto("Scarlett Johansson", "scarlett_johansson@gmail.com","647777777","Amigos",R.drawable.scarlett_johansson));
        final String nombres[] = new String[contactos.size()];
        int iter=0;
        for (Contacto contactos:contactos ) {
            nombres[iter++]= contactos.getNombre();
        }
        */

        /*ListView listaNombres = findViewById(R.id.lst_contactos);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                nombres);
        listaNombres.setAdapter(adaptador);
        listaNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(
                        MainActivity.this,
                        MostrarContacto.class);
                Snackbar.make(findViewById(R.id.cl_layout_principal),
                        ""+position,
                        Snackbar.LENGTH_INDEFINITE)
                        .show();
                Contacto contacto = contactos.get(position);
                intent.putExtra("Foto",contacto.getFoto());
                intent.putExtra("Nombre",contacto.getNombre());
                intent.putExtra("Telefono",contacto.getTelefono());
                intent.putExtra("Email",contacto.getEmail());
                intent.putExtra("Grupo",contacto.getGrupo());
                startActivity(intent);
            }
        });*/
        RecyclerView listaContactos = findViewById(R.id.rv_lista_contactos);
        LinearLayoutManager llm = new
                LinearLayoutManager(MainActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,
                new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View v, int posicion) {
                Snackbar.make(findViewById(R.id.cl_layout_principal),
                        contactos.get(posicion).getNombre(),Snackbar.LENGTH_LONG).show();
            }
        });
        listaContactos.setAdapter(adaptador);
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
        switch(id) {
            case R.id.action_settings:
                if (id == R.id.action_settings) {
                    Snackbar.make(findViewById(R.id.cl_layout_principal),
                            "Configuracion",
                            Snackbar.LENGTH_INDEFINITE)
                            .show();
                    return true;
                }
                break;
            case R.id.action_preferences:
                if (id == R.id.action_preferences) {
                    Snackbar.make(findViewById(R.id.cl_layout_principal),
                            "Preferencias",
                            Snackbar.LENGTH_INDEFINITE)
                            .show();
                    return true;
                }
                break;
            case R.id.action_about:
                if (id == R.id.action_about) {
                    Snackbar.make(findViewById(R.id.cl_layout_principal),
                            "Acerca de",
                            Snackbar.LENGTH_INDEFINITE)
                            .show();
                    return true;
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
