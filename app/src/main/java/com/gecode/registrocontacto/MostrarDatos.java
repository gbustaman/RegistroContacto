package com.gecode.registrocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    Button editarDatos;

    private TextView resnombre;
    private TextView restelefono;
    private TextView resemail;
    private TextView resdescripcion;
    private TextView resfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        editarDatos = (Button) findViewById(R.id.btneditar);
        Bundle parametros = getIntent().getExtras();

        String nombre      = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono    = parametros.getString(getResources().getString(R.string.ptelefono));
        String email       = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String fecha       = parametros.getString(getResources().getString(R.string.pfecha));

        resnombre       = (TextView) findViewById(R.id.tvNombre);
        restelefono     = (TextView) findViewById(R.id.tvTelefono);
        resemail        = (TextView) findViewById(R.id.tvEmail);
        resdescripcion  = (TextView) findViewById(R.id.tvDescripcion);
        resfecha        = (TextView) findViewById(R.id.tvFecha);

        resfecha.setText(fecha);
        resnombre.setText(nombre);
        restelefono.setText(telefono);
        resemail.setText(email);
        resdescripcion.setText(descripcion);

        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editarDatos = new Intent(MostrarDatos.this, MainActivity.class);
                finish();
            }
        });
    }
}
