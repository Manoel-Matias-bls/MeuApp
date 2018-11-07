package info.cmn.meuapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_segunda);

    }

    //Teste de verificação do ciclo de vida de uma activity
    //Para saber se a aplicação entra em todos os devidos métodos

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("SegundaActivity", "onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d("SegundaActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("SegundaActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("SegundaActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("SegundaActivity", "onDestroy");
    }

}
