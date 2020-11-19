package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inicioUsuario extends AppCompatActivity {
    TextView j_tv_nombreUsuario;
    Button j_btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);

        getActionBar().hide();
        j_tv_nombreUsuario = findViewById(R.id.tvusuario);
        j_btn_regresar = findViewById(R.id.btnRegresar);

        String nombre;
        nombre=getIntent().getStringExtra("usuario");
        j_tv_nombreUsuario.setText(nombre);
    }

    public void regresar(View v)
    {
        Intent intent_main=new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }
}