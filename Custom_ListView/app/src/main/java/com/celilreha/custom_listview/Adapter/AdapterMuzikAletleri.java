package com.celilreha.custom_listview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celilreha.custom_listview.Model.MuzikAletleri;
import com.celilreha.custom_listview.R;

import java.util.ArrayList;

public class AdapterMuzikAletleri extends BaseAdapter {

    /*
    getCount: Arraylist'in eleman sayısını döner
    getItem: Arraylist'in ilgili indisindeki elemanı döner
    getItemId: Arraylis'in ilgili indisini döner.
    getView: ilgili satır görüntüsünü oluşturabilmek için kullanılır.
     */

    private ArrayList<MuzikAletleri> muzikAletleri;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterMuzikAletleri() {
    }

    public AdapterMuzikAletleri(ArrayList<MuzikAletleri> muzikAletleri, Context context) {
        this.muzikAletleri = muzikAletleri;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /*
    LayoutInflater sayesinde getView metodu içerisinde bir satır görüntüsünün bağlantı işlemini sağlayabiliriz.
     */

    @Override
    public int getCount() {
        return muzikAletleri.size();
    }

    @Override
    public Object getItem(int position) {
        return muzikAletleri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.muzik_aletleri_satir_goruntusu, null);
        ImageView ivResim = view.findViewById(R.id.ivResim);
        TextView tvBaslik, tvAciklama, tvRenk, tvTur, tvFiyat;
        tvBaslik = view.findViewById(R.id.tvBaslik);
        tvAciklama = view.findViewById(R.id.tvAciklama);
        tvRenk = view.findViewById(R.id.tvRenk);
        tvTur = view.findViewById(R.id.tvTur);
        tvFiyat = view.findViewById(R.id.tvFiyat);

        ivResim.setImageResource(muzikAletleri.get(position).getResim());
        tvBaslik.setText(muzikAletleri.get(position).getIsim());
        tvAciklama.setText(muzikAletleri.get(position).getIsim());
        tvFiyat.setText(muzikAletleri.get(position).getFiyat()+"");
        tvRenk.setText(muzikAletleri.get(position).getRenk());
        tvTur.setText(muzikAletleri.get(position).getTur());

        return view;
    }
}
