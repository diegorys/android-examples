package es.diegorys.ejemplobasedatosexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editUsuario;
    EditText editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String usuario = editUsuario.getText().toString();
                String password = editPassword.getText().toString();

                ArrayList parametros = new ArrayList();
                parametros.add("usuario");
                parametros.add(usuario);
                parametros.add("password");
                parametros.add(password);

                try{
                    Post post = new Post();
                    JSONArray jsonArray = post.getServerData(parametros, "http://url.com/json/recibir.php");

                    if((jsonArray != null) && jsonArray.length()>0){
                        JSONObject json_data = jsonArray.getJSONObject(0);

                        int id = json_data.getInt("ID");
                        String grado = json_data.getString("grado");

                        //DATOS JSON
                        if(id > 0){
                            Toast.makeText(getBaseContext(), "Usuario ID es: "+String.valueOf(id), Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), "Error al conectar", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    class Post{
        private InputStream is = null;
        private String respuesta;

        private void conectaPost(ArrayList parametros, String url){
            ArrayList nameValuesPairs;

            try{
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                nameValuesPairs = new ArrayList();

                if(parametros != null){
                    for(int i = 0; i < parametros.size()-1; i+=2){
                        nameValuesPairs.add(new BasicNameValuePair(
                                (String)parametros.get(i),
                                (String)parametros.get(i+1)
                        ));
                    }

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuesPairs));
                }
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();

                is = entity.getContent();
            }catch (Exception e){
                Log.e("ERROR", "Error de conexión HTTP: "+e.toString());
            }
        }

        private void getRespuestaPost() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String linea = "";

                while ((linea = reader.readLine()) != null) {
                    sb.append(linea+"\n");
                }
                is.close();
                respuesta = sb.toString();
                Log.e("INFO", "Cadena Json"+respuesta);
            }catch (Exception e){
                Log.e("ERROR", "Error al recibir el resultado: "+e.toString());
            }
        }

        private JSONArray getJsonArray() {
            JSONArray jArray = null;

            try{
                jArray = new JSONArray(respuesta);
            }catch (JSONException e){
                Log.e("ERROR", "Error de JSON: "+e.toString());
            }finally {
                return jArray;
            }
        }

        public JSONArray getServerData(ArrayList parametros, String url) {
            conectaPost(parametros, url);

            if(is != null){
                getRespuestaPost();
            }

            if((respuesta != null) && respuesta.trim() != ""){
                return getJsonArray();
            }else{
                return null;
            }
        }
    }
}
