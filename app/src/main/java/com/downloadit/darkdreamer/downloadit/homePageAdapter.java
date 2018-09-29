package com.downloadit.darkdreamer.downloadit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class homePageAdapter extends BaseAdapter {

    Context context;
    String[] i_name;
    LayoutInflater inflater;
    int[] pic;

    public homePageAdapter(Context context, String[] i_name,int[] pic) {
        this.context = context;
        this.i_name = i_name;
        this.pic = pic;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return i_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.homepage_adapter,null);
        TextView textView=convertView.findViewById(R.id.textView);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        textView.setText(i_name[position]);
        imageView.setImageResource(pic[position]);
        return convertView;
    }

    public String getItemName(int position){
        return i_name[position];
    }
}
