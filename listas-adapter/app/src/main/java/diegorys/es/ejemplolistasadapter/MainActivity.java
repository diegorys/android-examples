package diegorys.es.ejemplolistasadapter;

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
    /*static final String[] nombres = new String[]{"Iron Man", "Superman", "Batman", "Catwoman",
            "Spiderman", "Supergirl", "Wolverine", "Ant-Man", "Captain America", "Hulk", "Daredevil",
            "Black Widow", "Wonderwoman", "Flash", "Green Arrow"};*/
    ListView lstSuperHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SuperHeroe[] heroes = new SuperHeroe[]{
            new SuperHeroe(R.drawable.ic_launcher, "Iron Man"),
            new SuperHeroe(R.drawable.ic_launcher, "Superman"),
            new SuperHeroe(R.drawable.ic_launcher, "Batman"),
            new SuperHeroe(R.drawable.ic_launcher, "Catwoman"),
            new SuperHeroe(R.drawable.ic_launcher, "Spiderman"),
            new SuperHeroe(R.drawable.ic_launcher, "Supergirl"),
            new SuperHeroe(R.drawable.ic_launcher, "Wolverine"),
            new SuperHeroe(R.drawable.ic_launcher, "Ant-Man"),
            new SuperHeroe(R.drawable.ic_launcher, "Captain America"),
            new SuperHeroe(R.drawable.ic_launcher, "Hulk"),
            new SuperHeroe(R.drawable.ic_launcher, "Daredevil"),
            new SuperHeroe(R.drawable.ic_launcher, "Black Widow"),
            new SuperHeroe(R.drawable.ic_launcher, "Wonderwoman"),
            new SuperHeroe(R.drawable.ic_launcher, "Flash"),
            new SuperHeroe(R.drawable.ic_launcher, "Green Arrow"),
        };

        SuperHeroeAdapter adapter = new SuperHeroeAdapter(this,R.layout.listview_item_row, heroes);
        lstSuperHeroes = (ListView) findViewById(R.id.lstSuperheroes);
        //View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        //lstSuperHeroes.addHeaderView(header);
        lstSuperHeroes.setAdapter(adapter);

        lstSuperHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.txtNombre);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });
/*

        //Opción 1: extends de AppCompactActivity
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        lstSuperHeroes.setAdapter(adapter);

        //Opción 2: extends ListActivity
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heroes));
        //lstSuperHeroes = getListView();

        lstSuperHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
