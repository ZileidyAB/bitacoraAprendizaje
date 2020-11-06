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

        TbH = (TabHost) findViewById(R.id.tabHost); //llamar Tabhost
        TbH.setup(); //activar TabHost

        TabHost.TabSpec tab1 = TbH.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = TbH.newTabSpec("tab2");
        TabHost.TabSpec tab3 = TbH.newTabSpec("tab3");

        //Nombre de las pestañas
        tab1.setIndicator("MATERIAS");    //qué queremos que aparezca en las pestañas
        tab1.setContent(R.id.ejemplo1); //definimos el id de cada Tab (pestaña)

        tab2.setIndicator("PENDIENTES");
        tab2.setContent(R.id.ejemplo2);

        tab3.setIndicator("PERFIL");
        tab3.setContent(R.id.ejemplo3);

        TbH.addTab(tab1); //añadimos los tabs ya programados
        TbH.addTab(tab2);
        TbH.addTab(tab3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
