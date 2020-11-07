package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Usuario;


public class ListarMateriaActivity extends ListActivity {
    private String tag = "AppConoceme";
    private int CI_usuario = -1;
    private Usuario unUsuario;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarMateriaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_materia);

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }
//        verificacionUsuario();

//
//    public void verificacionUsuario() {
//        if ( CI_usuario < 0 || CI_usuario > (Usuario.usuarios.size()-1)) {
//            Log.i(tag, "El usuario no existe ");
//            Toast.makeText( this, "El usuario no existe", Toast.LENGTH_SHORT);
//            finish();
//            return;
//        }else{
//            Log.i(tag, "El usuario SI existe. Continua la operacion");
//            //TODO
//        }
//        //todo
//        Usuario unUsuario;
//        ArrayList<Materia> materias;
//        for (int i = 0; i < Usuario.usuarios.size(); i++){
//        for (int i = 0; i<unUsuario.listaMaterias.size(); i++){
//
//
//        }
////
////        unUsuario = Usuario.usuarios.get (CI_usuario);
////        unUsuario = Usuario.
//
//        unGrupo = Grupo.grupos.get( idGrupo );
//
//        nombre = (TextView) findViewById(R.id.id_nombre_grupo_valor);
//        nombre.setText( unGrupo.getNombre() );
//
//        objetivo = (TextView) findViewById(R.id.id_objetivo_grupo_valor);
//        objetivo.setText(unGrupo.getDescripcion());


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
        ArrayList<Materia> materias = new ArrayList<>();
        for (int i = 0; i < GestionBitacora.usuarios.size(); i++){ //recorrer lista de usuarios
            unUsuario = GestionBitacora.getUsuarios().get(i); //obtener usuarios
            Log.i(tag, "USUARIOS: " + GestionBitacora.usuarios);

            String CI_usuario_string= String.valueOf(CI_usuario); //Convertir int CI a String
            Log.i(tag, "CI CONVERTIDO: " + CI_usuario_string);
            Log.i(tag, "CI getID: " + unUsuario.getCI());

            if (CI_usuario_string.equals(unUsuario.getCI())) { //comparar CI que llegó con lo que vamos obteniendo en el array

//                materias = Materia.getMaterias();
                materias = unUsuario.getMaterias();
                Log.i(tag, "Materias size: " + unUsuario.materias.size());
                Log.d(tag, "Cantidad de materias: " + materias.size());

                Log.i(tag, "MATERIAS: " + unUsuario.getMaterias());

//                setListAdapter(new MateriaAdapter(this, materias));
            }else{
                Log.i(tag, "NO ENTRA");
            }
        }
        setListAdapter(new MateriaAdapter(this, materias));
    }


    public void lanzarVistaRegistrarMateria(View view) {
        //VER
        Intent i = new Intent(this, RegistrarMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaListarTemas(View view) {
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



