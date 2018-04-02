package diegorys.es.ejemplofragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Diego on 01/11/2015.
 */
public class Derecha extends Fragment {
    View rootView;
    TextView txtResultado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        rootView = inflater.inflate(R.layout.derecha, container, false);

        txtResultado = (TextView) rootView.findViewById(R.id.txtResultado);

        return rootView;
    }

    public void obtenerTexto(String mensaje) {
        txtResultado.setText(mensaje);
    }
}
