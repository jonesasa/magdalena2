package com.almi.dex7cdr7y876767767.adaptadores;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.almi.dex7cdr7y876767767.R;
import com.almi.dex7cdr7y876767767.datos.Cursos;
import com.almi.dex7cdr7y876767767.datos.Fotos;
import com.almi.dex7cdr7y876767767.restclient.CursoSingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorFotos extends BaseAdapter {
    private Context context;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    private String url_base = "https://dockeradanmarkand.duckdns.org/ws";
    private ArrayList<Fotos> fotos=new ArrayList<Fotos>();

    public AdaptadorFotos(Context context, ArrayList<Fotos> fotos) {
        this.context = context;
        this.fotos = fotos;
    }

    @Override
    public int getCount() {
        return fotos.size();
    }

    @Override
    public Object getItem(int position) {
        return fotos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.item_foto, null);
        ImageView imagen = item.findViewById(R.id.imagenAdapter);
        Picasso.with(context).load(fotos.get(position).getFotos()).into(imagen);
        TextView texto= item.findViewById(R.id.tituloAdapter);
        texto.setText(fotos.get(position).getTexto());
        //generamos el listener para la imagen
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_image);

                // Obtener la referencia del ImageView en el diálogo
                ImageView imageViewDialog = dialog.findViewById(R.id.image_view_dialog);

                // Obtener la referencia del TextView en el diálogo
                TextView textViewDialog = dialog.findViewById(R.id.text_view_dialog);

                // Establecer la imagen en el ImageView del diálogo
                Picasso.with(context).load(fotos.get(position).getFotos()).into(imageViewDialog);

                // Establecer el texto en el TextView del diálogo
                textViewDialog.setText(fotos.get(position).getTexto());

                // Mostrar el diálogo
                dialog.show();
            }
        });


        return item;
    }


    public AdaptadorFotos(@NonNull Context context, String ruta) {
        this.context = context;
        fotos=new ArrayList<Fotos>();
        //el constructor se encarga de gestionar la peticiones
        //Por lo tanto creamos una nueva cola de peticiones
        requestQueue = Volley.newRequestQueue(context);
        //Llamamos a nuestro servicio para pedir datos

        jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url_base + ruta,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Convertimos los datos del servicio a una lista de alumnos
                        try {
                            fotos=convertirJSON(response);
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

    private ArrayList<Fotos> convertirJSON(JSONArray jsonArray) throws JSONException {
        //Generamos una lista vacia
        ArrayList<Fotos> fotos = new ArrayList<Fotos>();
        //Obtenemos todos los datos del array de json obtenido del servicio
        for (int i = 0; i < jsonArray.length(); i++){
            //obtenemos el objeto de la posición i
            JSONObject foto = jsonArray.getJSONObject(i);
            Fotos nuevaFoto = new Fotos(foto.getString("fotos"),foto.getString("texto"));
            fotos.add(nuevaFoto);
        }
        return fotos;
    }


}
