package com.example.lbeltran.listaconbasededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private SQLiteDatabase sqLiteDatabase = null;
    private BaseDatosHelper bdHelper;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bdHelper = new BaseDatosHelper(this);
        sqLiteDatabase = bdHelper.getWritableDatabase();

        swipeRefreshLayout = findViewById(R.id.srl_lista);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {

                    @Override
                    public void onRefresh() {
                        ListView lista = findViewById(R.id.lv_lista);
                        Cursor c = sqLiteDatabase.query(bdHelper.TABLE_NAME,
                                bdHelper.columnas,
                                null,
                                new String[] {},
                                null,
                                null,
                                null);
                        String strLista[] = getDatos();
                        adapter = new SimpleCursorAdapter(
                                MainActivity.this,
                                R.layout.list_layout,
                                c,
                                BaseDatosHelper.columnas,
                                new int[] {R.id._id,R.id.name},
                                0);
                        lista.setAdapter(adapter);
                        lista.setOnItemClickListener(
                                new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Cursor cursor = adapter.getCursor();
                                        String indice[] = {cursor.getString(0)};
                                        //Toast.makeText(MainActivity.this, indice,Toast.LENGTH_LONG).show();
                                        sqLiteDatabase.delete(BaseDatosHelper.TABLE_NAME,BaseDatosHelper._ID + "=?",indice);
                                    }
                                });
                        swipeRefreshLayout.setRefreshing(false);
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

    public String[] getDatos(){
        String datos[] = new String[contactos.size()];
        int i=0;
        for (Contacto contacto:contactos) {
            datos[i++]=contacto.getId()+" "+contacto.getNombre();
        }
        return datos;
    }



    public void insertar(View view){
        EditText nombre = findViewById(R.id.et_item_nombre);
        EditText email = findViewById(R.id.et_item_email);
        EditText telefono = findViewById(R.id.et_item_telefono);
        Contacto contacto = new Contacto(
                nombre.getText().toString(),
                email.getText().toString(),
                telefono.getText().toString());
        ContentValues values = new ContentValues();

        values.put(BaseDatosHelper.CONTACTO_NAME, contacto.getNombre());
        values.put(BaseDatosHelper.CONTACTO_EMAIL, contacto.getEmail());
        values.put(BaseDatosHelper.CONTACTO_TEL, contacto.getTelefono());
        sqLiteDatabase.insert(BaseDatosHelper.TABLE_NAME, null, values);
    }

    @Override
    protected void onDestroy() {
        sqLiteDatabase.close();
        //bdHelper.deleteDatabase();
        super.onDestroy();
    }

}
