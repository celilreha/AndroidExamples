package com.celilreha.yazilim_dilleri_ogren.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celilreha.yazilim_dilleri_ogren.Model.Yazilim_Dili;
import com.celilreha.yazilim_dilleri_ogren.R;

import java.util.ArrayList;

public class Adapter_Yazilim_Dili extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Yazilim_Dili> yazilimDilleri;

    public Adapter_Yazilim_Dili() {

    }

    public Adapter_Yazilim_Dili(Context context, ArrayList<Yazilim_Dili> yazilimDilleri) {
        this.context = context;
        this.yazilimDilleri = yazilimDilleri;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return yazilimDilleri.size();
    }

    @Override
    public Object getItem(int position) {
        return yazilimDilleri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.yazilimdili_row, null);

        TextView tvBaslik = v.findViewById(R.id.tvBaslik);
        TextView tvAciklama = v.findViewById(R.id.tvAciklama);
        ImageView ivResim = v.findViewById(R.id.ivResim);

        tvBaslik.setText(yazilimDilleri.get(position).getBaslik());
        tvAciklama.setText(yazilimDilleri.get(position).getAciklama());
        ivResim.setImageResource(yazilimDilleri.get(position).getResim());

        return v;
    }
}
