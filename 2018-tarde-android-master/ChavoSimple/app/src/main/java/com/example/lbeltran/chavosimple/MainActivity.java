package com.example.lbeltran.chavosimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(
                R.id.fragment_biografia,
                new BiografiaFragment());
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();


        String personajes[] = getResources().getStringArray(R.array.Personajes);
        final String biografias[] = getResources().getStringArray(R.array.Biografia);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                personajes);
        ListView listaPersonajes = findViewById(R.id.lv_personajes);
        listaPersonajes.setAdapter(adapter);
        listaPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int orientacion= getResources().getConfiguration().orientation;
                if(orientacion == ORIENTATION_PORTRAIT){
                    Intent i = new Intent(
                            MainActivity.this,
                            Biografia.class);
                    i.putExtra("biografia",biografias[position]);
                    startActivity(i);
                }
                else if (orientacion == ORIENTATION_LANDSCAPE){
                    TextView tvBiografia = findViewById(R.id.tv_biografia2);
                    tvBiografia.setText(biografias[position]);
                }

            }
        });
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
