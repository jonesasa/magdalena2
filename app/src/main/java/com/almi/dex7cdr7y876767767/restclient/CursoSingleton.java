package com.almi.dex7cdr7y876767767.restclient;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CursoSingleton {
    private static CursoSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    public CursoSingleton(Context context) {
        CursoSingleton.context = context;
        this.requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized CursoSingleton getInstance(Context context) {
        if (singleton == null){
            singleton = new CursoSingleton(context);
        }
        return singleton;
    }

    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}