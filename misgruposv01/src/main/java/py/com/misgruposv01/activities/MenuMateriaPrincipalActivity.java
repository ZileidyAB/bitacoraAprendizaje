package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import py.com.misgruposv01.R;

public class MenuMateriaPrincipalActivity extends Activity {
    private String tag = "AppConoceme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en MenuMateriaPrincipalActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materias_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public void lanzarVistaListarMateria(View view){
        //VER
        Intent i = new Intent(this, ListarMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaTemasPendientes(View view){
        //VER
        Intent i = new Intent(this, TemasPendientesActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaVerPerfil(View view){
        //VER
        Intent i = new Intent(this, VerPerfilActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
}
