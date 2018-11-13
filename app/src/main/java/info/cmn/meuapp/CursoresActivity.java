package info.cmn.meuapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import info.cmn.meuapp.helpers.DBHelper;

public class CursoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cursores);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        deletarRegistros();

    }

    public void criarRegistros()
    {
        DBHelper db = new DBHelper(getBaseContext());
        SQLiteDatabase banco = db.getWritableDatabase();

        ContentValues ctv;

        for (int i=1; i<21; i++)
        {
            ctv = new ContentValues();

            ctv.put("nome", "Cliente Manoel"+Integer.toString(i));
            ctv.put("email", "email"+Integer.toString(i)+"@gmail.com");

            banco.insert("clientes", null, ctv);
        }
    }

    public void editarRegistros()
    {
        DBHelper db = new DBHelper(getBaseContext());
        SQLiteDatabase banco = db.getReadableDatabase();

        Cursor cursor = banco.rawQuery("SELECT _id, nome, email FROM clientes", null);
        ContentValues ctv;
        if (cursor.moveToFirst())
        {
            //Tem registros
            do{
                ctv = new ContentValues();
                ctv.put("nome", cursor.getString(cursor.getColumnIndex("nome"))+" ALTERADO" );

                banco.update("clientes", ctv, "_id = " + cursor.getString(cursor.getColumnIndex("_id")), null);
                Log.d("Cursor: ", cursor.getString(cursor.getColumnIndex("nome")));

            }while (cursor.moveToNext());
        }

        cursor.close();
    }

    public void deletarRegistros()
    {

        DBHelper db = new DBHelper(getBaseContext());
        SQLiteDatabase banco = db.getReadableDatabase();
        //getWritableDatabase();
        Cursor cursor = banco.rawQuery("SELECT _id, nome, email FROM clientes", null);
        ContentValues ctv;
        if (cursor.moveToFirst())
        {
            //Tem registros
            do{
                banco.delete("clientes", "_id = "+ cursor.getString(0), null);
                Log.d("Cursor: ", cursor.getString(cursor.getColumnIndex("nome")));

            }while (cursor.moveToNext());
        }
        else {
            Log.d("Cursor", "SEM REGISTRO");
        }

        cursor.close();

    }

}
