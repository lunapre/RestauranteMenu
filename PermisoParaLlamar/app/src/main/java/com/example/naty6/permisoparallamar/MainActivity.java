package com.example.naty6.permisoparallamar;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Activity activity;
    private static final int CODIGO_SOLICITUD_PERMISO=1;


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
        context=getApplicationContext();
        activity=this;
    }

    public boolean verStatusPermiso(){
        int habilitado= ContextCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE);
        if(habilitado==PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            Toast.makeText(MainActivity.this,"El permiso de usuario no esta otorgado",Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public void solicitarPermiso(){
        //checar permiso
        if(ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.CALL_PHONE)){
            Toast.makeText(MainActivity.this,"Permiso ya fue solicitado",Toast.LENGTH_LONG).show();
        }else{
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CALL_PHONE},CODIGO_SOLICITUD_PERMISO);
        }
    }

    public  void llamar(View v){
        solicitarPermiso();
        if(verStatusPermiso()){
            EditText editText = findViewById(R.id.et_numero);
            String numero = editText.getText().toString();
            String numeroUri= "tel:"+numero;
            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(numeroUri));
            startActivity(intent);

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
