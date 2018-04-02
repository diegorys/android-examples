package diegorys.es.ejemplofragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Enviar{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarTexto(String mensaje) {
        Derecha derecha = (Derecha) getFragmentManager().findFragmentById(R.id.frgDerecha);
        derecha.obtenerTexto(mensaje);
    }
}
