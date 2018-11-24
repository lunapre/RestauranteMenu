package com.example.usuario.asistencia_15130244;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



    public class Adaptador extends RecyclerView.Adapter<Adaptador.Alumno_AdaptadorViewHold> {  //Para crear el CardView
        private ArrayList<Alumno> alumnoArray;

        public Adaptador(ArrayList<Alumno> alumno) { //CONSTRUCTOR
            this.alumnoArray = alumno;

        }

        @NonNull
        @Override
        public Alumno_AdaptadorViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //CREAR LAS VISTAS, LOS VIEW HOLDERS
            View v = LayoutInflater.from(
                    viewGroup.getContext()).inflate(
                    R.layout.alumno_profile,
                    viewGroup,
                    false);
            return new Alumno_AdaptadorViewHold(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final  Alumno_AdaptadorViewHold a_adapterViewHold, final int i) { //ASIGNAR ELEMENTOS DE ALUMNO A ELEMENTOS DE PANTALLA
            final Alumno alumno = alumnoArray.get(i);
            Boolean asis=true;
            a_adapterViewHold.nombre.setText(alumno.getNombre());
            a_adapterViewHold.matricula.setText(alumno.getMatricula());
            a_adapterViewHold.foto.setImageResource(alumno.getFoto());
            if(alumno.getAsistencia()==0){
                asis=false;
            }
            a_adapterViewHold.asistencia.setChecked(asis); // DEPENDIENDO DEL NUMERO GUARDADO EN ASISTENCIA ES 1 O 0

            a_adapterViewHold.asistencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (a_adapterViewHold.asistencia.isChecked()){
                       alumno.setAsistencia(1);
                   }else{
                       alumno.setAsistencia(0);
                   }
                }
            });


        }

        @Override
        public int getItemCount() {
            return alumnoArray.size();
        }

        public class Alumno_AdaptadorViewHold extends RecyclerView.ViewHolder {
            private ImageView foto;
            private TextView nombre;
            private TextView matricula;
            private CheckBox asistencia;

            public Alumno_AdaptadorViewHold(@NonNull View itemView) { //SE ASIGNAN LAS REFERENCIAS A LOS ELEMENTOS DEL VIEW
                super(itemView);
                foto = itemView.findViewById(R.id.iv_foto);
                nombre = itemView.findViewById(R.id.tv_nombre);
                matricula = itemView.findViewById(R.id.tv_matricula);
                asistencia = itemView.findViewById(R.id.cb_asistencia);

                //foto.setOnClickListener(new View.OnClickListener( //Le das click a la foto hace la acción en SnackBar
                //itemView.setOnClickListener(new View.OnClickListener() { //Lo hace en donde sea que le des click en la tarjeta en SnackBar

            }

        }


    }
