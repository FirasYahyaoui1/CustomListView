package com.example.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          final ListView maList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maList = findViewById(R.id.listviewperso);
        ArrayList<HashMap<String,String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre","word");
        map.put("description","Editeur de text");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);


        map = new HashMap<>();
        map.put("titre","exel");
        map.put("description","tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre","Powerpoint");
        map.put("description","Logiciel de présentation");
        map.put("img",String.valueOf(R.drawable.powerpoint));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre","outlook");
        map.put("description","Client de courrier");
        map.put("img",String.valueOf(R.drawable.outlook));
        listItem.add(map);



        SimpleAdapter adapter = new SimpleAdapter(this,listItem,R.layout.activity_list_item,
                new String[] {"img", "titre", "description"},
        new int[] {R.id.img, R.id.titre, R.id.description});
        maList.setAdapter(adapter);

        maList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               HashMap<String, String> map = (HashMap<String, String>) maList.getItemAtPosition(1);

                Toast.makeText(MainActivity.this,map.get("titre"),Toast.LENGTH_LONG).show();
            }
        });
        maList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, String> map = (HashMap<String, String>) maList.getItemAtPosition(1);

                AlertDialog.Builder db = new AlertDialog.Builder(MainActivity.this);
                db.setTitle("select item");
                db.setMessage("votre choix:"+" "+map.get("titre"));
                //Toast.makeText(MainActivity.this,"titre",Toast.LENGTH_LONG).show();
                db.show();

                return true;
                }
        });
    }
}
