package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import py.com.misgruposv01.R;

public class MenuPrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void lanzarVistaAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaCrearCuenta(View view){
        //VER
        Intent i = new Intent(this, CrearCuentaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaIniciarSesion(View view){
        //VER
        Intent i = new Intent(this, IniciarSesionActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
}
