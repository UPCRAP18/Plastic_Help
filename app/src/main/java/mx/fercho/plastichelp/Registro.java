package mx.fercho.plastichelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final String[] turnos = getResources().getStringArray(R.array.turnos);
        final EditText etNombre = (EditText) findViewById(R.id.etNombre);
        final EditText etBoleta = (EditText) findViewById(R.id.etBoleta);
        final EditText etApellidos = (EditText) findViewById(R.id.etApellidos);
        final EditText etGrupo = (EditText) findViewById(R.id.etGrupo);
        final EditText etPwd = (EditText) findViewById(R.id.etPwd);
        final Spinner spTurno = (Spinner) findViewById(R.id.spTurno);
        Button btnRegistrar =  (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etNombre.getText().toString().isEmpty() ||
                    !etApellidos.getText().toString().isEmpty() ||
                    !etBoleta.getText().toString().isEmpty() ||
                    !etGrupo.getText().toString().isEmpty()){

                    String nombre = etNombre.getText().toString();
                    String boleta = etBoleta.getText().toString();
                    String apellidos = etApellidos.getText().toString();
                    String grupo = etGrupo.getText().toString();
                    String pwd = etPwd.getText().toString();
                    String turno = turnos[spTurno.getSelectedItemPosition()];

                    if(new Helper(Registro.this).registrarUsuario(boleta, nombre, apellidos, pwd, grupo, turno)){
                        Toast.makeText(Registro.this, "Se ha registrado al usuario", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Registro.this, "Ha ocurrido un error al registrar el usuario", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(Registro.this, "No puede dejar los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
