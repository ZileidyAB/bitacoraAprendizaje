package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Usuario;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class RestablecerContrasenhaActivity extends Activity {
    private String tag = "AppConoceme";
    private EditText correoElectronico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en RestablecerContrasenhaActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasenha);
        this.correoElectronico = (EditText) findViewById(R.id.correo);
    }

    public void restablecerContrasenha (View view){
        String correo = this.correoElectronico.getText().toString();
        Log.i(tag, "Correo electronico: " + correo);
        if (correo.equals("")) {
            Log.i(tag, "Debe rellenar TODOS los campos");
            Toast.makeText(this, "Debe rellenar TODOS los campos", Toast.LENGTH_SHORT).show();
        }else{
            boolean estaComprobado = Usuario.comprobarCorreo(correo);
            if (estaComprobado) {
                Log.i(TAG, "Se ha enviado un link de recuperacion a su correo electrónico");
                Toast.makeText(this, "Se ha enviado un link de recuperacion a su correo electrónico", Toast.LENGTH_LONG).show();
                //TODO: Conectar con correo electronico
                finish();
            } else {
                Log.i(TAG, "Correo incorrecto");
                Toast.makeText(this, "Correo incorrecto", Toast.LENGTH_SHORT).show();
//               desplegarMensajeCredencialesIncorrectas();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
