package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Usuario;

public class CrearCuentaActivity extends Activity {
    private String tag = "AppConoceme";

    EditText editTextCI;
    EditText editTextNombreApellido;
    EditText editTextEmail;
    EditText editTextContrasenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en CrearCuentaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        editTextCI = (EditText) findViewById(R.id.CI);
        editTextNombreApellido = (EditText) findViewById(R.id.nombreApellido);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextContrasenha = (EditText) findViewById(R.id.contrasenha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void registrarUsuario(View boton) {
        String CI = editTextCI.getText().toString();
        String nombreApellido = editTextNombreApellido.getText().toString();
        String email = editTextEmail.getText().toString();
        String contrasenha = editTextContrasenha.getText().toString();

        Log.i(tag, "CI: " + CI);
        Log.i(tag, "Nombre de usuario: " + nombreApellido);
        Log.i(tag, "Email: " + email);
        Log.i(tag, "Contraseña: " + contrasenha);

        if (CI.equals("") || nombreApellido.equals("") || email.equals("") || contrasenha.equals("")) {
            Log.i(tag, "Debe rellenar TODOS los campos");
            Toast.makeText(this, "Debe rellenar TODOS los campos", Toast.LENGTH_SHORT).show();
//            new AlertDialog.Builder(this)
//                    .setTitle("Mensaje de Login")
//                    .setMessage("Debe rellenar TODOS los campos")
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int whichButton) {
//                            dialog.cancel();
//                        }
//                    })
//                    .show();
        } else {

//            ArrayList<Usuario> listaUsuarios1 = Usuario.getUsuarios(); ANTERIOR
            ArrayList<Usuario> listaUsuarios = GestionBitacora.getUsuarios();

            Usuario usuario1 = new Usuario(CI, nombreApellido, email, contrasenha);
            listaUsuarios.add(usuario1);

            Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show();
            //finish();
            Intent i = new Intent( this, MenuMateriaPrincipalActivity.class ) ;
            startActivity( i );
        }
    }
}

