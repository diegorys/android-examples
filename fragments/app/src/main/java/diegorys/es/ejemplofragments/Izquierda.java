package diegorys.es.ejemplofragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Diego on 01/11/2015.
 */
public class Izquierda extends Fragment {
    View rootView;
    Button btnEnviar;
    EditText editText;
    Enviar ENVIAR;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        rootView = inflater.inflate(R.layout.izquierda, container, false);

        btnEnviar = (Button) rootView.findViewById(R.id.btnEnviar);
        editText = (EditText) rootView.findViewById(R.id.editText);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje;
                mensaje = editText.getText().toString();
                ENVIAR.enviarTexto(mensaje);
            }
        });

        return rootView;
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            ENVIAR = (Enviar) activity;
        }catch (ClassCastException e){
            throw new ClassCastException("Necesitas el mensaje");
        }
    }
}
