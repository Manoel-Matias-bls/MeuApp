package info.cmn.meuapp.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "meuapp.db";
    private static final int VERSAO_BANCO = 5;

    public DBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);

        Log.d("DBHelper", "Constructor");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("DBHelper", "onCreate");

        String sqlConfiguracoes =  "CREATE TABLE IF NOT EXISTS configuracoes (" +
                "_id INTEGER PRIMARY KEY," +
                "nome VARCHAR(255)," +
                "email VARCHAR(255)" +
                ");";

        db.execSQL(sqlConfiguracoes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DBHelper", "onUpdate");

        switch (oldVersion)
        {
            /*Isso serve para evitar problemas ao atualizar o app, pois faz o app evoluir
             *caso o usuário não tenha feito as atualizações corretas em sequência.
             *Sempre usar a versão anterior como base, sem BREAKS nos cases.*/
            case 1:
                Log.d("DBHelper", "atualização para versão 2");
            case 2:
                Log.d("DBHelper", "atualização para versão 3");
            case 3:
                Log.d("DBHelper", "atualização para versão 4");
            case 4:
                Log.d("DBHelper", "atualização para versão 5");
        }
    }
}
