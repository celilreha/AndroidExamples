package com.celilreha.json_ornek_ulke.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celilreha.json_ornek_ulke.Model.Ulke;
import com.celilreha.json_ornek_ulke.R;

import java.util.ArrayList;

public class Adapter_Ulke extends BaseAdapter {
    private Context context;
    private ArrayList<Ulke> ulkeler;
    private LayoutInflater layoutInflater;

    public Adapter_Ulke() {
    }

    public Adapter_Ulke(Context context, ArrayList<Ulke> ulkeler) {
        this.context = context;
        this.ulkeler = ulkeler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ulkeler.size();
    }

    @Override
    public Object getItem(int position) {
        return ulkeler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.ulke_layout,null);
        TextView tvAd=view.findViewById(R.id.tvAd);
        TextView tvBaskent=view.findViewById(R.id.tvBaskent);
        TextView tvPara=view.findViewById(R.id.tvPara);
        ImageView ivBayrak = view.findViewById(R.id.ivBayrak);
        int imgId = view.getContext().getResources().getIdentifier(ulkeler.get(position).getBayrak(),
                "drawable",
                view.getContext().getOpPackageName());
        tvAd.setText(ulkeler.get(position).getAd());
        tvBaskent.setText(ulkeler.get(position).getBaskent());
        tvPara.setText(ulkeler.get(position).getParaBirimi());
        ivBayrak.setImageResource(imgId);
        return view;
    }
}
