package diegorys.es.solorobots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView textNombre;
    TextView textDescripcion;
    Button btnCambiarRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        textNombre = (TextView) findViewById(R.id.txtNombre);
        textDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        btnCambiarRobot = (Button) findViewById(R.id.btnCambiarRobot);
        btnCambiarRobot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCambiarRobot:
                int robot = (int)(Math.random()*5);
                cambiarRobot(robot);
                break;
        }
    }

    public void cambiarRobot(int robot) {
        switch (robot){
            case 0:
                imageView.setImageResource(R.drawable.android);
                textNombre.setText("Andy");
                textDescripcion.setText("Robot de Android. Andy es el logotipo del sistema operativo Android.");
                break;
            case 1:
                imageView.setImageResource(R.drawable.baymax);
                textNombre.setText("Baymax");
                textDescripcion.setText("Baymax es un personaje ficticio, un superhéroe del universo Marvel Comics. Su primera aparición fue en Sunfire y Big Hero 6 # 1 y fue creado por Scott Lobdell y Gus Vásquez. Baymax fue creado por el brillante Tadashi Hamada. Sin embargo, tras la muerte de Tadashi y mientras las fuerzas del mal misteriosamente se levantaron en la ciudad de San Fransokyo, Hiro transformó Baymax en un guerrero que lucha contra el crimen, y junto con un grupo de jóvenes intelectuales, formaron el equipo de superhéroes Big Hero 6.");
                break;
            case 2:
                imageView.setImageResource(R.drawable.bender);
                textNombre.setText("Bender");
                textDescripcion.setText("Bender Bending Rodríguez (Bender Doblador Rodríguez en la versión española de la serie; Bender Doblador Soto y Bender B. Rodriguez en Hispanoamérica) es un personaje de Futurama.\n" +
                        "Es el mejor amigo de Fry, y el cocinero de Planet Express. Fue fabricado en Tijuana, México, en el año 2997 (según el capítulo 3ACV01 - Amazonas con ganas).");
                break;
            case 3:
                imageView.setImageResource(R.drawable.eve);
                textNombre.setText("EVA");
                textDescripcion.setText("EVA es un personaje de la película WALL·E. Es una sonda blanca, enviada para buscar una señal de vida fotosintética (en este caso una planta). WALL·E se enamora de ella.");
                break;
            case 4:
                imageView.setImageResource(R.drawable.walle);
                textNombre.setText("WALL·E");
                textDescripcion.setText("WALL·E es el protagonista de la película WALL·E. WALL·E es un oxidado y viejo robot, que vive solo en la Tierra junto a su cucaracha Hal. El es el ultimo robot superviviente de una fuerza de limpieza de la tierra. En su casa suele haber piezas y recambios de su misma raza. Más tarde conoce a EVA cuando esta está buscando vida en el planeta. Le enseña una planta y esta la guarda y se queda en modo reposo. Cuando llega una nave para recogerla, este la sigue hacia el espacio.");
                break;
        }
    }
}
