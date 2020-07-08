package com.example.marceloval.zootalca;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class AdaptadorAnimales extends RecyclerView.Adapter<AdaptadorAnimales.CafeHolder>{

    List<Animales> list;
    Activity activity;
    int resource;

    public AdaptadorAnimales(List<Animales> list, Activity activity, int resource) {
        this.list = list;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public CafeHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,
                parent, false);
        return new CafeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeHolder holder, int i) {
        Animales a = list.get(i);
        holder.nombre.setText(a.nombre);
        holder.foto.setImageResource(a.imagen1);
        holder.id.setText(String.valueOf(a.id));

    }

    @Override
    public int getItemCount() {return list.size(); }

    public class CafeHolder extends RecyclerView.ViewHolder{

        TextView nombre,id;
        ImageView foto;
        RelativeLayout container;

        public CafeHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.item_nombre);
            foto = itemView.findViewById(R.id.item_foto);
            id = itemView.findViewById(R.id.item_id);
            container = itemView.findViewById(R.id.item_container);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(activity, DetalleAnimales.class);
                    i.putExtra("id", id.getText().toString());
                    activity.startActivity(i);
                }
            });


        }
    }

}
