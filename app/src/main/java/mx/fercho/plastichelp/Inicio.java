package mx.fercho.plastichelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        final String[] opciones = getResources().getStringArray(R.array.opciones);
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        final RadioGroup rbOpciones = (RadioGroup) findViewById(R.id.rbOpciones);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rbOpciones.getCheckedRadioButtonId()){
                    case R.id.rbConceptos:
                        Intent conceptos = new Intent(Inicio.this, Conceptos.class);
                        conceptos.putExtra("TITULO", opciones[0]);
                        startActivity(conceptos);
                        break;
                    case R.id.rbProcesos:
                        Intent procesos = new Intent(Inicio.this, ProcesosTransformacion.class);
                        procesos.putExtra("TITULO", opciones[1]);
                        startActivity(procesos);
                        break;
                    case R.id.rbAcron:
                        Intent acron = new Intent(Inicio.this, Acronimos.class);
                        acron.putExtra("TITULO", opciones[2]);
                        startActivity(acron);
                        break;
                }
            }
        });

    }
}
