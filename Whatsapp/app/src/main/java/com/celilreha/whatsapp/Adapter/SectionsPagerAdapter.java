package com.celilreha.whatsapp.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.celilreha.whatsapp.Fragment.FragmentAramalar;
import com.celilreha.whatsapp.Fragment.FragmentDurumlar;
import com.celilreha.whatsapp.Fragment.FragmentSohbetler;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    FragmentManager fm;

    public SectionsPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context=context;
        this.fm=fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        switch (position){
            case 0:
                fragment = new FragmentSohbetler();
                break;
            case 1:
                fragment = new FragmentDurumlar();
                break;
            case 2:
                fragment = new FragmentAramalar();
                break;
            default:
                fragment = new FragmentSohbetler();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        if(position==0){
            title = "Sohbetler";
        }else if(position==1){
            title = "Durumlar";
        }else if(position==2){
            title = "Aramalar";
        }
        return title;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
