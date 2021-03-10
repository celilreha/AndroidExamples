package com.celilreha.recyclerview_satir_animasyonu.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.recyclerview_satir_animasyonu.R;

public class HolderKisi extends RecyclerView.ViewHolder {
    public ImageView ivResim;
    public TextView tvBaslik;

    public HolderKisi(@NonNull View itemView) {
        super(itemView);
        ivResim = itemView.findViewById(R.id.ivResim);
        tvBaslik = itemView.findViewById(R.id.tvYazi);
    }
}
