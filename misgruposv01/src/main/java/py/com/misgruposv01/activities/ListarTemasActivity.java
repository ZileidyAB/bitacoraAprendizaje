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
//    private String CI_usuario;
    private int CI_usuario;
    private Materia unaMateria;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarTemasActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_temas);

        //********************************RECIBIR CODIGO MATERIA*****************************************
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            codigo_materia = extras.getString("codigoMateria");
            Log.i(tag, "codigoMateria EN LISTAR TEMAS: " + codigo_materia);
        }
        //********************************RECIBIR CI USUARIO*****************************************
//        Bundle extrasCI = getIntent().getExtras();
//        if (extrasCI != null) {
//            CI_usuario = extras.getString("ci_usuario");
//            Log.i(tag, "CI USUARIO EN LISTAR TEMAS: " + CI_usuario);
//        }
        Bundle extrasCI = getIntent().getExtras();
        if (extrasCI != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }

        //********************************LISTVIEW*****************************************
        ArrayList<Tema> temas = new ArrayList<>();

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI

        for (int i = 0; i < unUsuario.materias.size(); i++) { //recorrer array de materia
            unaMateria = unUsuario.getMaterias().get(i);   //obtener materias
            Log.i(tag, "MATERIAS: " + unUsuario.materias); //CONTROL
            if (codigo_materia.equals(unaMateria.getCodigo())) { //comparar CODIGO que llegó con lo que vamos obteniendo en el array
                temas = unaMateria.getTemas(); //obtener los temas de la materia
                Log.i(tag, "Temas size: " + unaMateria.getTemas().size()); //CONTROL
                Log.d(tag, "Cantidad de temas: " + temas.size()); //CONTROL
                Log.i(tag, "TEMAS: " + unaMateria.getTemas()); //CONTROL
            }else{
                Log.i(tag, "NO ENTRA. NO HAY CODIGO DE MATERIA IGUAL");
            }
        }
      setListAdapter(new TemaAdapter(this, temas)); //llamar adpatador de Temas

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

    public void lanzarVistaMenuTemasPrincipal(View view) {
        Log.i(tag, "ENTRA A MENU TEMA PRINCIPAL");
        Intent i = new Intent(this, MenuTemaPrincipalActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);

//        this.nombreTema = (TextView) findViewById(R.id.nombre_tema);
//        String nombreTema = this.nombreTema.getText().toString();
//        Log.i(tag, "Nombre:" + nombreTema); //Ver si trae el nombre
//
//        if (nombreTema.equals("")) {
//            Log.i(tag, "No existe el nombre del tema");
//        } else {
//            TextView nombreElemento = (TextView) view.findViewById(R.id.titulo_tema);
//            Log.i(tag, "Nombre:" + nombreElemento);
//
//            nombreElemento.setText(nombreTema);
//        }

    }
}
