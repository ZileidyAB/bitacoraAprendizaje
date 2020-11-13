package py.com.misgruposv01.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Usuario;

public class ListarMateriaActivity extends ListActivity {
    private String tag = "AppConoceme";
    private int CI_usuario = -1;
    private Usuario unUsuario;
    private TextView codigo;
    private String codigoString;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarMateriaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_materia);

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }

        //********************************TABHOST*****************************************
        //Propiedades del control
        TabHost pestanha = (TabHost) findViewById(R.id.tabHost);
        pestanha.setup();

        //Pestaña 1
        TabHost.TabSpec spec = pestanha.newTabSpec("Pestaña 1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("MATERIAS");
        pestanha.addTab(spec);

        //Pestaña 2
        spec = pestanha.newTabSpec("Pestaña 2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("PENDIENTES");
        pestanha.addTab(spec);

        //Pestaña 3
        spec = pestanha.newTabSpec("Pestaña 3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PERFIL");
        pestanha.addTab(spec);

        pestanha.setCurrentTab(0);

        pestanha.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
                //Deben traerse FrameLayout para rellenar los Tabs
//                if (tabId.equals("Pestaña 2")) {
//                    sendMessage1(pestanha);
//                } else  if (tabId.equals("Pestaña 3"))  {
//                    sendMessage2(pestanha);
//                }
            }
        });

        //********************************LISTVIEW*****************************************
        ArrayList<Materia> materias = new ArrayList<>();
        for (int i = 0; i < GestionBitacora.usuarios.size(); i++) { //recorrer lista de usuarios
            unUsuario = GestionBitacora.getUsuarios().get(i); //obtener usuarios
            Log.i(tag, "USUARIOS: " + GestionBitacora.usuarios);

            String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
            Log.i(tag, "CI CONVERTIDO: " + CI_usuario_string);
            Log.i(tag, "CI getID: " + unUsuario.getCI());

            if (CI_usuario_string.equals(unUsuario.getCI())) { //comparar CI que llegó con lo que vamos obteniendo en el array
//                materias = Materia.getMaterias();
                materias = unUsuario.getMaterias(); //Obtener las materias del usuario
                if (unUsuario.getMaterias() == null) {
                    Log.i(tag, "NO EXISTEN MATERIAS"); //CONTROL
                    Toast.makeText(this, "No existen Materias para este usuario", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(tag, "Materias size: " + unUsuario.materias.size()); //CONTROL
                    Log.d(tag, "Cantidad de materias: " + materias.size()); //CONTROL
                    Log.i(tag, "MATERIAS: " + unUsuario.getMaterias()); //CONTROL
                    setListAdapter(new MateriaAdapter(this, materias)); //llamar al adaptador de Materia
                }
            } else {
                Log.i(tag, "NO ENTRA. NO HAY CI IGUAL");
            }
        }
//        setListAdapter(new MateriaAdapter(this, materias)); //llamar al adaptador de Materia
    }

//    public void sendMessage1(View view) {
//        Intent intent = new Intent(this, TemasPendientesActivity.class);
//        intent.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario));
//        startActivity(intent);
//    }
//
//    public void sendMessage2(View view) {
//        Intent i = new Intent(this, VerPerfilActivity.class);
//        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario));
//        startActivity(i);
//    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position + ". Id: " + id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ListarTemasActivity.class);
        i.putExtra("posicionMateria", Integer.parseInt("" + position));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        startActivity(i);
    }

    public void lanzarVistaRegistrarMateria(View view) {
        //VER
        Intent i = new Intent(this, RegistrarMateriaActivity.class);
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



