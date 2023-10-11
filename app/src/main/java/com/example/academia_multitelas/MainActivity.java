package com.example.academia_multitelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private TextView resultadoIMCTextView;

    @Override

    public void irParaOutraTela(View view) {
        Intent intent = new Intent(this,  .class); //ERRO AQUI (CONSERTAR QUANDO POSSIVEL!
        startActivity(intent);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telacalculoimc);

        pesoEditText = findViewById(R.id.peso);
        alturaEditText = findViewById(R.id.altura);
        resultadoIMCTextView = findViewById(R.id.ResultadoIMC);

        Button calcularIMCButton = findViewById(R.id.Button_calcIMC);
        calcularIMCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = pesoEditText.getText().toString();
        String alturaStr = alturaEditText.getText().toString();

        if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                // Cálculo do IMC
                double imc = peso / (altura * altura);

                // Exibição do resultado
                resultadoIMCTextView.setText(getString(R.string.ResultadoIMC) + " " + imc);
            } catch (NumberFormatException e) {
                resultadoIMCTextView.setText("Valores inválidos.");
            }
        } else {
            resultadoIMCTextView.setText("Preencha peso e altura.");
        }
    }


}
