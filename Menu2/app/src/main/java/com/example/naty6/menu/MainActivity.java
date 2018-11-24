package com.example.naty6.menu;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
private ArrayList <producto>drink;
private ArrayList <String> nameDrink;
private int selection=0;
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
        drink = new ArrayList<>();
        drink.add(new producto(R.drawable.americano, "Cafe americano", "30.00"));
        drink.add(new producto(R.drawable.capuccino, "Cafe capuccino", "35.50"));
        drink.add(new producto(R.drawable.expreso, "Cafe espresso", "30.00"));
        drink.add(new producto(R.drawable.frappe, "Frappe", "50.00"));
        drink.add(new producto(R.drawable.latte, "Cafe latte", "25.00"));
        drink.add(new producto(R.drawable.lungo, "Cafe lungo", "36.00"));

        nameDrink = new ArrayList<>();
        nameDrink.add("Cafe americano");
        nameDrink.add("Cafe capuccino");
        nameDrink.add("Cafe espresso");
        nameDrink.add("Cafe Frappe");
        nameDrink.add("Cafe latte");
        nameDrink.add("Cafe lungo");

        ConstraintLayout contentMain = findViewById(R.id.cl_content_manin);
        LinearLayout linearLayout = new LinearLayout(MainActivity.this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        contentMain.addView(linearLayout);

        ListView drinksList = new ListView(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
        drinksList.setLayoutParams(params);
        linearLayout.addView(drinksList);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, nameDrink);
        drinksList.setAdapter(adapter);

        FrameLayout frameDetails = new FrameLayout(MainActivity.this);
        frameDetails.setLayoutParams(params);
        frameDetails.setId(View.generateViewId());
        linearLayout.addView(frameDetails);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameDetails.getId(), new FragmentDrinks());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        drinksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = findViewById(R.id.txtName);
                name.setText(drink.get(position).nameProduct);

                ImageView foto = findViewById(R.id.imgProduct);
                foto.setImageResource(drink.get(position).photo);

                TextView price = findViewById(R.id.txtPRICE);
                price.setText(drink.get(position).price);

                TextView cantidad = findViewById(R.id.txtAmount);
                cantidad.setText(drink.get(position).amount);
                selection = position;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientacion = getResources().getConfiguration().orientation;
        if(orientacion == ORIENTATION_PORTRAIT){
            TextView name = findViewById(R.id.txtName);
            name.setText(drink.get(selection).nameProduct);

            ImageView foto = findViewById(R.id.imgProduct);
            foto.setImageResource(drink.get(selection).photo);

            TextView price= findViewById(R.id.txtPRICE);
            price.setText(drink.get(selection).price);
        }
        else if(orientacion == ORIENTATION_LANDSCAPE){
            TextView biografia = findViewById(R.id.txtName);
            biografia.setText(drink.get(selection).nameProduct);

            ImageView foto = findViewById(R.id.imgProduct);
            foto.setImageResource(drink.get(selection).photo);

            TextView price= findViewById(R.id.txtPRICE);
            price.setText(drink.get(selection).price);
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
