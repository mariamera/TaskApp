package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mariaadelaidameramiguens.taskapp.MainActivity;
import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.LogInRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.LogInRepositorioImp;
import com.google.gson.Gson;

import java.io.Serializable;

public class LogInActivity extends AppCompatActivity {
    private static final String LOG_TAG = LogInActivity.class.getName();
    private LogInRepositorio logInRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        Button btnRegistrar = findViewById(R.id.regisBtn);
        Button btnLogIn = findViewById(R.id.iniciarBtn);
        final TextView errorMsj =   (TextView) findViewById(R.id.errorMsg);
        final EditText usuarioUsername = (EditText)findViewById(R.id.usuarioLogInText);
        final EditText usuarioContrasena = (EditText) findViewById(R.id.usuarioLogInContrasena);

        logInRepositorio = new LogInRepositorioImp(this);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario =  logInRepositorio.logIn(usuarioUsername.getText().toString(), usuarioContrasena.getText().toString() );
                if(usuario.getId() != null) {
                    Intent intent1 = null;

                    if( usuario.getTipoUsuario() == Usuario.TipoUsuario.TECNICO) {
                         intent1 = new Intent(LogInActivity.this, UsuarioActivity.class);
                    }

                    if (usuario.getTipoUsuario() == Usuario.TipoUsuario.NORMAL) {
                         intent1 = new Intent(LogInActivity.this, UsuarioNormalActivity.class);
                    }

                    DataHolder.getInstance().setData(usuario);
                    intent1.putExtra("usuario", usuario); // pasar parametros para un activity.

                    startActivity(intent1);

                } else {
                        Toast.makeText(LogInActivity.this, "Usuario No Encontrado", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LogInActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });


    }
}
