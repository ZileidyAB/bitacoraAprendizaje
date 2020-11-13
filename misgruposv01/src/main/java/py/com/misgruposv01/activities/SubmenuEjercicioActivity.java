package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class SubmenuEjercicioActivity extends Activity {
    private String tag = "SubmenuEjercicio";
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;
    private Materia unaMateria;
    private Tema unTema;

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

        //********************************ENVIAR TITULO DEL TEMA*****************************************
        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
        Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL

        unaMateria = unUsuario.getMaterias().get(idMateria);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unaMateria.getNombre()); //CONTROL

        unTema = unaMateria.getTemas().get(idTema);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unTema.getNombre()); //CONTROL

        TextView tituloTema = (TextView) findViewById(R.id.titulo_subtema_ejercicio);
        tituloTema.setText("Tema: " + unTema.getNombre());
    }

    public void lanzarVistaListarEjercicio(View view) {
        Intent i = new Intent(this, ListarEjercicioActivity.class);
        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionSeleccionadaTema", Integer.parseInt("" + idTema));

        Log.d(tag, "*************************MANDAR DATOS A LISTAR EJERCICIO*************************"); //CONTROL
        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Seleccionada Tema: " + idTema); //CONTROL
        startActivity(i);
    }

    public void lanzarVistaRegistrarEjercicio(View view) {
        Intent i = new Intent(this, RegistrarEjercicioActivity.class);

        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionTema", Integer.parseInt("" + idTema));

        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Tema: " + idTema); //CONTROL

        startActivity(i);
    }
}
