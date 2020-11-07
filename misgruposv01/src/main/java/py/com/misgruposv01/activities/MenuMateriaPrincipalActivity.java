package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Usuario;

public class MenuMateriaPrincipalActivity extends Activity {
    private String tag = "AppConoceme";
    private int CI_usuario = -1;
    private Usuario unUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en MenuMateriaPrincipalActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materias_principal);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "CI recibido del usuario: " + CI_usuario);
        }
        verificacionUsuario();

    }

    public void verificacionUsuario() {
        if ( CI_usuario < 0 || CI_usuario > (Usuario.usuarios.size()-1)) {
            Log.i(tag, "El usuario no existe ");
            Toast.makeText( this, "El usuario no existe", Toast.LENGTH_SHORT);
            finish();
            return;
        }

        ArrayList<Materia> materias;
        for (int i = 0; i<unUsuario.listaMaterias.size(); i++){

        }
        unUsuario = Usuario.usuarios.get (CI_usuario);
        unUsuario = Usuario.
                
        nombre = (TextView) findViewById(R.id.id_nombre_grupo_valor);
        nombre.setText( unGrupo.getNombre() );

        objetivo = (TextView) findViewById(R.id.id_objetivo_grupo_valor);
        objetivo.setText(unGrupo.getDescripcion());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public void lanzarVistaListarMateria(View view) {
        //VER
        Intent i = new Intent(this, ListarMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaTemasPendientes(View view) {
        //VER
        Intent i = new Intent(this, TemasPendientesActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaVerPerfil(View view) {
        //VER
        Intent i = new Intent(this, VerPerfilActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
}
