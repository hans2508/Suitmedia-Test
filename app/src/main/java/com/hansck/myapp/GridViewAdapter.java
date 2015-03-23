package com.hansck.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Guest;

/**
 * Created by Hans CK on 21-Mar-15.
 */
public class GridViewAdapter extends ArrayAdapter<Guest> {
    Context context;
    int layoutResourceId;
    ArrayList<Guest> data = new ArrayList<Guest>();

    public GridViewAdapter(Context context, int layoutResourceId,ArrayList<Guest> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.txtNama = (TextView) row.findViewById(R.id.grid_nama);
            holder.image = (ImageView) row.findViewById(R.id.grid_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Guest guest = data.get(position);
        holder.txtNama.setText(guest.getNama());
        holder.image.setImageResource(guest.getImage());
        return row;

    }

    static class RecordHolder {
        TextView txtNama;
        ImageView image;

    }
}
