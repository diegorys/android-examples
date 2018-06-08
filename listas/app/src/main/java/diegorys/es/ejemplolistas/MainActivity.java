package diegorys.es.ejemplolistas;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static final String[] nombres = new String[]{"Iron Man", "Superman", "Batman", "Catwoman",
            "Spiderman", "Supergirl", "Wolverine", "Ant-Man", "Captain America", "Hulk", "Daredevil",
            "Black Widow", "Wonderwoman", "Flash", "Green Arrow"};
    ListView lstSuperHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);

        lstSuperHeroes = (ListView) findViewById(R.id.lstSuperheroes);
        lstSuperHeroes.setAdapter(adapter);
        lstSuperHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
