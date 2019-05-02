package com.example.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = findViewById(R.id.LVModules);
        al = new ArrayList<String>();
        al.add("C347");
        al.add("C302");

        aa = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String code = al.get(i);
                Intent intent = new Intent(getBaseContext(), info_page.class);
                intent.putExtra("code", code);
                startActivity(intent);
            }
        });

    }
}
