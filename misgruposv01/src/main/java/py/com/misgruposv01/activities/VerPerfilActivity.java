package py.com.misgruposv01.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;
import py.com.misgruposv01.utils.NotificationsUtils;
import py.com.misgruposv01.utils.RequestCode;

public class VerPerfilActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    private static final String TAG = "VerPerfilActivity";
    TabHost TbH;
    private static final int PETICION_EDITAR_USUARIO = 1;
    private int CI_usuario = -1;
    private Usuario unUsuario;
    private TextView CI;
    private TextView NombreApellido;
    private TextView Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en VerPerfilActivity.onCreate");
//		int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario: " + CI_usuario);
        }

        actualizarVista();

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

        //********************************Ver datos usuario*****************************************
    }

    public void actualizarVista(){

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI



//        for (int i = 0; i < GestionBitacora.usuarios.size(); i++) { //recorrer lista de usuarios
//            unUsuario = GestionBitacora.getUsuarios().get(i); //obtener usuarios
//            Log.i(tag, "USUARIOS: " + GestionBitacora.usuarios);
//        }

        CI = (TextView) findViewById(R.id.id_numero_ci);
        CI.setText(unUsuario.getCI() );
        NombreApellido = (TextView) findViewById(R.id.id_nombre_apellido_usuario);
        NombreApellido.setText(unUsuario.getNombreApellido());
        Email = (TextView) findViewById(R.id.id_correo_usuario);
        Email.setText(unUsuario.getMail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.ver_usuario_menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId() ) {
            case R.id.editar_usuario:{
                lanzarActividadEdicionUsuario();
                break;
            }
            case R.id.eliminar_usuario:{
                GestionBitacora.usuarios.remove(CI_usuario);
                desplegarMensajeEliminacionUsuario();
                finish();
                break;
            }

        }
        return true;
    }
//    public void opcionSiguiente(){
//        CI_usuario++;
//        if( CI_usuario < GestionBitacora.usuarios.size()){
//            unUsuario = GestionBitacora.usuarios.get( CI_usuario);
//            actualizarVista();
//
//        }else{
//            Context contexto = getApplicationContext();
//            NotificationsUtils.desplegarMensaje("Ya no existen usuarios en la lista", contexto);
//        }
//
//    }

    private void lanzarActividadEdicionUsuario() {
        Intent i = new Intent( this, PerfilEditActivity.class );
        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario));
        startActivityForResult( i, RequestCode.PETICION_EDITAR_USUARIO.getCodigo());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dato) {
        super.onActivityResult(requestCode, resultCode, dato);
        if (requestCode == RequestCode.PETICION_EDITAR_USUARIO.getCodigo()) {
            if (resultCode == RESULT_OK) {
                Bundle extras = dato.getExtras();
                int resultado = extras.getInt("resultado", -1);
                if (resultado == 1) {
                    desplegarMensajeEdicioUsuarioExitoso();
                    actualizarVista();
                }
            }
        }
    }

    public void desplegarMensajeEliminacionUsuario() {
        Toast toast = Toast.makeText( this, "El usuario fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioUsuarioExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del usuario fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteUsuario() {
        Toast toast = Toast.makeText( this, "El usuario no existe", Toast.LENGTH_SHORT);
        toast.show();
    }

//    public void lanzarVistaMenuMateriaPrincipal(View view) {
//        Log.i(tag, "ENTRA A MENU TEMA PRINCIPAL");
//        Intent i = new Intent(this, MenuMateriaPrincipalActivity.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//    }

}
