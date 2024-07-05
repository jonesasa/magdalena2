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
import com.almi.dex7cdr7y876767767.adaptadores.AdaptadorCursos;
import com.almi.dex7cdr7y876767767.adaptadores.AdaptadorFotos;
import com.almi.dex7cdr7y876767767.datos.Fotos;

import java.util.ArrayList;

public class FragmentoInterior extends Fragment {


    private Context context;

    public FragmentoInterior() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_interior, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gvInterior = view.findViewById(R.id.grid_interior);
       /* ArrayList<Fotos> fotos=new ArrayList<Fotos>();
        fotos.add(new Fotos("https://th.bing.com/th/id/OIP.UCZpW53q3vMF_ZYSPa-ipQFNC7?w=311&h=180&c=7&r=0&o=5&pid=1.7","Interior 1"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/02-Entrada-Almi-1024x576.jpg","Interior 2"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg","Interior 3"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/04-Entrada-Almi-1024x576.jpg","Interior 4"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/06-Aula-Ordenadores-1024x576.jpg","Interior 5"));
        fotos.add(new Fotos("https://almi.eus/wp-content/uploads/2016/09/07-Aula-de-ordenadores-1024x576.jpg","Interior 6"));

        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(getContext(),fotos);*/
        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(context,"/fotos/interior");

        gvInterior.setAdapter(adaptadorFotos);


    }
}
