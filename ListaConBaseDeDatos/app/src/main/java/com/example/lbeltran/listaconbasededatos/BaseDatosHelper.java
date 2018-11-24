package com.example.lbeltran.listaconbasededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosHelper extends SQLiteOpenHelper {
    final static String TABLE_NAME = "contactos";
    final static String CONTACTO_NAME = "nombre";
    final static String CONTACTO_EMAIL = "email";
    final static String CONTACTO_TEL = "telefono";
    final static String _ID = "_id";
    public final static String[] columnas = { _ID, CONTACTO_NAME, CONTACTO_EMAIL, CONTACTO_TEL };

    final private static String CREATE_CMD =

            "CREATE TABLE "+TABLE_NAME+" (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + CONTACTO_NAME + " TEXT NOT NULL, "
                    + CONTACTO_EMAIL + " TEXT NOT NULL, "
                    + CONTACTO_TEL + " TEXT NOT NULL)";

    final private static String NAME = "contacto_bd";
    final private static Integer VERSION = 1;
    final private Context context;

    public BaseDatosHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nada
    }

    public void deleteDatabase(){
        context.deleteDatabase(NAME);
    }
}
