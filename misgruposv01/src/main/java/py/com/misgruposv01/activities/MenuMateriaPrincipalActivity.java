package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import py.com.misgruposv01.R;

public class MenuMateriaPrincipalActivity extends Activity {
    private String tag = "AppConoceme";
    private int CI_usuario = -1;
//    private Usuario unUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en MenuMateriaPrincipalActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materias_principal);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario: " + CI_usuario);
        }
//        verificacionUsuario();
    }

//    public void verificacionUsuario() {
//        if ( CI_usuario < 0 || CI_usuario > (Usuario.usuarios.size()-1)) {
//            Log.i(tag, "El usuario no existe ");
//            Toast.makeText( this, "El usuario no existe", Toast.LENGTH_SHORT);
//            finish();
//            return;
//        }else{
//            Log.i(tag, "El usuario SI existe. Continua la operacion");
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public void lanzarVistaListarMateria(View view) {
        Intent i = new Intent(this, ListarMateriaActivity.class);
        i.putExtra("CI_usuario", Integer.parseInt(""+CI_usuario));
        startActivity(i);
    }

    public void lanzarVistaTemasPendientes(View view) {
        Intent i = new Intent(this, TemasPendientesActivity.class);
        i.putExtra("CI_usuario", Integer.parseInt(""+CI_usuario));
        startActivity(i);
    }

    public void lanzarVistaVerPerfil(View view) {
        //VER
        Intent i = new Intent(this, VerPerfilActivity.class);
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario));
        startActivity(i);
    }
}
