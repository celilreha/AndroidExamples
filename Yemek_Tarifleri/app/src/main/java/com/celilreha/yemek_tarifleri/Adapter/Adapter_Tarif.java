package com.celilreha.yemek_tarifleri.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celilreha.yemek_tarifleri.Model.Kategori;
import com.celilreha.yemek_tarifleri.Model.Tarif;
import com.celilreha.yemek_tarifleri.R;

import java.util.ArrayList;

public class Adapter_Tarif extends BaseAdapter {

    private Context context;
    private ArrayList<Tarif> tarifler;
    private LayoutInflater layoutInflater;

    public Adapter_Tarif() {
    }

    public Adapter_Tarif(Context context, ArrayList<Tarif> tarifler) {
        this.context = context;
        this.tarifler = tarifler;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tarifler.size();
    }

    @Override
    public Object getItem(int position) {
        return tarifler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tarifler.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= layoutInflater.inflate(R.layout.tarif_row,null);
        ImageView ivResim=view.findViewById(R.id.ivTarifGorsel);
        TextView tvBaslik=view.findViewById(R.id.tvTarifBaslik);
        TextView tvHazirlamaSuresi=view.findViewById(R.id.tvTarifHazirlamaSuresi);
        TextView tvKisiSayisi=view.findViewById(R.id.tvTarifKisiSayisi);
        TextView tvPisirmeSuresi=view.findViewById(R.id.tvTarifPisirmeSuresi);

        ivResim.setImageResource(tarifler.get(position).getResim());
        tvBaslik.setText(tarifler.get(position).getAd());
        tvHazirlamaSuresi.setText(tarifler.get(position).getHazirlamaSuresi()+" Dk");
        tvPisirmeSuresi.setText(tarifler.get(position).getPisirmeSuresi()+" Dk");
        tvKisiSayisi.setText(tarifler.get(position).getKisiSayisi()+"");
        return view;
    }
}
