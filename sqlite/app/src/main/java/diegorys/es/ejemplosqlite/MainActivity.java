package diegorys.es.ejemplosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView campo1, campo2;
    Button btnBorrar, btnBuscar, btnInsertar;
    EditText editText;
    String palabra;
    private DataBaseHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = (TextView) findViewById(R.id.campo1);
        campo2 = (TextView) findViewById(R.id.campo2);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnInsertar = (Button) findViewById(R.id.btnInsertar);
        editText = (EditText) findViewById(R.id.edit);

        btnBorrar.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
        btnInsertar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBorrar:
                DataBaseHelper myDBHelper3 = new DataBaseHelper(this);
                palabra = editText.getText().toString();

                try {
                    myDBHelper3.createDataBase();
                } catch (IOException e) {
                    throw new Error("No se puede crear");
                }

                try {
                    myDBHelper3.openDataBase();
                    SQLiteDatabase db = myDBHelper3.getWritableDatabase();
                    String where = "nombre = '"+palabra+"'";
                    db.delete("maestros", where, null);
                    db.close();
                    myDBHelper3.close();
                    Toast.makeText(this, "Maestro borrado", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnBuscar:
                myDbHelper = new DataBaseHelper(this);
                palabra = editText.getText().toString();

                try {
                    myDbHelper.createDataBase();
                } catch (IOException e) {
                    throw new Error("No se puede crear");
                }

                try {
                    myDbHelper.openDataBase();
                    Cursor cursor = myDbHelper.fetchTeacher(palabra);

                    if(cursor != null && cursor.moveToFirst()) {
                        campo1.setText(cursor.getString(0));
                        campo2.setText(cursor.getString(1));
                        cursor.close();
                        myDbHelper.close();
                    }else{
                        Toast.makeText(this, "Maestro no encontrado", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    Toast.makeText(this, "Maestro no encontrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnInsertar:
                DataBaseHelper myDBHelper2 = new DataBaseHelper(this);
                palabra = editText.getText().toString();

                try {
                    myDBHelper2.createDataBase();
                } catch (IOException e) {
                    throw new Error("No se puede crear");
                }

                try {
                    myDBHelper2.openDataBase();
                    SQLiteDatabase db = myDBHelper2.getWritableDatabase();
                    ContentValues valores = new ContentValues();

                    valores.put("id", 10);
                    valores.put("nombre", palabra);
                    valores.put("direccion", "Toledo");
                    valores.put("tel", 99999);

                    db.insert("maestros", null, valores);
                    db.close();
                    myDBHelper2.close();
                    Toast.makeText(this, "Maestro insertado", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    throw new Error("No se puede insertar");
                }
                break;
        }
    }
}
