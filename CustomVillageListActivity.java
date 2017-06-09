package com.example.thfad_000.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomVillageListActivity extends Activity implements ReturnData{

    ListView list;
    String apiUrl = "http://data.mafra.go.kr:7080/openapi/b98dfa849d0cdbaa8134e68377eefce8b5018d0e26e7f7f6dccd1e52e0f1a75c/xml/Grid_20160127000000000342_1/";
    int apiStartPage = 1;
    int apiEndPage = 15;

    String[] vill = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_village_list);

        GetXMLTask task = new GetXMLTask(this);
        task.execute(apiUrl+apiStartPage+"/"+apiEndPage);
        Log.i("나와랏",vill[0]+"");

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vill);
        list= (ListView) findViewById(R.id.ListView02);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), VillageInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Returnxml(ArrayList<String> s) {
        s.toArray(vill);
    }
}
