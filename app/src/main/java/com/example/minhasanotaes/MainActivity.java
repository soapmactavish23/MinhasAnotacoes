package com.example.minhasanotaes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtAnotacao;
    private ImageButton btnSalvar;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnotacao = (EditText) findViewById(R.id.txtAnotacao);
        btnSalvar = (ImageButton) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = txtAnotacao.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("txt", txt);
                editor.commit();

                Toast.makeText(getApplicationContext(), "Anotação Salva com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        //Recuperar o Valor
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("txt")){
            String anotacaoRecuperada = sharedPreferences.getString("txt", "");
            txtAnotacao.setText(anotacaoRecuperada);
        }

    }
}
