package info.cmn.meuapp;

import android.content.ContentValues;
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

        DBHelper db = new DBHelper(getBaseContext());
        SQLiteDatabase banco = db.getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("nome", "Cliente 0");
        ctv.put("email", "email@gmail.com");

        banco.insert("clientes", null, ctv);
    }

}
