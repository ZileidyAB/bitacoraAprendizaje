package py.com.misgruposv01.activities;

import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import py.com.misgruposv01.R;

public class MenuTemaPrincipalActivity extends Activity {
    private String tag = "AppConoceme";
    private TextView nombreTema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tema_principal);

        //NO SALE
//        this.nombreTema = (TextView) findViewById(R.id.nombre_tema);
//
//        Bundle parametros = this.getIntent().getExtras();
//        if(parametros !=null){
//            String datos = parametros.getString("datos");
//            nombreTema.setText(datos);
//        }
//
//        Log.i(tag, "Nombre:" + nombreTema); //Ver si trae el nombre
//
//        if (nombreTema.equals("")) {
//            Log.i(tag, "No existe el nombre del tema");
//        } else {
//            TextView nombreElemento = (TextView) findViewById(R.id.titulo_tema);
//            Log.i(tag, "Nombre:" + nombreElemento);
//            nombreElemento.setText(nombreTema);
//        }
    }

//    public void lanzarVistaConocimiento(View view){
//        Intent i = new Intent(this, ConocimientoActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }
//    public void lanzarVistaEjercicio(View view){
//        //VER
//        Intent i = new Intent(this, EjercicioActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }
//    public void lanzarVistaInvestigacion(View view){
//        //VER
//        Intent i = new Intent(this, InvestigacionSesionActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }
public void lanzarVistaItem(View view) {
    Log.i(tag, "ENTRA A MENU TEMA PRINCIPAL");
    Intent i = new Intent(this, ListarItemActivity.class);
    //i.putExtra("id", (long)0);
    startActivity(i);
}
}
