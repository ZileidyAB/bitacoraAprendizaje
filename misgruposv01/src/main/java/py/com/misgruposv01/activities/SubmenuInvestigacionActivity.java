package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import py.com.misgruposv01.R;

public class SubmenuInvestigacionActivity extends Activity {
    private String tag = "SubmenuInvestigacion";
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en SubmenuInvestigacionActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_investigacion);

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

    public void lanzarVistaListarInvestigacion(View view) {
        Intent i = new Intent(this, ListarInvestigacionActivity.class);
        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionSeleccionadaTema", Integer.parseInt("" + idTema));

        Log.d(tag, "*************************MANDAR DATOS A LISTAR EJERCICIO*************************"); //CONTROL
        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Seleccionada Tema: " + idTema); //CONTROL
        startActivity(i);
    }

    public void lanzarVistaRegistrarInvestigacion(View view) {
        Intent i = new Intent(this, RegistrarInvestigacionActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
}
