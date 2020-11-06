package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.datos.Materia;


public class ListarMateriaActivity extends ListActivity {
    private String tag = "AppConoceme";
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarMateriaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_materia);

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

        pestanha.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
            }
        });

        //********************************LISTVIEW*****************************************
        ArrayList<Materia> materias = Materia.getMaterias();
        Log.d(tag, "Cantidad de materias: "+materias.size());

        setListAdapter (new MateriaAdapter(this, materias));

    }
    public void lanzarVistaRegistrarMateria(View view){
        //VER
        Intent i = new Intent(this, RegistrarMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaListarTemas (View view){
        //VER
        Intent i = new Intent(this, ListarTemasActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



