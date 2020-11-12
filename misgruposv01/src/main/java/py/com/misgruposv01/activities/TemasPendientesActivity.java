package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.TemaPendienteAdapter;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class TemasPendientesActivity extends ListActivity {
    private String tag = "AppConoceme";
    TabHost TbH;
    private int CI_usuario = -1;
    private Tema unTema;
    private Usuario unUsuario;
    private Materia unaMateria;
    private ArrayList<Materia> materias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en TemasPendientesActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas_pendientes);

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
        spec.setContent(R.id.ejemplo1);
        spec.setIndicator("MATERIAS");
        pestanha.addTab(spec);

        //Pestaña 2
        spec = pestanha.newTabSpec("Pestaña 2");
        spec.setContent(R.id.ejemplo2);
        spec.setIndicator("PENDIENTES");
        pestanha.addTab(spec);

        //Pestaña 3
        spec = pestanha.newTabSpec("Pestaña 3");
        spec.setContent(R.id.ejemplo3);
        spec.setIndicator("PERFIL");
        pestanha.addTab(spec);

        pestanha.setCurrentTab(1);

        pestanha.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);

            }
        });

        //********************************LISTVIEW*****************************************

        ArrayList<Tema> temas = new ArrayList<>();
        ArrayList<Tema> temasPendientes = new ArrayList<>();
        ArrayList<String> temasPendientesS = new ArrayList<String>();

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
        Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL
        Log.i(tag, "MATERIAS SIZE"+ unUsuario.materias.size()); //CONTROL

        for (int i = 0; i < unUsuario.materias.size(); i++) {
            Log.i(tag, "ENTRA AL FOR DE MATERIAS"); //CONTROL
            unaMateria = unUsuario.materias.get(i);
            Log.i(tag, "MATERIA:" + unaMateria.getNombre()); //CONTROL
            temas = unaMateria.getTemas();
            for (int ii = 0; ii < temas.size(); ii++) {
                Log.i(tag, "ENTRA AL FOR DE TEMAS"); //CONTROL
                Tema unTema = temas.get(ii);
                Log.i(tag, "TEMA:" + unTema.getNombre()); //CONTROL
                ArrayList<Item> items = unTema.getItems();
                for (int iii = 0; iii < items.size(); iii++) {
                    Log.i(tag, "ENTRA AL FOR DE ITEMS"); //CONTROL
                    Item unItem = items.get(iii);
                    Log.i(tag, "ITEM:" + unItem.getCodigo()); //CONTROL
                    if (unItem.isAprendido() == false) {
                        Log.i(tag, "ENNTRA AL IF DEL ITEM"); //CONTROL
                        Log.i(tag, "OJO:" + unItem.isAprendido()); //CONTROL
                        temasPendientes.add(unTema);

//                        String[] temasPendientesS = new String[];
//                        String temaPendiente = unTema.getNombre();
//                        temasPendientesS.add(temaPendiente);
                    }
                }
            }
        }
        Log.i(tag, "temas pendientes SIZE: "+ temasPendientesS.size()); //CONTROL
        Log.i(tag, "temas pendientes: "+ temasPendientesS); //CONTROL



//        Log.i(tag, "Cantidad de temas: " + temas.size()); //CONTROL
        setListAdapter(new TemaPendienteAdapter(this, temasPendientes)); //llamar adpatador de Temas

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
