package com.almi.dex7cdr7y876767767.adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.datos.Cursos;

import java.util.ArrayList;

public class AdaptadorCursos extends BaseAdapter {
    private Context context;
    private ArrayList<Cursos> cursos=new ArrayList<Cursos>();

    public AdaptadorCursos(Context context, ArrayList<Cursos> cursos) {
        this.context = context;
        this.cursos = cursos;
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return vistaPersonalizada(position, convertView, parent);
    }
    public View vistaPersonalizada(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.item_curso, null);
        if (position%2==0){
            vista.setBackgroundColor(Color.parseColor("#FF018786"));
        }else{
            vista.setBackgroundColor(Color.parseColor("#cccccc"));
        }

        TextView tvCursos = vista.findViewById(R.id.tvItemNombre);
        tvCursos.setText(cursos.get(position).getCursos());
        return vista;
    }}
