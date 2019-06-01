package mx.fercho.plastichelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ProcesosTransformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesos_transformacion);
        getSupportActionBar().setTitle(getIntent().getStringExtra("TITULO"));
        final ImageView imgExplicacion = (ImageView) findViewById(R.id.imgExplicacion);
        final ImageView imgAplicacion = (ImageView) findViewById(R.id.imgAplicaciones);
        Spinner spProcesos = (Spinner) findViewById(R.id.spProcesos);
        final TextView txtProcesos = (TextView) findViewById(R.id.txtDescrip);
        final EditText etDefinicion = (EditText) findViewById(R.id.etmDescripcion);
        final EditText etAplicacion = (EditText) findViewById(R.id.etmAplicaciones);
        etAplicacion.setEnabled(false);


        spProcesos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        txtProcesos.setText("¿Que es el proceso de Inyeccion?");
                        imgExplicacion.setImageDrawable(getResources().getDrawable(R.drawable.inyeccion));
                        imgAplicacion.setImageDrawable(getResources().getDrawable(R.drawable.inyeccion1));
                        etDefinicion.setText(getResources().getString(R.string.def_Inyeccion));
                        etAplicacion.setText(getResources().getString(R.string.ap_Inyeccion));
                        break;
                    case 1:
                        txtProcesos.setText("¿Que es el proceso de Extruccion?");
                        imgExplicacion.setImageDrawable(getResources().getDrawable(R.drawable.extrusion));
                        imgAplicacion.setImageDrawable(getResources().getDrawable(R.drawable.extrusion1));
                        etDefinicion.setText(getResources().getString(R.string.def_Ext));
                        etAplicacion.setText(getResources().getString(R.string.ap_Ext));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
