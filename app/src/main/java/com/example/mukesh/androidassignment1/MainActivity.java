package com.example.mukesh.androidassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter adapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String,String> listDataChild;
    XMLPlayersData xmlPlayersData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Top 6 Tennis Players");

        expListView = findViewById(R.id.lvExp);
        //read xml and prepare data
        xmlPlayersData = new XMLPlayersData(getApplicationContext());
        //create the list data
        createListData();

        adapter = new ExpandableListAdapter(this,listDataHeader,listDataChild);

        expListView.setAdapter(adapter);

        expListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(ExpandableListView.getPackedPositionChild(id) == ExpandableListView.PACKED_POSITION_TYPE_GROUP){
                    Bundle b = new Bundle();
                    b.putSerializable("data",xmlPlayersData.getPlayersData(position-1));
                    Intent intent = new Intent(getApplicationContext(),BasicInfoActivity.class);
                    intent.putExtras(b);
                    startActivity(intent);
                    //Toast.makeText(this,"Group position: "+groupPos,10);
                }
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),"Long press the info to view more..",Toast.LENGTH_LONG).show();
                if(groupPosition != previousGroup){
                    expListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
            }
        });

    }

    private void createListData(){
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String,String>();
        Players players[] = xmlPlayersData.players;
        for(int i=0; i<players.length; i++){
            listDataHeader.add(players[i].getName());
            listDataChild.put(players[i].getName(),players[i].getShortInfo());
        }
    }
}
