package com.almi.dex7cdr7y876767767.adaptadores;



import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.datos.Cursos;
import com.almi.dex7cdr7y876767767.restclient.CursoSingleton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListLanbideAdapter extends BaseAdapter {
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    private String url_base = "https://dockeradanmarkand.duckdns.org/ws";
    private List<Cursos> items=new ArrayList<>();

    private Context context;
    public ListLanbideAdapter(@NonNull Context context) {
        this.context = context;
        //el constructor se encarga de gestionar la peticiones
        //Por lo tanto creamos una nueva cola de peticiones
        requestQueue = Volley.newRequestQueue(context);
        //Llamamos a nuestro servicio para pedir datos

        jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url_base + "/cursos",null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Convertimos los datos del servicio a una lista de alumnos
                        try {
                            items=convertirJSON(response);
                            //Notificamos al adaptador que el array está lleno
                            notifyDataSetChanged();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //Añadimos la petición a la cola
        CursoSingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
    }

    private List<Cursos> convertirJSON(JSONArray jsonArray) throws JSONException {
        //Generamos una lista vacia
        List<Cursos> alumnos = new ArrayList<>();
        //Obtenemos todos los datos del array de json obtenido del servicio
        for (int i = 0; i < jsonArray.length(); i++){
            //obtenemos el objeto de la posición i
            JSONObject alumno = jsonArray.getJSONObject(i);
            Cursos nuevoCurso = new Cursos(alumno.getString("nombre"));
;
            alumnos.add(nuevoCurso);
        }
        return alumnos;
    }

    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
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
        tvCursos.setText(items.get(position).getCursos());
        return vista;
    }
}




