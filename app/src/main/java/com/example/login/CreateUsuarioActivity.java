package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class CreateUsuarioActivity extends AppCompatActivity {

    EditText j_et_nombre, j_et_apellido, j_et_nombreUsuario, j_et_contrasena, j_et_confirmacion_contrasena;
    Button j_btn_crearU, j_btn_consultar, j_btn_eliminar, j_btn_regresar;
    public static ArrayList<Usuario> listaUsuario;
    Usuario UsuarioCls;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_usuario);
        getActionBar().hide();
        j_et_nombre = (EditText) findViewById(R.id.etNombre);
        j_et_apellido = (EditText) findViewById(R.id.etApellido);
        j_et_nombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        j_et_contrasena  = (EditText) findViewById(R.id.etContrasena);
        j_et_confirmacion_contrasena = (EditText) findViewById(R.id.etConfirmeContrasena);
        j_btn_crearU = (Button) findViewById(R.id.btnCrearU);
        listaUsuario = new ArrayList<Usuario>();
    }

    public void crearUsuario(View v){
        String nombre, apellido, usuario, contrasena, confimacion_contrasena;
        nombre = j_et_nombre.getText().toString();
        apellido = j_et_apellido.getText().toString();
        usuario = j_et_nombreUsuario.getText().toString();
        contrasena = j_et_contrasena.getText().toString();
        confimacion_contrasena = j_et_confirmacion_contrasena.getText().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || confimacion_contrasena.isEmpty()) {
            Toast.makeText(this, "Todos los campos son requeridos",Toast.LENGTH_LONG).show();
            j_et_nombre.requestFocus();
        } else {
            if (!contrasena.equals(confimacion_contrasena)) {
                Toast.makeText(this, "La contraseñas no coinciden", Toast.LENGTH_LONG).show();
                j_et_contrasena.requestFocus();
            } else {
                UsuarioCls = new Usuario(nombre, apellido, usuario, contrasena);
                listaUsuario.add(UsuarioCls);
                Toast.makeText(this, "Usuario creado satisfactoriamente", Toast.LENGTH_SHORT).show();
                despejar_Campos();
            }
        }
    }

    public void despejar_Campos() {
        j_et_nombre.setText("");
        j_et_apellido.setText("");
        j_et_nombreUsuario.setText("");
        j_et_contrasena.setText("");
        j_et_confirmacion_contrasena.setText("");
        j_et_nombre.requestFocus();
    }

    public void despejar(View v) { despejar_Campos();}

    public int consultar() {
        String Usuario;
        pos = 0;
        int s = 0;
        Usuario = j_et_nombreUsuario.getText().toString();
        if (Usuario.isEmpty()) {
            Toast.makeText(this,"El nombre de usuario es requerido para realizar consultas",Toast.LENGTH_LONG).show();
            j_et_nombreUsuario.requestFocus();
        } else {
            while (pos < listaUsuario.size() && s == 0) {
                UsuarioCls = listaUsuario.get(pos);
                if (Usuario.equals(UsuarioCls.getUsuario())) {
                    s = 1;
                } else {
                    pos ++;
                }
            }
            if (s == 0) {
                Toast.makeText(this,"No se encontro la consulta",Toast.LENGTH_LONG).show();
            } else {
                j_et_nombre.setText(UsuarioCls.getNombre());
                j_et_apellido.setText(UsuarioCls.getApellido());
                j_et_nombreUsuario.setText(UsuarioCls.getUsuario());
                j_et_contrasena.setText(UsuarioCls.getPassword());
                j_et_confirmacion_contrasena.setText(UsuarioCls.getPassword());
            }
        }
        return pos;
    }

    public void consultar_p(View v)
    {
        pos=consultar();
    }

    public void modificar(View v) {
        String nombre, apellido, usuario, contrasena, confimacion_contrasena;
        nombre = j_et_nombre.getText().toString();
        apellido = j_et_apellido.getText().toString();
        usuario = j_et_nombreUsuario.getText().toString();
        contrasena = j_et_contrasena.getText().toString();
        confimacion_contrasena = j_et_confirmacion_contrasena.getText().toString();
        if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || confimacion_contrasena.isEmpty())
        {
            Toast.makeText(this,"Todos los campos son obligatorios para modificar",Toast.LENGTH_LONG).show();
            j_et_nombreUsuario.requestFocus();
        } else {
            if (!contrasena.equals(confimacion_contrasena)) {
                Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
                j_et_contrasena.requestFocus();
            } else {
                listaUsuario.get(pos).setNombre(nombre);
                listaUsuario.get(pos).setApellido(apellido);
                listaUsuario.get(pos).setUsuario(usuario);
                listaUsuario.get(pos).setPassword(contrasena);
                despejar_Campos();
            }
        }
    }

    public void regresar(View v) {
        Intent intent_main=new Intent(this,MainActivity.class);
        intent_main.putExtra("datos",listaUsuario);
        startActivity(intent_main);
    }

    public void eliminar(View v) {
        String usuario;
        usuario=j_et_nombreUsuario.getText().toString();
        if (usuario.isEmpty()) {
            Toast.makeText(this,"usuario es requerido ",Toast.LENGTH_LONG).show();
            j_et_nombreUsuario.requestFocus();
        }
        else {
            listaUsuario.remove(pos);
            Toast.makeText(this,"Usuario eliminado",Toast.LENGTH_LONG).show();
            despejar_Campos();
        }
    }
}