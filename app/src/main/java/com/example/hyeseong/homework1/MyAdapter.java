package com.example.hyeseong.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyItem {
    int menuIcon; // image resource
    String menuName;
    String menuPrice;
    String menuGrade;

    MyItem(int aIcon, String aName, String aPrice, String aGrade) {
        menuIcon = aIcon;
        menuName = aName;
        menuPrice = aPrice;
        menuGrade = aGrade;
    }
}

public class MyAdapter extends BaseAdapter{
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public MyAdapter(Context context, int resource, ArrayList<MyItem> items) {
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent,false);
        }
        // Set Icon
        ImageView icon = convertView.findViewById(R.id.iconItem);
        icon.setImageResource(mItems.get(position).menuIcon);

        // Set Text 01
        TextView time =  convertView.findViewById(R.id.textItem1);
        time.setText(mItems.get(position).menuName);

        // Set Text 02
        TextView room =  convertView.findViewById(R.id.textItem2);
        room.setText(mItems.get(position).menuPrice);

        return convertView;
    }

}
