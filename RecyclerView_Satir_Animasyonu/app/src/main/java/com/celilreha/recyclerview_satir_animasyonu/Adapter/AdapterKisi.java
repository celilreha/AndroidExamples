package com.celilreha.recyclerview_satir_animasyonu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.celilreha.recyclerview_satir_animasyonu.Holder.HolderKisi;
import com.celilreha.recyclerview_satir_animasyonu.Model.Kisi;
import com.celilreha.recyclerview_satir_animasyonu.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterKisi extends RecyclerView.Adapter<HolderKisi> {
    private ArrayList<Kisi> kisiler;

    public AdapterKisi(ArrayList<Kisi> kisiler) {
        this.kisiler = kisiler;
    }

    @NonNull
    @Override
    public HolderKisi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kisi_satir,null);
        return new HolderKisi(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderKisi holder, int position) {
        holder.tvBaslik.setText(kisiler.get(position).getAdSoyad());
        Glide.with(holder.itemView.getContext())
                .load(kisiler.get(position).getResimUrl())
                .into(holder.ivResim);

    }

    @Override
    public int getItemCount() {
        return kisiler.size();
    }
}
