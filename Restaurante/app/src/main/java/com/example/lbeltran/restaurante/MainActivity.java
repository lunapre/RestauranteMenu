package com.example.lbeltran.restaurante;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lbeltran.restaurante.Modelo.Bebida;
import com.example.lbeltran.restaurante.Modelo.Comida;
import com.example.lbeltran.restaurante.adapter.PageAdapter;
import com.example.lbeltran.restaurante.fragment.BebidaFragment;
import com.example.lbeltran.restaurante.fragment.ComidaFragment;
import com.example.lbeltran.restaurante.fragment.TotalFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ArrayList comida, bebeida, total



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = findViewById(R.id.viewpager);
        ArrayList<Comida> comidas = new ArrayList<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BebidaFragment(bebidas));
        fragments.add(new ComidaFragment(comidas));
        fragments.add(new TotalFragment(comidas,bebidas));

        viewPager.setAdapter(new PageAdapter(
                getSupportFragmentManager(),
                fragments));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        int n=tabLayout.getTabCount();
        String titulos[]={"Bebidas","Comidas","Total"};
        Drawable iconos[]={
                getResources().
                        getDrawable(R.drawable.icons8_coffee_40),
                getResources().
                        getDrawable(R.drawable.icons8_restaurant_64),
                         getResources().getDrawable(R.drawable.money)};
        for (int i = 0; i < n ; i++) {
            tabLayout.getTabAt(i).setText(titulos[i]);
            tabLayout.getTabAt(i).setIcon(iconos[i]);
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
