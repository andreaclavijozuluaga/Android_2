package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private EditText jetUsuario, jetPassword;
    private Button jbtnInicio, jbtnRegistro, jbtnmostrar, jbtnlimpiar;
    private ArrayList<Usuario> listaUsuario;
    Usuario UsuarioCls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        jetUsuario = (EditText) findViewById(R.id.etUsuario);
        jetPassword = (EditText) findViewById(R.id.etPassword);
        jbtnInicio = (Button) findViewById(R.id.btnIngreso);
        jbtnRegistro = (Button) findViewById(R.id.btnRegistro);
        jbtnmostrar = (Button) findViewById(R.id.btnMostrar);
        jbtnlimpiar = (Button) findViewById(R.id.btnLimpiar);
        listaUsuario = (ArrayList<Usuario>) getIntent().getSerializableExtra("datos");
    }

    /*
    private void llenarUsuarios() {
        listaUsuario = new ArrayList<Usuario>();
        listaUsuario.add(new Usuario("Rosseanne", "Park", "RoseBlackPink", "blackpink23"));
        listaUsuario.add(new Usuario("Jennie", "Kim", "JenniBlackPink", "blackpink24"));
        listaUsuario.add(new Usuario("Lalalisa", "Monoban", "LisaBlackPink", "blackpink23"));
        listaUsuario.add(new Usuario("Jisoo", "Kim", "JisoooBlackPink", "blackpink25"));

        String usuarioNuevoNombre = getIntent().getStringExtra("nombre");
        String usuarioNuevoApellido = getIntent().getStringExtra("apellido");
        String usuarioNuevoUsuario = getIntent().getStringExtra("usuario");
        String usuarioNuevoContrasena = getIntent().getStringExtra("contrasena");

        if (usuarioNuevoNombre != null) {
            Usuario nuevoUsuario = new Usuario(usuarioNuevoNombre, usuarioNuevoApellido, usuarioNuevoUsuario, usuarioNuevoContrasena);
            listaUsuario.add(nuevoUsuario);

            Toast.makeText(this, "Usuario " + nuevoUsuario.getNombre() + " agregado", Toast.LENGTH_SHORT);
        }
    }
     */

    public void IniciarSesion(View v) {
       String user, password;
       user = jetUsuario.getText().toString();
       password = jetPassword.getText().toString();

       if (user.isEmpty() || password.isEmpty()) {
           Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
           jetUsuario.requestFocus();
       } else {
           if(getIntent().getSerializableExtra("datos") == null) {
               Toast.makeText(this, "No se encontro un registro", Toast.LENGTH_LONG).show();
           } else {
               int pos = 0, s = 0;
               while (pos < listaUsuario.size() && s == 0) {
                   UsuarioCls = listaUsuario.get(pos);
                   if (UsuarioCls.equals(UsuarioCls.getUsuario()) && password.equals(UsuarioCls.getPassword())) {
                       s=1;
                   } else {
                       pos++;
                   } if (s == 0)
                       Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                   else
                   {
                       String dato;
                       Intent intent_inicio = new Intent(this, inicioUsuario.class);
                       dato = jetUsuario.getText().toString();
                       startActivity(intent_inicio);
                   }
               }
           }
       }
    }

    /*
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnIngreso) {
            IniciarSesion();
        }
    }
    */

    public void crearUsuario(View v){
        Intent intCrearUsuarios = new Intent(this, CreateUsuarioActivity.class);
        startActivity(intCrearUsuarios);
    }

    public void verUsuario(View v) {
        Intent intent_verUsuario = new Intent (this, verUsuario.class);
        String User;
        User = jetUsuario.getText().toString();
        intent_verUsuario.putExtra("datos", UsuarioCls);
        intent_verUsuario.putExtra("usuario", User);
        startActivity(intent_verUsuario);
    }
}