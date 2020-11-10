package py.com.misgruposv01.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.adapter.TemaAdapter;
import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class ListarTemasActivity extends ListActivity {
    private String tag = "AppConoceme";
    private ListView listview;
    private ArrayList<String> names;
    private ArrayList<String> fechas;
    private TextView nombreTema;
    private String codigo_materia;
    private int CI_usuario;
    private Materia unaMateria;
    private int idMateria = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarTemasActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_temas);

        //********************************RECIBIR ID MATERIA*****************************************
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            idMateria = extras.getInt("posicionMateria");
            Log.i(tag, "codigoMateria EN LISTAR TEMAS: " + idMateria);
        }

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extrasCI = getIntent().getExtras();
        if (extrasCI != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }

        //********************************LISTVIEW*****************************************
        ArrayList<Tema> temas = new ArrayList<>();

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
        Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL
        unaMateria = unUsuario.getMaterias().get(idMateria);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unaMateria.getNombre()); //CONTROL
        temas = unaMateria.getTemas(); //obtener los temas de la materia

        //IF TEMAS ES NULL ?
        if (unaMateria.getTemas() == null) {
            Log.i(tag, "NO EXISTEN TEMAS"); //CONTROL
            Toast.makeText(this, "No existen temas para esta Materia", Toast.LENGTH_SHORT).show();
        } else {
            Log.i(tag, "SIII EXISTEN TEMAS"); //CONTROL
            Log.i(tag, "Temas size: " + unaMateria.getTemas().size()); //CONTROL
            Log.d(tag, "Cantidad de temas: " + temas.size()); //CONTROL
            Log.i(tag, "TEMAS: " + unaMateria.getTemas()); //CONTROL
            setListAdapter(new TemaAdapter(this, temas)); //llamar adpatador de Temas
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position + ". Id: " + id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MenuTemaPrincipalActivity.class);

        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionTema", Integer.parseInt("" + position));

        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Tema: " + position); //CONTROL

        startActivity(i);
    }

//        //Evento Click
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(ListarTemasActivity.this, "Has pulsado: " + names.get(position), Toast.LENGTH_LONG).show();
//            }
//        });
//        TemaAdapter myAdapter = new TemaAdapter(this, R.layout.activity_list_item, names, fechas);
//        listview.setAdapter(myAdapter);
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public void lanzarVistaRegistrarTema(View view) {
        //VER
        Intent i = new Intent(this, RegistrarTemaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

}
