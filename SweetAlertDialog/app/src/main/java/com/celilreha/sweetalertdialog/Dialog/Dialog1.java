package com.celilreha.sweetalertdialog.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.celilreha.sweetalertdialog.R;

public class Dialog1 extends DialogFragment {

    private String baslik,aciklama;

    public Dialog1(){

    }

    public Dialog1(String baslik, String aciklama) {
        this.baslik = baslik;
        this.aciklama = aciklama;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_style1,null);
        Button btnDialogTamam=view.findViewById(R.id.btnDialogTamam);
        TextView tvDialog1Aciklama = view.findViewById(R.id.tvDialog1Aciklama);
        TextView tvDialog1Baslik = view.findViewById(R.id.tvDialog1Baslik);

        tvDialog1Aciklama.setText(aciklama);
        tvDialog1Baslik.setText(baslik);

        return view;
    }
}
