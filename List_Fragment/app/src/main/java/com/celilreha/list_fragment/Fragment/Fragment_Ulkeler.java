package com.celilreha.list_fragment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.celilreha.list_fragment.R;

import java.util.ArrayList;

public class Fragment_Ulkeler extends ListFragment implements AdapterView.OnItemClickListener {

    ArrayList<String> ulkeler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment1,container,false);
        ulkeler = new ArrayList<>();
        ulkeler.add("Türkiye");
        ulkeler.add("Fransa");
        ulkeler.add("Amerika");
        ulkeler.add("Almanya");
        ulkeler.add("Yunanistan");
        ulkeler.add("İspanya");

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,ulkeler);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(),ulkeler.get(position),Toast.LENGTH_SHORT).show();
    }
}
