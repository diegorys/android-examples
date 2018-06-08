package diegorys.es.ejemplorotarpantalla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtNombre;
    EditText editNombre;
    Button btnAceptar;
    String nombre;
    CheckBox chkConservarEstado;
    int cambios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        editNombre = (EditText) findViewById(R.id.editNombre);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        chkConservarEstado = (CheckBox) findViewById(R.id.chkConservarEstado);

        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nombre = String.valueOf(editNombre.getText());
        cambios += 1;
        txtNombre.setText("Hola " + nombre + ". Has cambiado " + cambios + " veces de nombre.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //Sólo conservamos el estado si está marcada la opción.
        if(chkConservarEstado.isChecked()) {
            //Comprobamos que hay algo guardado previamente.
            if (nombre != null) {
                outState.putString("NOMBRE", nombre);
                outState.putInt("CAMBIOS", cambios);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        //Sólo conservamos el estado si está marcada la opción.
        if(chkConservarEstado.isChecked()) {
            nombre = savedInstanceState.getString("NOMBRE");
            cambios = savedInstanceState.getInt("CAMBIOS");
            txtNombre.setText("Hola " + nombre + ". Has cambiado " + cambios + " veces de nombre.");
        }
    }
}
