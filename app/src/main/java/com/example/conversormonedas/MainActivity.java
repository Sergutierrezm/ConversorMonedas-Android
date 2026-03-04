package com.example.conversormonedas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        //Logica

        EditText valor1;
        Button convertirEuro, convertirDolar;
        TextView resultado2;

        valor1 = findViewById(R.id.valor_1);
        convertirEuro = findViewById(R.id.convertir_euro);
        convertirDolar = findViewById(R.id.convertir_dolar);
        resultado2 = findViewById(R.id.resultado_2);

        double cambio = 1.21;

        //Metodo convertir euros a dolares

        convertirEuro.setOnClickListener(v -> {
            String texto = valor1.getText().toString();

            if(texto.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Debe introducir una cantidad a convertir",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double euros = Double.parseDouble(texto);
                double dolares = euros * cambio;

                resultado2.setText(String.valueOf(dolares));

                Toast.makeText(MainActivity.this,
                        "Operacion realizada correctamente",
                        Toast.LENGTH_SHORT).show();
            }catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this,
                        "Valor erroneo, introduzca un valor numerico",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Metodo convertir dolares a euros
        convertirDolar.setOnClickListener(v -> {
            String texto = valor1.getText().toString();

            if (texto.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Debe introducir una cantidad a convertir",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            try{
                double dolares = Double.parseDouble(texto);
                double euros = dolares / cambio;

                resultado2.setText(String.valueOf(euros));

                Toast.makeText(MainActivity.this,
                        "Operacion realizada correctamente",
                        Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this,
                        "Valor erroneo, introduzca un valor numerico",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}