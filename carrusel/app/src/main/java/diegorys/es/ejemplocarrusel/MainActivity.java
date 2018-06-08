package diegorys.es.ejemplocarrusel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView principal, minion1, minion2, minion3, minion4, minion5, minion6, minion7, minion8, minion9;
    Button btnCambioFondo;
    int fondoID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = (ImageView) findViewById(R.id.principal);
        minion1 = (ImageView) findViewById(R.id.minion1);
        minion2 = (ImageView) findViewById(R.id.minion2);
        minion3 = (ImageView) findViewById(R.id.minion3);
        minion4 = (ImageView) findViewById(R.id.minion4);
        minion5 = (ImageView) findViewById(R.id.minion5);
        minion6 = (ImageView) findViewById(R.id.minion6);
        minion7 = (ImageView) findViewById(R.id.minion7);
        minion8 = (ImageView) findViewById(R.id.minion8);
        minion9 = (ImageView) findViewById(R.id.minion9);
        btnCambioFondo = (Button) findViewById(R.id.btnCambioFondo);

        minion1.setOnClickListener(this);
        minion2.setOnClickListener(this);
        minion3.setOnClickListener(this);
        minion4.setOnClickListener(this);
        minion5.setOnClickListener(this);
        minion6.setOnClickListener(this);
        minion7.setOnClickListener(this);
        minion8.setOnClickListener(this);
        minion9.setOnClickListener(this);
        btnCambioFondo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.minion1:
                principal.setImageResource(R.drawable.minion1);
                fondoID = R.drawable.minion1;
                break;
            case R.id.minion2:
                principal.setImageResource(R.drawable.minion2);
                fondoID = R.drawable.minion2;
                break;
            case R.id.minion3:
                principal.setImageResource(R.drawable.minion3);
                fondoID = R.drawable.minion3;
                break;
            case R.id.minion4:
                principal.setImageResource(R.drawable.minion4);
                fondoID = R.drawable.minion4;
                break;
            case R.id.minion5:
                principal.setImageResource(R.drawable.minion5);
                fondoID = R.drawable.minion5;
                break;
            case R.id.minion6:
                principal.setImageResource(R.drawable.minion6);
                fondoID = R.drawable.minion6;
                break;
            case R.id.minion7:
                principal.setImageResource(R.drawable.minion7);
                fondoID = R.drawable.minion7;
                break;
            case R.id.minion8:
                principal.setImageResource(R.drawable.minion8);
                fondoID = R.drawable.minion8;
                break;
            case R.id.minion9:
                principal.setImageResource(R.drawable.minion9);
                fondoID = R.drawable.minion9;
                break;
            case R.id.btnCambioFondo:
                Bitmap fondo = BitmapFactory.decodeStream(getResources().openRawResource(fondoID));
                try{
                    getApplicationContext().setWallpaper(fondo);
                }catch (IOException e){
                    e.printStackTrace();
                }

                break;
        }
    }
}
