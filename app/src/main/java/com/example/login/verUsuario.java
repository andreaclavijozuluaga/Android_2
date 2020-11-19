package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class verUsuario extends AppCompatActivity {

    TextView j_tv_Usuario;
    Button j_btn_regresar;
    ListView j_lv_usuarios;
    ArrayList<Usuario> listaUsuario;
    ArrayAdapter<Usuario> adapterUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuario);

        j_tv_Usuario = findViewById(R.id.tvusuario);
        j_btn_regresar = findViewById(R.id.btnRegresar);
        j_lv_usuarios = findViewById(R.id.lvlista);

        listaUsuario = (ArrayList<Usuario>) getIntent().getSerializableExtra("datos");
        String usuario;
        usuario = getIntent().getStringExtra("usuario");
        j_tv_Usuario.setText(usuario);
        adapterUsuario = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,listaUsuario);
        j_lv_usuarios.setAdapter(adapterUsuario);
    }

    public void regresar(View v)
    {
        Intent intent_main=new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }


}