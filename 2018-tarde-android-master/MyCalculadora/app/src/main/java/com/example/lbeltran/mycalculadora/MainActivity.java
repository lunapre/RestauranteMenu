package com.example.lbeltran.mycalculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.PopupMenu;

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

        final EditText num1dec = findViewById(R.id.et_num_1_dec);
        final EditText num1hex = findViewById(R.id.et_num_1_hex);
        final EditText num1bin = findViewById(R.id.et_num_1_bin);
        EditText num2dec = findViewById(R.id.et_num_2_dec);
        EditText num2hex = findViewById(R.id.et_num_2_hex);
        EditText num2bin = findViewById(R.id.et_num_2_bin);
        EditText num3dec = findViewById(R.id.et_num_3_dec);
        EditText num3hex = findViewById(R.id.et_num_3_hex);
        EditText num3bin = findViewById(R.id.et_num_3_bin);
        num1dec.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    int num = Integer.parseInt(num1dec.getText().toString());
                    num1hex.setText(Integer.toHexString(num));
                    num1bin.setText(Integer.toBinaryString(num));
                }

            }
        });
        registerForContextMenu(num3dec);
        registerForContextMenu(num1dec);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.et_num_3_dec)
            getMenuInflater().inflate(R.menu.menu_contextual_de_resultado,menu);
        else if(v.getId() == R.id.et_num_1_dec)
            getMenuInflater().inflate(R.menu.seleccionar_size,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        EditText num1dec = findViewById(R.id.et_num_1_dec);
        double a = Integer.parseInt(num1dec.getText().toString());
        EditText num2dec = findViewById(R.id.et_num_2_dec);
        double b = Integer.parseInt(num2dec.getText().toString());
        EditText num3dec = findViewById(R.id.et_num_3_dec);
        double c=0;
        switch (item.getItemId()){
            case R.id.mc_sumar:
                c = a + b;
                break;
            case R.id.mc_restar:
                c = a - b;
                break;
            case R.id.mc_multiplicar:
                c = a * b;
                break;
            case R.id.mc_dividir:
                c = a / b;
                break;
        }
        String str = String.format("%.2f",c);
        num3dec.setText(str);
        return super.onContextItemSelected(item);
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

    public void mimenu(View view){
        final EditText num1hex = findViewById(R.id.et_num_1_hex);
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mpp_byte:
                        num1hex.setText("1");
                        break;
                    case R.id.mpp_word:
                        num1hex.setText("2");
                        break;
                    case R.id.mpp_double:
                        num1hex.setText("3");
                        break;
                    case R.id.mpp_quadruple:
                        num1hex.setText("4");
                        break;                }
                return false;
            }
        });
        popupMenu.show();
    }
}
