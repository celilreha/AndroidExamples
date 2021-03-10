package com.celilreha.recylerview_multi2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.recylerview_multi2.Model.Is_Ilan;
import com.celilreha.recylerview_multi2.Model.Meslek;
import com.celilreha.recylerview_multi2.R;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Object> list;
    private final static int TIP_MESLEK=1,TIP_ILAN=2;
    private Context context;

    public RecylerViewAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof Meslek){
            return TIP_MESLEK;
        }else if(list.get(position) instanceof Is_Ilan){
            return TIP_ILAN;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout=0;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType){
            case TIP_MESLEK:
                layout = R.layout.meslek_layout;
                View meslekView=
                        LayoutInflater.from(parent.getContext())
                        .inflate(layout,parent,false);
                viewHolder = new MeslekViewHolder(meslekView);
                break;
            case TIP_ILAN:
                layout = R.layout.ilan_layout;
                View ilanView =
                        LayoutInflater.from(parent.getContext())
                        .inflate(layout,parent,false);
                viewHolder = new IlanViewHolder(ilanView);
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
            case TIP_MESLEK:
                Meslek meslek = (Meslek)list.get(position);
                ((MeslekViewHolder)holder).showDetails(meslek);
                break;
            case TIP_ILAN:
                Is_Ilan ilan = (Is_Ilan) list.get(position);
                ((IlanViewHolder)holder).showDetails(ilan);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MeslekViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMeslekBaslik;
        private ImageView ivResim;
        public MeslekViewHolder(View itemView){
            super(itemView);
            ivResim=itemView.findViewById(R.id.ivResim);
            tvMeslekBaslik = itemView.findViewById(R.id.tvMeslekBaslik);
        }
        public void showDetails(Meslek meslek){
            ivResim.setImageResource(meslek.getResim());
            tvMeslekBaslik.setText(meslek.getBaslik());
        }
    }
    public class IlanViewHolder extends RecyclerView.ViewHolder{
        private TextView tvIlanBaslik;
        private TextView tvFirma;
        private TextView tvMaas;
        public IlanViewHolder(View itemView){
            super(itemView);
            tvIlanBaslik = itemView.findViewById(R.id.tvIlanBaslik);
            tvFirma = itemView.findViewById(R.id.tvFirma);
            tvMaas = itemView.findViewById(R.id.tvMaas);
        }
        public void showDetails(Is_Ilan ilan){
            tvMaas.setText(ilan.getMaas()+"");
            tvFirma.setText(ilan.getFirma());
            tvIlanBaslik.setText(ilan.getBaslik());
        }
    }

}
