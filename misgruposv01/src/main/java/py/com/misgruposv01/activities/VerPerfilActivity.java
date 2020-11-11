package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;

import py.com.misgruposv01.R;

public class VerPerfilActivity extends Activity {
    private String tag = "AppConoceme";
    TabHost TbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en VerPerfilActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);

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

        pestanha.setCurrentTab(2);

        pestanha.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);

            }
        });
    }

    public void lanzarVistaMenuMateriaPrincipal(View view) {
        Log.i(tag, "ENTRA A MENU TEMA PRINCIPAL");
        Intent i = new Intent(this, MenuMateriaPrincipalActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
