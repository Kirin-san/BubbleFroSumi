package com.example.bubblefrosumi;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;




public class MessageAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private final String[] titles;
private final String[] names;


    public MessageAdapter(Context context, String[] titles,String[] names) {
        super(context, R.layout.my_message, names);

        this.context = context;

        this.titles = titles;
        this.names=names;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Choose here which layout to inflate !!!!!!!!!!!!!!!!!!!!!!

        if (null == convertView && names[position].equals("Me")) {
            convertView = inflater.inflate(R.layout.my_message, parent, false);
        }
        if (null == convertView && names[position].equals("Sumi")) {
            convertView = inflater.inflate(R.layout.their_message, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        TextView titleView = (TextView) convertView.findViewById(R.id.title);

        titleView.setText(titles[position]);
        name.setText(names[position]);


        return convertView;
    }
}