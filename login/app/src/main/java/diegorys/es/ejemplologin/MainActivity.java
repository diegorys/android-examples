package diegorys.es.ejemplologin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUsuario;
    EditText editPassword;
    Button btnLogin;
    Button btnRecuperar;
    TextView textBienvenida;

    String usuarioValido = "Diego";
    String passwordValido = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

        btnLogin.setOnClickListener(this);
        btnRecuperar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String usuarioIntroducido;
                String passwordIntroducido;
                usuarioIntroducido = editUsuario.getText().toString();
                passwordIntroducido = editPassword.getText().toString();

                if((usuarioIntroducido.compareToIgnoreCase(usuarioValido) == 0) && (passwordIntroducido.compareTo(passwordValido) == 0)){
                    setContentView(R.layout.activity_main);
                    textBienvenida = (TextView)findViewById(R.id.textBienvenida);
                    textBienvenida.setText("Bienvenido " + usuarioValido);
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRecuperar:
                Toast.makeText(this, "Se ha enviado un email a su correo con las instrucciones para recuperar su contraseña.", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
