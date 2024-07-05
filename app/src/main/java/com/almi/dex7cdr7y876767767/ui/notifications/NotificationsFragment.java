package com.almi.dex7cdr7y876767767.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.transition.TransitionInflater;
import androidx.viewpager2.widget.ViewPager2;

import com.almi.dex7cdr7y876767767.MainActivity;
import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.adaptadores.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class NotificationsFragment extends Fragment {
    private Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_notifications,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //la variable view es la vista que gestiona esta clase java
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new TabPagerAdapter((MainActivity)context));

        String[] pestanias=new String[2];
        pestanias[0]="Interior";
        pestanias[1]="Exterior";

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                {
                    tab.setText(pestanias[position]);
                }
        ).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }


}