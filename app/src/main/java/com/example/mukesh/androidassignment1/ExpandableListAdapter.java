package com.example.mukesh.androidassignment1;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader; // header titles
    private HashMap<String,String> listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String,String> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition));
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String)getChild(groupPosition,childPosition);
        if(convertView == null){//initialize inflator
            LayoutInflater inflator = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.list_item,null);
        }
        TextView txtListChild = convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;//because only 1 child per group. hardcoded since the HashMap is <String,String>
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        if(convertView == null){//initialize inflator
            LayoutInflater inflator = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.list_group,null);
        }
        TextView lblHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
        lblHeader.setText(headerTitle);
        lblHeader.setTypeface(null, Typeface.BOLD);
        return convertView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }



    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}

