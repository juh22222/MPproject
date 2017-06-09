package com.example.thfad_000.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by thfad_000 on 2017-04-11.
 */
public class Fragment_2 extends Fragment{

    ListView list;
    ImageButton btn;
    String[] num = {
            "01","02","03","04","05","06","07"
    } ;
    String[] name = {
            "나","남편","어머니","아버지","+","+","+"
    } ;
    View rowView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_2, container, false);
        CustomList adapter = new CustomList(this.getActivity());
        list=(ListView)view.findViewById(R.id.ListView01);
        list.setAdapter(adapter);
        Log.i("뭐에용","왜안돼용");
        return view;
    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.custom_village_listitem, num);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView= inflater.inflate(R.layout.custom_village_listitem, null, true);
            TextView list_num = (TextView) rowView.findViewById(R.id.list_num);
            TextView list_name = (TextView) rowView.findViewById(R.id.list_name);
            btn = (ImageButton)rowView.findViewById(R.id.list_button);
            btn.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.i("되나","안되나");
                    Intent intent = new Intent(view.getContext(), CustomVillageListActivity.class);
                    startActivity(intent);
                }
            });

            list_num.setText(num[position]);
            list_name.setText(name[position]);
            return rowView;
        }
    }
}
