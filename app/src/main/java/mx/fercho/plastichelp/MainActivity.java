package mx.fercho.plastichelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etBoleta = (EditText) findViewById(R.id.etBoleta);
        final EditText etPwd = (EditText) findViewById(R.id.etPwd);
        Button btnRegistro = (Button) findViewById(R.id.btnRegistro);
        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        ImageButton imgbCerrar = (ImageButton) findViewById(R.id.imgbCerrar);

        imgbCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(false);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(MainActivity.this, Registro.class);
                startActivity(registro);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etBoleta.getText().toString().isEmpty() || !etPwd.getText().toString().isEmpty()){
                    String id = etBoleta.getText().toString();
                    String pwd = etPwd.getText().toString();

                    ArrayList<String> datos = new Helper(MainActivity.this).loginUser(id, pwd);

                    if (!datos.isEmpty()){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                        dialog.setMessage("Bienvenido " + datos.get(0) + " " + datos.get(1));
                        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent inicio = new Intent(MainActivity.this, Inicio.class);
                                startActivity(inicio);
                            }
                        });
                        dialog.setTitle("Inicio de sesion correcto");
                        dialog.create().show();
                    }else {
                        Toast.makeText(MainActivity.this, "Las credenciales son invalidas", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Por favor introduzca las credenciales", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
