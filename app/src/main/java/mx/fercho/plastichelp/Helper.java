package mx.fercho.plastichelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper {


    private static SQLiteDatabase db;

    public Helper(Context context){
        super(context, "usuarios", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String users = "CREATE TABLE IF NOT EXISTS USUARIOS ( BOLETA TEXT, NOMBRE TEXT, APELLIDOS TEXT, PWD TEXT, GRUPO TEXT, TURNO TEXT ) ";
        db.execSQL(users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USUARIOS");
    }


    private Cursor getUsers(String boleta, String pwd) {
        db = this.getReadableDatabase();
        Cursor res;
        res = db.rawQuery("SELECT * FROM USUARIOS WHERE BOLETA = '" + boleta + "' AND PWD = '" + pwd + "'", null);
        return res;
    }


    public ArrayList<String> loginUser(String id, String pwd){
        Cursor cursor = getUsers(id, pwd);
        ArrayList<String> datos = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            datos.add(cursor.getString(1));
            datos.add(cursor.getString(2));
            cursor.moveToNext();
        }
        db.close();
        return datos;
    }


    public boolean registrarUsuario(String boleta, String nombre, String apellidos, String pwd, String grupo, String turno ) {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("BOLETA", boleta);
        values.put("NOMBRE", nombre);
        values.put("APELLIDOS", apellidos);
        values.put("PWD", pwd);
        values.put("TURNO", turno);
        values.put("GRUPO", grupo);

        if (db.insert("USUARIOS", null, values) != 0) {
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }

    }

}
