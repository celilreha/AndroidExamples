package com.celilreha.recyleview_multi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.recyleview_multi.Model.Kisi;
import com.celilreha.recyleview_multi.Model.Reklam;
import com.celilreha.recyleview_multi.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private final static int TIP_KISI = 1, TIP_REKLAM = 2;
    private Context context;

    public RecyclerViewAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        /*
        List içerisindeki gelen tipi yakalayabileceğimiz metot
         */
        if (list.get(position) instanceof Kisi) { // Tipler eşit ise true döner
            return TIP_KISI;
        } else if (list.get(position) instanceof Reklam) {
            return TIP_REKLAM;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TIP_KISI:
                layout = R.layout.layout_kisi;
                View kisiView =
                        LayoutInflater
                                .from(parent.getContext())
                                .inflate(layout,parent,false);
                viewHolder = new KisiViewHolder(kisiView);
                break;
            case TIP_REKLAM:
                layout = R.layout.layout_reklam;
                View reklamView =
                        LayoutInflater
                                .from(parent.getContext())
                                .inflate(layout,parent,false);
                viewHolder = new ReklamViewHolder(reklamView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType){
            case TIP_KISI:
                Kisi kisi = (Kisi)list.get(position);
                ((KisiViewHolder)holder).showDetails(kisi);
                break;
            case TIP_REKLAM:
                Reklam reklam = (Reklam)list.get(position);
                ((ReklamViewHolder)holder).showDetails(reklam);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class KisiViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAdSoyad,tvYas;
        private ImageView ivResim;
        public KisiViewHolder(View itemView) {
            super(itemView);
            ivResim = itemView.findViewById(R.id.ivResim);
            tvAdSoyad = itemView.findViewById(R.id.tvAdSoyad);
            tvYas = itemView.findViewById(R.id.tvYas);
        }
        public void showDetails(Kisi kisi){
            tvAdSoyad.setText(kisi.getAdSoyad());
            tvYas.setText(""+kisi.getYas());
            ivResim.setImageResource(kisi.getResimId());
        }
    }

    public class ReklamViewHolder extends RecyclerView.ViewHolder{
        public ReklamViewHolder(View view){
            super(view);
        }
        public void showDetails(Reklam reklam){

        }
    }
}