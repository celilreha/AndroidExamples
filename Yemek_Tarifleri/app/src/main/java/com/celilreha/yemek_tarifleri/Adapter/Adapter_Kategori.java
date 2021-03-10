package com.celilreha.yemek_tarifleri.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celilreha.yemek_tarifleri.Model.Kategori;
import com.celilreha.yemek_tarifleri.R;

import java.util.ArrayList;

public class Adapter_Kategori extends BaseAdapter {
    private Context context;
    private ArrayList <Kategori> kategoriler;
    private LayoutInflater layoutInflater;

    public Adapter_Kategori() {
    }

    public Adapter_Kategori(Context context, ArrayList<Kategori> kategoriler) {
        this.context = context;
        this.kategoriler = kategoriler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return kategoriler.size();
    }

    @Override
    public Object getItem(int position) {
        return kategoriler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.kategori_row,null);
        TextView tvBaslik = view.findViewById(R.id.tvBaslik);
        ImageView ivResim = view.findViewById(R.id.ivResim);

        tvBaslik.setText(kategoriler.get(position).getAd());
        ivResim.setImageResource(kategoriler.get(position).getResim());

        return view;
    }
}
