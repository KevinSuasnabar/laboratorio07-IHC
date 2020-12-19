package pe.kev.com.laboratorio07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView texto;
    Spinner paises;
    Spinner ciudades;

    TextView paisS;
    TextView ciudadS;

    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        paises = (Spinner) findViewById(R.id.paises);
        ciudades = (Spinner) findViewById(R.id.ciudades);

        paisS = (TextView) findViewById(R.id.paisS);
        ciudadS = (TextView) findViewById(R.id.ciudadS);

        boton=(Button) findViewById(R.id.aceptar);

        paises.setPrompt("Seleccione un pais");
        ciudades.setPrompt("Seleccione una ciudad");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.paises_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paises.setAdapter(adapter);

        paises.setOnItemSelectedListener(this);
        ciudades.setOnItemSelectedListener(this);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Proceso finalizado!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter<CharSequence> adapter2;
        parent.getItemAtPosition(position);
        if(parent.getId()==R.id.paises){
            if (parent.getItemAtPosition(position).equals("Perú")) {
                adapter2 = ArrayAdapter.createFromResource(this,
                        R.array.peru_ciudades_list, android.R.layout.simple_spinner_item);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ciudades.setAdapter(adapter2);

                paisS.setText(parent.getItemAtPosition(position).toString());

            } else if (parent.getItemAtPosition(position).equals("Venezuela")) {
                adapter2 = ArrayAdapter.createFromResource(this,
                        R.array.venezuela_ciudades_list, android.R.layout.simple_spinner_item);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ciudades.setAdapter(adapter2);
                paisS.setText(parent.getItemAtPosition(position).toString());
            }else{
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Este pais no dispone de ciudades", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else if(parent.getId()==R.id.ciudades){
            ciudadS.setText(parent.getItemAtPosition(position).toString());

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
