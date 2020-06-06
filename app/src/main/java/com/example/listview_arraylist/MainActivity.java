package com.example.listview_arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        textView=findViewById(R.id.textView);

        ArrayList<String>listaNombres=new ArrayList<>();

        for(int i=1;i<=10;i++){
            listaNombres.add("Nombre de la presona "+i);
        }

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaNombres);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(parent.getContext(), "Seleccionado : "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                textView.setText("Seleccionado : "+parent.getItemAtPosition(position).toString());
            }
        });
    }
}
