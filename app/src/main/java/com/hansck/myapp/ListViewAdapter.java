package com.hansck.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import model.Event;

/**
 * Created by Hans CK on 21-Mar-15.
 */
public class ListViewAdapter extends ArrayAdapter<Event> {
    Context context;
    int layoutResourceId;
    Event data[] = null;

    public ListViewAdapter(Context context, int layoutResourceId, Event[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EventHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new EventHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtNama = (TextView)row.findViewById(R.id.txtNama);
            holder.txtTgl = (TextView)row.findViewById(R.id.txtTgl);

            row.setTag(holder);
        }
        else
        {
            holder = (EventHolder)row.getTag();
        }

        Event event = data[position];
        holder.txtNama.setText(event.getNama());
        holder.txtTgl.setText(event.getTanggal());
        holder.imgIcon.setImageResource(event.getImage());

        return row;
    }

    static class EventHolder
    {
        ImageView imgIcon;
        TextView txtNama;
        TextView txtTgl;
    }
}
