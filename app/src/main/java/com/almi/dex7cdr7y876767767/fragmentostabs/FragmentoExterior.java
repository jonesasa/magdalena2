package com.almi.dex7cdr7y876767767.fragmentostabs;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.adaptadores.AdaptadorFotos;
import com.almi.dex7cdr7y876767767.datos.Fotos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FragmentoExterior extends Fragment {

    private Context context;

    public FragmentoExterior() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_exterior, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gvInterior = view.findViewById(R.id.grid_exterior);
        /*ArrayList<Fotos> fotos=new ArrayList<Fotos>();

        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/13-Charla-sobre-la-discapacidad-en-las-instalaciones-de-Almi-1024x576.jpg","Exterior 1"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg","Exterior 2"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg","Exterior 3"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg","Exterior 4"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg","Exterior 5"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg","Exterior 6"));





        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(getContext(),fotos);*/

        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(context,"/fotos/exterior");

        gvInterior.setAdapter(adaptadorFotos);
}}
