package com.example.charlesmarques.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button obtn_Salvar;
    private TextView oTxt_Resultado;
    private EditText oTxt_Nome;

    private  static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obtn_Salvar = findViewById(R.id.btn_Salvar);
        oTxt_Resultado = findViewById(R.id.txtResultado);
        oTxt_Nome = findViewById(R.id.txt_Nome);

        obtn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences oSharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor  editar = oSharedPreferences.edit();

                if(oTxt_Nome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Porfavor, preencha o nome.",Toast.LENGTH_SHORT).show();
                }else {
                    editar.putString("nome",oTxt_Nome.getText().toString());
                    editar.commit();
                    oTxt_Resultado.setText("Óla "+oTxt_Nome.getText().toString());
                }

            }
        });

        SharedPreferences oSharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if ((oSharedPreferences.contains("nome"))){
            String oNome_Usuario = oSharedPreferences.getString("nome","Usuario não definido");
            oTxt_Resultado.setText(oNome_Usuario);
        }else {
            oTxt_Resultado.setText("Usuario não definido");
        }
    }
}
