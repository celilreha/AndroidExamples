package com.celilreha.soru_bankasi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.celilreha.soru_bankasi.Model.Ders;
import com.celilreha.soru_bankasi.Model.Konu;
import com.celilreha.soru_bankasi.R;

import java.util.ArrayList;

public class Adapter_Konu extends BaseAdapter {
    private Context context;
    private ArrayList<Konu> konular;
    private LayoutInflater layoutInflater;

    public Adapter_Konu() {
    }

    public Adapter_Konu(Context context, ArrayList<Konu> konular) {
        this.context = context;
        this.konular = konular;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return konular.size();
    }

    @Override
    public Object getItem(int position) {
        return konular.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.konu_row,null);
        TextView tvBaslik=view.findViewById(R.id.tvKonuBaslik);
        TextView tvAciklama=view.findViewById(R.id.tvKonuAciklama);
        TextView tvSoruSayisi=view.findViewById(R.id.tvKonuSoruSayisi);

        tvBaslik.setText(konular.get(position).getKonuAdi());
        tvAciklama.setText(konular.get(position).getKonuAciklama());
        tvSoruSayisi.setText("Soru Sayısı:"+konular.get(position).getSoruSayisi());
        return view;
    }
}
