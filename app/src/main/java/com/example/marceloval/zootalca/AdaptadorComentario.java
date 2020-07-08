package com.example.marceloval.zootalca;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorComentario extends RecyclerView.Adapter<AdaptadorComentario.ComentarioHolder> {

    List<Comentario> list;
    Activity activity;
    int resource;

    public AdaptadorComentario(List<Comentario> list, Activity activity, int resource){
        this.list = list;
        this.activity = activity;
        this.resource = resource;
    }

    @Override
    public ComentarioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,
                parent, false);
        return new ComentarioHolder(view);
    }

    @Override
    public void onBindViewHolder(ComentarioHolder holder, int position) {
        try{
            Comentario com = list.get(position);
            holder.nombre.setText(com.nombre.toUpperCase());
            holder.comentario.setText(com.comentario);
            holder.circulo.setText(""+com.nombre.toUpperCase().charAt(0));
            holder.id = String.valueOf(com.id);
        }catch(Exception e){
            Comentario com = list.get(position);
            holder.nombre.setText(" ");
            holder.comentario.setText(" ");
            holder.circulo.setText(" ");
            holder.id = String.valueOf(com.id);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ComentarioHolder extends RecyclerView.ViewHolder{

        private TextView comentario,nombre,circulo;
        String id;

        public ComentarioHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.item_nombre_comentario);
            comentario = itemView.findViewById(R.id.item_comentario);
            circulo = itemView.findViewById(R.id.item_circulo);


        }
    }


}
