package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mariaadelaidameramiguens.taskapp.MainActivity;
import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.UsuarioRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.Usuariorepositoriodbimpl;

import java.util.Arrays;

public class RegistrarActivity extends AppCompatActivity {
    private static final String LOG_TAG = "RegistrarActivity";
    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuario;
    private RadioButton radioTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        usuarioRepositorio = new Usuariorepositoriodbimpl(this);

        final EditText emailtxt = (EditText) findViewById(R.id.emailtxt);
        final EditText nombretxt =   (EditText) findViewById(R.id.nombretxt);
        final EditText contrasenatxt =   (EditText) findViewById(R.id.contrasenatxt);
        final TextView errorMsj =   (TextView) findViewById(R.id.errorMsj);
        final EditText confipwtxt =   (EditText) findViewById(R.id.confipwtxt);
        final RadioGroup radioGroup =   (RadioGroup) findViewById(R.id.radioGroup);

        Button btnRegistrar = (Button) findViewById(R.id.registrarBtn);
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(Usuario.validarContrasena(contrasenatxt.getText().toString(),confipwtxt.getText().toString()) ) {

                 usuario = new Usuario();

                 usuario.setEmail(emailtxt.getText().toString());
                 usuario.setNombre(nombretxt.getText().toString());
                 usuario.setContrasena(contrasenatxt.getText().toString());
                 int selectedId = radioGroup.getCheckedRadioButtonId();
                 radioTipoUsuario = (RadioButton) findViewById(selectedId);
                 usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(radioTipoUsuario.getText().toString()));

                if (usuarioRepositorio.buscar(usuario)){
                    Toast.makeText(RegistrarActivity.this, "Email Existe", Toast.LENGTH_LONG).show();
                } else
                if(validarUsuario(usuario)){
                    Toast.makeText(RegistrarActivity.this, "LLenar todos los campos", Toast.LENGTH_LONG).show();

                }
                else {
                    Log.i(LOG_TAG,usuario.toString());
                    usuarioRepositorio.guardar(usuario);
                    goToMainActivity();
                }

             } else {
                 Toast.makeText(RegistrarActivity.this, "Contrasena no machean", Toast.LENGTH_LONG).show();

             }

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainActivity();
            }


        });

    }
    public static boolean validarUsuario(Usuario usuario) {
        Log.i(LOG_TAG,usuario.toString());
        return usuario.getEmail().isEmpty() || usuario.getNombre().isEmpty()  || usuario.getContrasena().isEmpty();
    }

    void goToMainActivity() {
        Intent intent1 = null;

        if( usuario.getTipoUsuario() == Usuario.TipoUsuario.TECNICO) {
            intent1 = new Intent(RegistrarActivity.this, UsuarioActivity.class);
        }
        if (usuario.getTipoUsuario() == Usuario.TipoUsuario.NORMAL) {
            intent1 = new Intent(RegistrarActivity.this, UsuarioNormalActivity.class);
        }
        DataHolder.getInstance().setData(usuario);
        intent1.putExtra("usuario", usuario); // pasar parametros para un activity.
        startActivity(intent1);
    }
}
