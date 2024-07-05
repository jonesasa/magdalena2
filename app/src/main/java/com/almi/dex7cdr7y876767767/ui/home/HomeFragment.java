package com.almi.dex7cdr7y876767767.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.TransitionInflater;

import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.adaptadores.AdaptadorCursos;
import com.almi.dex7cdr7y876767767.adaptadores.ListLanbideAdapter;
import com.almi.dex7cdr7y876767767.databinding.FragmentHomeBinding;
import com.almi.dex7cdr7y876767767.datos.Cursos;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private Context context;

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Lista de cursos
        ListView lvCursos= view.findViewById(R.id.lvListaCursos);
        //relleando la lista
       /* ArrayList<Cursos> cursos = new ArrayList<Cursos>();
        cursos.add(new Cursos("Dam1"));
        cursos.add(new Cursos("Dam2"));
        cursos.add(new Cursos("Asir1"));
        cursos.add(new Cursos("Asir2"));
        cursos.add(new Cursos("SMR1"));
        cursos.add(new Cursos("SMR2"));
        //creando el adaptador
        AdaptadorCursos adapter = new AdaptadorCursos(context, cursos);
        //asignando el adaptador a la lista*/

        ListLanbideAdapter adapter = new ListLanbideAdapter(context);

        lvCursos.setAdapter(adapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}