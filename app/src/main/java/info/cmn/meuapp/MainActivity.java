package info.cmn.meuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.cmn.meuapp.helpers.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.btnPrincipal);
        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SegundaActivity.class));
            }

        });

        /**Variaveis compartilhadas. Para salvar atributos mais simples
         * Tipo um salvamento simples de banco de dados.

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        //Salva a variavel esta_logado com valor false e a 'persiste'
        sp.edit().putBoolean("esta_logado", false).apply();

        //Para recuperar

        if (sp.getBoolean("esta_logado", false))
        {
            //Condição desejada
        }
         */

        DBHelper db = new DBHelper(getBaseContext());
        db.getReadableDatabase();

    }
}
