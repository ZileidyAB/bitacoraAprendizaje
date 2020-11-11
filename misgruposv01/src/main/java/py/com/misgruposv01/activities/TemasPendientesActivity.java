package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;

import py.com.misgruposv01.R;

public class TemasPendientesActivity extends Activity {
    private String tag = "AppConoceme";
    TabHost TbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en TemasPendientesActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas_pendientes);

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
