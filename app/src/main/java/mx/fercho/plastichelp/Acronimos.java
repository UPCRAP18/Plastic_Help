package mx.fercho.plastichelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Acronimos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acronimos);
        getSupportActionBar().setTitle(getIntent().getStringExtra("TITULO"));
        final ImageView imgComp1 = (ImageView) findViewById(R.id.imgComp1);
        final ImageView imgComp2 = (ImageView) findViewById(R.id.imgComp2);
        ListView lstCompuestos = (ListView) findViewById(R.id.lstAcrons);
        final TextView txtNombre = (TextView) findViewById(R.id.txtNombre_Compuesto);
        final EditText etmDesc = (EditText) findViewById(R.id.etmDescripcion);
        final EditText etmInfo = (EditText) findViewById(R.id.etmInformacion);
        final EditText etmUsos = (EditText) findViewById(R.id.etmUsos);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.acrons, android.R.layout.simple_gallery_item);
        lstCompuestos.setAdapter(adapter);

        lstCompuestos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        imgComp1.setImageDrawable(getResources().getDrawable(R.drawable.pvc));
                        imgComp2.setImageDrawable(getResources().getDrawable(R.drawable.pvc1));
                        txtNombre.setText(getResources().getString(R.string.pvc));
                        etmDesc.setText(getResources().getString(R.string.desc_pvc));
                        etmInfo.setText(getResources().getString(R.string.info_pvc));
                        etmUsos.setText(getResources().getString(R.string.ap_pvc));
                        break;
                    case 1:
                        imgComp1.setImageDrawable(getResources().getDrawable(R.drawable.abs));
                        imgComp2.setImageDrawable(getResources().getDrawable(R.drawable.abs1));
                        txtNombre.setText(getResources().getString(R.string.abs));
                        etmDesc.setText(getResources().getString(R.string.desc_abs));
                        etmInfo.setText(getResources().getString(R.string.info_abs));
                        etmUsos.setText(getResources().getString(R.string.ap_abs));
                        break;
                    case 2:
                        imgComp1.setImageDrawable(getResources().getDrawable(R.drawable.asa));
                        imgComp2.setImageDrawable(getResources().getDrawable(R.drawable.asa1));
                        txtNombre.setText(getResources().getString(R.string.asa));
                        etmDesc.setText(getResources().getString(R.string.desc_asa));
                        etmInfo.setText(getResources().getString(R.string.info_asa));
                        etmUsos.setText(getResources().getString(R.string.ap_asa));
                        break;
                    case 3:
                        imgComp1.setImageDrawable(getResources().getDrawable(R.drawable.pet));
                        imgComp2.setImageDrawable(getResources().getDrawable(R.drawable.pet1));
                        txtNombre.setText(getResources().getString(R.string.pet));
                        etmDesc.setText(getResources().getString(R.string.desc_pet));
                        etmInfo.setText(getResources().getString(R.string.info_pet));
                        etmUsos.setText(getResources().getString(R.string.ap_pet));
                        break;
                }
            }
        });

    }
}
