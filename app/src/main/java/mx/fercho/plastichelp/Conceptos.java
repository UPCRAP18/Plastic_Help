package mx.fercho.plastichelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class Conceptos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(getIntent().getStringExtra("TITULO"));
        setContentView(R.layout.activity_conceptos);
        Spinner spConceptos = (Spinner) findViewById(R.id.spConceptos);
        final EditText etmDefinicion = (EditText) findViewById(R.id.etmDefinicion);
        etmDefinicion.setEnabled(false);

        spConceptos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        etmDefinicion.setText(getResources().getString(R.string.txtPolimero));
                        break;
                    case 1:
                        etmDefinicion.setText(getResources().getString(R.string.txtMonomero));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
