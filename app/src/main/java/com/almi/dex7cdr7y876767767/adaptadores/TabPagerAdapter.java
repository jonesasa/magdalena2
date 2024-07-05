package com.almi.dex7cdr7y876767767.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.almi.dex7cdr7y876767767.fragmentostabs.FragmentoExterior;
import com.almi.dex7cdr7y876767767.fragmentostabs.FragmentoInterior;



public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentoInterior();
            case 1:
                return new FragmentoExterior();

            default:
                throw new IllegalStateException("Unexpected position " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

