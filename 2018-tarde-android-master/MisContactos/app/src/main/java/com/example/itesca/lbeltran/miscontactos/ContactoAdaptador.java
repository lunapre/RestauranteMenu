package com.example.itesca.lbeltran.miscontactos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdaptador extends
        RecyclerView.Adapter<ContactoAdaptador.CA_ViewHolder>{
    private ArrayList<Contacto> contactos;
    private RecyclerViewItemClickListener listener;

    public ContactoAdaptador(ArrayList<Contacto> contactos,
                             RecyclerViewItemClickListener listener) {
        this.contactos = contactos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CA_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(
                viewGroup.getContext()).inflate(
                        R.layout.content_mostrar_contacto,
                        viewGroup,
                        false);
        CA_ViewHolder contactoViewHolder = new CA_ViewHolder(v);
        return contactoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CA_ViewHolder ca_viewHolder, int i) {
        Contacto contacto = contactos.get(i);
        ca_viewHolder.nombre.setText(contacto.getNombre());
        ca_viewHolder.telefono.setText(contacto.getTelefono());
        ca_viewHolder.email.setText(contacto.getEmail());
        ca_viewHolder.grupo.setText(contacto.getGrupo());
        ca_viewHolder.foto.setImageResource(contacto.getFoto());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class CA_ViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView telefono;
        private TextView email;
        private TextView grupo;
        public CA_ViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.image_foto);
            nombre = itemView.findViewById(R.id.tv_nombre);
            telefono = itemView.findViewById(R.id.tv_telefono);
            email = itemView.findViewById(R.id.tv_email);
            grupo = itemView.findViewById(R.id.tv_grupo);
            foto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }

    }
}
