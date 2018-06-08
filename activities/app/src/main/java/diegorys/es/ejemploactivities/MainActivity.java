package diegorys.es.ejemploactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnCambioActivity;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambioActivity = (Button) findViewById(R.id.btnCambioActivity);
        editText = (EditText) findViewById(R.id.editText);

        btnCambioActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String dato = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("DATO", dato);
        startActivity(intent);
    }
}
