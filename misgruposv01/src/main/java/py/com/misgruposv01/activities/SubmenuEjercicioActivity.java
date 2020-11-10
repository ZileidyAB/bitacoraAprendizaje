package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import py.com.misgruposv01.R;

public class SubmenuEjercicioActivity extends Activity {
    private String tag = "SubmenuEjercicio";
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en SubmenuEjercicioActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_ejercicio);

        //********************************RECIBIR ID MATERIA*****************************************
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            idMateria = extras.getInt("posicionSeleccionadaMateria");
            Log.i(tag, "Id Materia: " + idMateria);
        }

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extrasCI = getIntent().getExtras();
        if (extrasCI != null) {
            CI_usuario = extrasCI.getInt("CI_usuario", -1);
            Log.i(tag, "CI Usuario: " + CI_usuario);
        }

        //********************************RECIBIR ID TEMA*****************************************
        Bundle extrasTema = getIntent().getExtras();
        if (extrasTema != null) {
            idTema = extrasTema.getInt("posicionSeleccionadaTema", -1);
            Log.i(tag, "Posicion de tema: " + idTema);
        }

    }

//    public void lanzarVistaSubmenuEjercicio(View view) {
//        Intent i = new Intent(this, ListarEjercicioActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }
//
//    public void lanzarVistaRegistrarEjercicio(View view) {
//        Intent i = new Intent(this, RegistrarEjercicioActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }
}
