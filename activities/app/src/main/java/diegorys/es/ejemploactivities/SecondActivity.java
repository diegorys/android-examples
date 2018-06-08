package diegorys.es.ejemploactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String texto = extras.getString("DATO");
            textView.setText(texto);
        }
    }
}
