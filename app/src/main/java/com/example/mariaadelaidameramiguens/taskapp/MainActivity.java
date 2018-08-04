package com.example.mariaadelaidameramiguens.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.vista.CategoriaActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.CategoriaListaActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.LogInActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.RegistrarActivity;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static com.example.mariaadelaidameramiguens.taskapp.R.layout.activity_log_in;
import static com.example.mariaadelaidameramiguens.taskapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_log_in);
        try {
            URL gitapi = new URL("https://api.github.com/gists/public");
           HttpsURLConnection connection = (HttpsURLConnection) gitapi.openConnection();
          if ( connection.getResponseCode() > 200 || connection.getResponseCode() < 300 ) {
              InputStream result = connection.getInputStream();
              ByteArrayOutputStream result1 = new ByteArrayOutputStream();
              byte[] buffer = new byte[1024];
              int length;
              while ((length = result.read(buffer)) != -1) {
                  result1.write(buffer,0,length);
              }
              Log.i("API", result1.toString());
          }
        } catch (Exception e ) {

        }
        Usuario usuario = new Usuario();
        usuario.setEmail("mariaadelaidamera@gmail.com");
        usuario.setNombre("Maria Mera");

        Gson g = new Gson();
        String json = g.toJson(usuario);

        Log.i("TAG", json);

        String usuarioString = "{\"email\":\"mariaadelaidamera@gmail.com\", \"nombre\":\"Maria Mera\"}";
//        String usuarioString = "{email:mariaadelaidamera@gmail.com, nombre:Maria Mera}";

        Usuario u  = g.fromJson(usuarioString, Usuario.class);

        Log.i("JSON.nombre", u.getNombre());
        Log.i("JSON.email", u.getEmail());
    }
}
