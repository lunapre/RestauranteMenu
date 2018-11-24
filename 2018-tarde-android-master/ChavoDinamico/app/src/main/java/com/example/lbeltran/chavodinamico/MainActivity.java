package com.example.lbeltran.chavodinamico;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
    private int seleccion=0;
    private String biografias[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConstraintLayout contentMain = findViewById(R.id.cl_content_main);
        LinearLayout linearLayout = new LinearLayout(MainActivity.this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        contentMain.addView(linearLayout);

        ListView listaPersonajes = new ListView(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f);
        listaPersonajes.setLayoutParams(params);
        linearLayout.addView(listaPersonajes);

        String personajes[] = getResources().getStringArray(R.array.Personajes);
        biografias = getResources().getStringArray(R.array.Biografia);
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                personajes);
        listaPersonajes.setAdapter(adapter);

        FrameLayout frameBiografia = new FrameLayout(MainActivity.this);
        frameBiografia.setLayoutParams(params);
        frameBiografia.setId(View.generateViewId());
        linearLayout.addView(frameBiografia);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameBiografia.getId(),new BiografiaFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        listaPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView biografia = findViewById(R.id.tv_biografia);
                biografia.setText(biografias[position]);
                seleccion=position;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientacion = getResources().getConfiguration().orientation;
        if(orientacion == ORIENTATION_PORTRAIT){
            TextView biografia = findViewById(R.id.tv_biografia);
            biografia.setText(biografias[seleccion]);
        }
        else if(orientacion == ORIENTATION_LANDSCAPE){
            TextView biografia = findViewById(R.id.tv_biografia);
            biografia.setText(biografias[seleccion]);
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
