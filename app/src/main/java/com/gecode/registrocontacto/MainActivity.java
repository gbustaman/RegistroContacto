package com.gecode.registrocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    private EditText    nombre;        //nombre completo
    private EditText    telefono;      //numero telefonico
    private EditText    email;         //correo electronico
    private EditText    dContacto;     //descripcion del Contacto
    private DatePicker  dpfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = (EditText) findViewById(R.id.etNombre);
        telefono    = (EditText) findViewById(R.id.etTelefono);
        siguiente   = (Button)   findViewById(R.id.btnSiguiente);
        email       = (EditText) findViewById(R.id.etMail);
        dContacto   = (EditText) findViewById(R.id.etDesripcion);
        dpfecha     = (DatePicker) findViewById(R.id.datePicker);

        siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent (MainActivity.this, MostrarDatos.class);

                siguiente.putExtra(getResources().getString(R.string.pnombre)       ,nombre.getText().toString());
                siguiente.putExtra(getResources().getString(R.string.ptelefono)     ,telefono.getText().toString());
                siguiente.putExtra(getResources().getString(R.string.pemail)        ,email.getText().toString());
                siguiente.putExtra(getResources().getString(R.string.pdescripcion)  ,dContacto.getText().toString());
                siguiente.putExtra(getResources().getString(R.string.pfecha)        ,getFecha());

                startActivity (siguiente);
            }

        });
    }


    public String getFecha() {

        StringBuilder fechaElegida = new StringBuilder();
        fechaElegida.append("Fecha Nacimiento: " + dpfecha.getDayOfMonth() + "/" + dpfecha.getMonth() + "/" + dpfecha.getYear());
        return fechaElegida.toString();

    }
}
