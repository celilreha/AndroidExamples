package com.celilreha.recyclerview_horizontal_scroll.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.celilreha.recyclerview_horizontal_scroll.Holder.Uygulama_ViewHolder;
import com.celilreha.recyclerview_horizontal_scroll.Model.Uygulama;
import com.celilreha.recyclerview_horizontal_scroll.R;

import java.util.ArrayList;

public class Uygulama_Adapter extends RecyclerView.Adapter<Uygulama_ViewHolder> {
        private ArrayList <Uygulama> uygulamalar;
        public Uygulama_Adapter(ArrayList<Uygulama> uygulamalar){
            this.uygulamalar=uygulamalar;
        }

        @NonNull
        @Override
        public Uygulama_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.uygulama_satir,null);

            return new Uygulama_ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Uygulama_ViewHolder holder, final int position) {
            // onBindViewHolder, holder sınıfında bulunan nesnelerin değerlerini değiştirelebilmek için kullanılır.
            holder.tvBaslik.setText(uygulamalar.get(position).getBaslik());
            Glide
                    .with(holder.itemView.getContext())
                    .load(uygulamalar.get(position).getResimUrl())
                    .into(holder.ivLogo);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),uygulamalar.get(position).getBaslik(),Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return uygulamalar.size();
        }
    }
