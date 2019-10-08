package com.example.cc1.miaudiolibros;

/**
 * Created by cc1 on 27/09/2019.
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class AdaptadorLibros extends RecyclerView.Adapter<AdaptadorLibros.ViewHolder> {

    private LayoutInflater inflater;
    protected Vector<Libro> vectorLibros;
    private Context context;

    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;


    public AdaptadorLibros(Context context, Vector<Libro> vectorLibros) {
        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vectorLibros = vectorLibros;
        this.context = context;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Este método devuelve una vista de un elemento sin personalizar.
        View view = inflater.inflate(R.layout.elemento_selector, null);
        view.setOnClickListener(onClickListener);
        view.setOnLongClickListener(onLongClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Personaliza un elemento de tipo ViewHolder segun su poscisión.
        Libro libro = vectorLibros.elementAt(position);
        holder.portada.setImageResource(libro.recursoImagen);
        holder.titulo.setText(libro.titulo);
    }

    @Override
    public int getItemCount() {
        return vectorLibros.size();
    }
    // Numero de elementos a visualizar.

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView portada;
        public TextView titulo;

        public ViewHolder(View itemView) {
            super(itemView);
            portada = itemView.findViewById(R.id.portada);
            portada.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            titulo = itemView.findViewById(R.id.titulo);
        }
    }
}
