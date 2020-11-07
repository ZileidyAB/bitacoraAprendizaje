package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Usuario;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class IniciarSesionActivity extends Activity {

    private String tag = "AppConoceme";
    private EditText CI;
    private EditText contrasenha;
    private int CI_usuario = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en IniciarSesionActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        this.CI = (EditText) findViewById(R.id.CI);
        this.contrasenha = (EditText) findViewById(R.id.contrasenha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    //Abrir pantalla de restablecer contraseña
    public void lanzarVistaRestablecerContrasenha(View view) {
        Intent i = new Intent(this, RestablecerContrasenhaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    //Abrir pantalla de ver menú de materias
    public void lanzarVistaMenuMateriaPrincipal(View view) {
        Intent i = new Intent(this, MenuMateriaPrincipalActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    //Ingresar
    public void iniciarSesionClick(View view) {
        String CI = this.CI.getText().toString();
        String contrasenha = this.contrasenha.getText().toString();
        Log.i(tag, "Nro CI: " + CI);
        Log.i(tag, "Contraseña: " + contrasenha);

        if (CI.equals("") || contrasenha.equals("")) {
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
            boolean estaComprobado = Usuario.comprobarCredenciales(CI, contrasenha);

            if (estaComprobado) {
                Log.i(TAG, "Credenciales correctas");
                Toast.makeText(this, "Credenciales correctas", Toast.LENGTH_SHORT).show();
//                setUsuarioLogueado();
                Intent intentMenuPricipal = new Intent(this, MenuMateriaPrincipalActivity.class);
                intentMenuPricipal.putExtra("CI_usuario", Integer.parseInt(""+CI));
                startActivity(intentMenuPricipal);
            } else {
                Log.i(TAG, "Las credenciales son incorrectas");
                Toast.makeText(this, "Las credenciales son incorrectas", Toast.LENGTH_SHORT).show();
//               desplegarMensajeCredencialesIncorrectas();
            }
        }

//        private void setUsuarioLogueado() {
//            String CI = this.CI.getText().toString();
//            Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
//        }

//        ArrayList<Usuario> listaUsuarios = Usuario.getUsuarios();
//
//        for (int i = 0; i < listaUsuarios.size(); i++) {
//            Usuario unUsuario = listaUsuarios.get(i);
//
//            if (CI.equals(unUsuario.getCI())) {
//                if (contrasenha.equals(unUsuario.getContrasenha())) {
//                    Log.i(tag, "Usuario logueado");
//                    Toast.makeText(this, "Usuario logueado", Toast.LENGTH_SHORT).show();
//                    Intent intentMenuPrincipal = new Intent(this, MenuMateriaPrincipalActivity.class);
//                    startActivity(intentMenuPrincipal);
//                } else {
//                    Log.i(tag, "Contraseña invalida");
//                    Toast.makeText(this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                Log.i(tag, "");
//            }

    }
}

