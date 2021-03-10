package com.celilreha.soru_bankasi.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.celilreha.soru_bankasi.Model.Ders;
import com.celilreha.soru_bankasi.R;

import java.util.ArrayList;


public class Adapter_Ders extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Ders> dersler;

    public Adapter_Ders() {
    }

    public Adapter_Ders(Context context, ArrayList<Ders> dersler) {
        this.context = context;
        this.dersler = dersler;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dersler.size();
    }

    @Override
    public Object getItem(int position) {
        return dersler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.ders_row,null);
        String color="#"+dersler.get(position).getRenk();
        System.out.println(color);
        String lightColor="#88"+dersler.get(position).getRenk();
        view.setBackgroundColor(Color.parseColor(color));

        TextView tvBaslik=view.findViewById(R.id.tvDersBaslik);
        TextView tvAciklama=view.findViewById(R.id.tvDersAciklama);
        TextView tvKonuSayisi=view.findViewById(R.id.tvDersKonuSayisi);
        TextView tvSoruSayisi=view.findViewById(R.id.tvDersSoruSayisi);
        //LinearLayout linearDers_bg=view.findViewById(R.id.linearDers_bg);

        //linearDers_bg.setBackgroundColor(Color.parseColor(color));
        tvBaslik.setText(dersler.get(position).getDersAdi());
        tvBaslik.setBackgroundColor(Color.parseColor(lightColor));
        tvAciklama.setText(dersler.get(position).getDersAciklama());
        tvAciklama.setBackgroundColor(Color.parseColor(lightColor));
        tvKonuSayisi.setText("Konu Sayısı: "+dersler.get(position).getKonuSayisi());
        tvKonuSayisi.setBackgroundColor(Color.parseColor(lightColor));
        tvSoruSayisi.setText("Soru Sayısı: "+dersler.get(position).getSoruSayisi());
        tvSoruSayisi.setBackgroundColor(Color.parseColor(lightColor));

        return view;
    }
}
