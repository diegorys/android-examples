package diegorys.es.ejemplorest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

//http://json.org/
//http://asiermarques.com/2013/conceptos-sobre-apis-rest/
//http://developer.android.com/reference/android/os/AsyncTask.html
//https://hc.apache.org/httpcomponents-client-4.5.x/android-port.html
//http://dev-unotv.tmx-internacional.net/MX_UNO_WSB_APP/rest/appMagazineController/obtieneMagazine

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SyncService syncService = new SyncService();
        syncService.validateSync(this);
        syncService.execute();
    }

    private class SyncService extends AsyncTask<String, String, Boolean> {
        JSONObject responseJSON;
        String urlCompose;
        private ProgressDialog dialog;

        public void validateSync(Context context){
            this.dialog = new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute(){
            this.dialog.setMessage("Sincronizando");
            this.dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;
            HttpClient httpClient = new DefaultHttpClient();
            urlCompose = "http://g500.mx/AppGeolocalizacion/GetStations.php?token=3b120d6dd087042cc46bfc0b94b07382";
            HttpGet get = new HttpGet(urlCompose);
            get.setHeader("content-type", "application/json");

            try {
                Log.d("Conectando a: ", urlCompose);
                HttpResponse response = httpClient.execute(get);
                String respStr = EntityUtils.toString(response.getEntity());
                JSONObject respJSON = new JSONObject(respStr);
                if(respJSON.getBoolean("success")){
                    responseJSON = respJSON;
                }else{
                    result = false;
                }
            } catch (IOException e) {
                Log.e("IOException", "Error al conectar con: "+urlCompose);
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e("JSON", "Error al convertir a JSON boolean");
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            if(dialog.isShowing()){
                dialog.dismiss();
            }
            if(result){
                try {
                    JSONArray data = responseJSON.getJSONArray("arrayResults");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject gasJSON = (JSONObject) data.get(i);
                        Log.d("Estación:", gasJSON.getString("BUSINESS_NAME"));
                    }
                } catch (JSONException e) {
                    Log.e("JSON", "Error al convertir a JSON array");
                    e.printStackTrace();
                }
            }
        }
    }
}
