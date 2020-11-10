package py.com.misgruposv01.activities;

import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Materia;

public class MenuTemaPrincipalActivity extends Activity {
    private String tag = "AppConoceme";
    private TextView nombreTema;
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en MenuTemaPrincipalActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tema_principal);

        //********************************RECIBIR ID MATERIA*****************************************
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            idMateria = extras.getInt("posicionSeleccionadaMateria");
            Log.i(tag, "Id Materia: " + idMateria);
        }

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extrasCI = getIntent().getExtras();
        if (extrasCI != null) {
            CI_usuario = extrasCI.getInt("CI_usuario", -1);
            Log.i(tag, "CI Usuario: " + CI_usuario);
        }

        //********************************RECIBIR ID TEMA*****************************************
        Bundle extrasTema = getIntent().getExtras();
        if (extrasTema != null) {
            idTema = extrasTema.getInt("posicionTema", -1);
            Log.i(tag, "Posicion de tema: " + idTema);
        }

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

    public void lanzarVistaSubmenuItem(View view) {
        Intent i = new Intent(this, SubmenuItemActivity.class);

        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionSeleccionadaTema", Integer.parseInt("" + idTema));

        Log.d(tag, "*************************MANDAR DATOS EN MENU TEMA PRINCIPAL ACTIVITY*************************"); //CONTROL
        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Seleccionada Tema: " + idTema); //CONTROL

        startActivity(i);
    }

    public void lanzarVistaSubmenuEjercicio(View view) {
        Intent i = new Intent(this, SubmenuEjercicioActivity.class);

        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionSeleccionadaTema", Integer.parseInt("" + idTema));

        Log.d(tag, "*************************MANDAR DATOS EN MENU TEMA PRINCIPAL ACTIVITY*************************"); //CONTROL
        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Seleccionada Tema: " + idTema); //CONTROL

        startActivity(i);
    }

    public void lanzarVistaSubmenuInvestigacion(View view) {
        Intent i = new Intent(this, SubmenuInvestigacionActivity.class);

        i.putExtra("posicionSeleccionadaMateria", Integer.parseInt("" + idMateria));
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
        i.putExtra("posicionSeleccionadaTema", Integer.parseInt("" + idTema));

        Log.d(tag, "*************************MANDAR DATOS EN MENU TEMA PRINCIPAL ACTIVITY*************************"); //CONTROL
        Log.i(tag, "Posicion Seleccionada Materia" + idMateria); //CONTROL
        Log.d(tag, "CI_usuario" + CI_usuario); //CONTROL
        Log.i(tag, "Posicion Seleccionada Tema: " + idTema); //CONTROL

        startActivity(i);
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
