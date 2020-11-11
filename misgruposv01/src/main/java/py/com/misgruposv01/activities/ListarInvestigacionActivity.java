package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.EjercicioAdapter;
import py.com.misgruposv01.adapter.InvestigacionAdapter;
import py.com.misgruposv01.adapter.ItemAdapter;
import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.adapter.TemaAdapter;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class ListarInvestigacionActivity extends ListActivity {
    private String tag = "ListarInvestigacionActivity";
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;
    private Materia unaMateria;
    private Tema unTema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarInvestigacionActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_investigacion);

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

        //********************************LISTVIEW*****************************************
        ArrayList<Investigacion> investigaciones = Investigacion.getInvestigaciones();
//        ArrayList<Ejercicio> ejercicios = new ArrayList<>();

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
        Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL

        unaMateria = unUsuario.getMaterias().get(idMateria);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unaMateria.getNombre()); //CONTROL

        unTema = unaMateria.getTemas().get(idTema);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unTema.getNombre()); //CONTROL

        //ejerciciossssssssssssssssssssss
        investigaciones = unTema.getInvestigaciones(); //obtener los temas de la materia

        if (unTema.getInvestigaciones() == null) {
            Log.i(tag, "NO EXISTEN INVESTIGACIONES"); //CONTROL
            Toast.makeText(this, "No existen Investigaciones dentro de este Tema", Toast.LENGTH_SHORT).show();
        } else {
            Log.i(tag, "Investigaciones size: " + unTema.getInvestigaciones().size()); //CONTROL
            Log.d(tag, "Cantidad de investigaciones: "+investigaciones.size());
            Log.i(tag, "INVESTIGACIONES: " + unTema.getInvestigaciones()); //CONTROL
            setListAdapter(new InvestigacionAdapter(this, investigaciones)); //llamar al adaptador de Materia
        }
    }
}
