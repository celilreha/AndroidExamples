package com.celilreha.whatsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.celilreha.whatsapp.R;

public class FragmentSohbetler extends Fragment {
    RecyclerView recyclerViewSohbetler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sohbetler_row,null);
        //recyclerViewSohbetler = view.findViewById(R.id.recyclerViewSohbetler);
        return view;
    }
}
