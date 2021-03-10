package com.celilreha.recyclerview_swipereflesh.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.recyclerview_swipereflesh.Model.Sayi;
import com.celilreha.recyclerview_swipereflesh.R;

import java.util.ArrayList;

public class AdapterSayi extends RecyclerView.Adapter<AdapterSayi.ViewHolderSayi> {

    private ArrayList<Sayi> sayilar;

    public AdapterSayi(ArrayList<Sayi> sayilar) {
        this.sayilar = sayilar;
    }

    @NonNull
    @Override
    public ViewHolderSayi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sayi_satir,null);
        return new ViewHolderSayi(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSayi holder, int position) {
        holder.textView.setText(""+sayilar.get(position).getNo());

    }

    @Override
    public int getItemCount() {
        return sayilar.size();
    }

    public class ViewHolderSayi extends RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolderSayi(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvSayi);
        }
    }
}
