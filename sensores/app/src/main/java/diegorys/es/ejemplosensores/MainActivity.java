package diegorys.es.ejemplosensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    LinearLayout linearLayout;
    TextView textView;
    Sensor sensor;
    SensorManager sensorManager;
    String cadena;
    float numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.linearlayout);
        textView = (TextView)findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        numero = event.values[0];
        cadena = String.valueOf(numero);
        textView.setText(cadena);
        Log.i("SENSOR DE PROXIMIDAD", cadena);

        if(numero == 0){
            linearLayout.setBackgroundColor(Color.RED);
        }else{
            linearLayout.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
