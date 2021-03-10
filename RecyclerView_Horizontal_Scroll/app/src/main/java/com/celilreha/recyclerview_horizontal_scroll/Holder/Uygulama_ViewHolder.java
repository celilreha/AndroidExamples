package com.celilreha.recyclerview_horizontal_scroll.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.recyclerview_horizontal_scroll.R;

public class Uygulama_ViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivLogo;
    public TextView tvBaslik;
    public Uygulama_ViewHolder(@NonNull View itemView) {
        super(itemView);
        ivLogo = itemView.findViewById(R.id.ivLogo);
        tvBaslik = itemView.findViewById(R.id.tvBaslik);
    }
}
