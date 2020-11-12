package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;

public class CrearCuentaActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    private boolean modoEdicion = false;
    EditText editTextCI;
    EditText editTextNombreApellido;
    EditText editTextEmail;
    EditText editTextContrasenha;
    EditText editTextContrasenhaConfirm;
    private int CI_usuario = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en CrearCuentaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        editTextCI = (EditText) findViewById(R.id.CI);
        editTextNombreApellido = (EditText) findViewById(R.id.nombreApellido);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextContrasenha = (EditText) findViewById(R.id.contrasenha);
        editTextContrasenhaConfirm = (EditText) findViewById(R.id.contrasenhaConfirm);

        Bundle extras = getIntent().getExtras();
        if ( extras != null ) {
            CI_usuario = extras.getInt( "idGrupo", -1 );
            if ( CI_usuario != -1 ) {
                modoEdicion = true;
                editTextCI.setText( GestionBitacora.usuarios.get( CI_usuario ).getCI() );
                editTextNombreApellido.setText( GestionBitacora.usuarios.get( CI_usuario  ).getNombreApellido() );
                editTextEmail.setText( GestionBitacora.usuarios.get( CI_usuario  ).getMail() );

                //boton.setText( "Editar Grupo" );
            }
        }
    }

    public void registrarUsuario(View boton) {
        String CI = editTextCI.getText().toString();
        String nombreApellido = editTextNombreApellido.getText().toString();
        String email = editTextEmail.getText().toString();
        String contrasenha = editTextContrasenha.getText().toString();
        String contrasenhaConfirm = editTextContrasenhaConfirm.getText().toString();

        Log.i(tag, "CI: " + CI);
        Log.i(tag, "Nombre de usuario: " + nombreApellido);
        Log.i(tag, "Email: " + email);
        Log.i(tag, "Contraseña: " + contrasenha);
        Log.i(tag, "Contraseña de confirmación: " + contrasenha);

        if (CI.equals("") || nombreApellido.equals("") || email.equals("") || contrasenha.equals("") || contrasenhaConfirm.equals("")) {
            Log.i(tag, "Debe rellenar TODOS los campos");
            Toast.makeText(this, "Debe rellenar TODOS los campos", Toast.LENGTH_SHORT).show();
//            new AlertDialog.Builder(this)
//                    .setTitle("Mensaje de Login")
//                    .setMessage("Debe rellenar TODOS los campos")
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int whichButton) {
//                            dialog.cancel();
//                        }
//                    })
//                    .show();
        } else if (!editTextContrasenha.getText().toString().equals(editTextContrasenhaConfirm.getText().toString())) {

            Toast.makeText(this, "Las contraseñas no conciden", Toast.LENGTH_SHORT).show();
        } else
            if (modoEdicion) {
                Usuario unUsuario = GestionBitacora.usuarios.get(CI_usuario);
                unUsuario.setCI(CI);
                unUsuario.setNombreApellido(nombreApellido);
                unUsuario.setNombreApellido(nombreApellido);
                unUsuario.setMail(email);


                Intent intent = new Intent();
                intent.putExtra("resultado", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Usuario usuario = new Usuario(CI, nombreApellido, email, contrasenha);
                GestionBitacora.agregarUsuario(usuario);

//            ArrayList<Usuario> listaUsuarios1 = Usuario.getUsuarios(); ANTERIOR
//            ArrayList<Usuario> listaUsuarios = GestionBitacora.getUsuarios();
//
//            Usuario usuario1 = new Usuario(CI, nombreApellido, email, contrasenha, contrasenhaConfirm);
//            listaUsuarios.add(usuario1);

                Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show();
                //finish();
//            Intent i = new Intent( this, MenuMateriaPrincipalActivity.class ) ;
//            startActivity( i );
                Intent intentMenuPricipal = new Intent(this, MenuMateriaPrincipalActivity.class);
                intentMenuPricipal.putExtra("CI_usuario", Integer.parseInt("" + CI));
                startActivity(intentMenuPricipal);
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.crear_cuenta_menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void limpiarCampos(){
        editTextCI.setText("");
        editTextNombreApellido.setText("");
        editTextEmail.setText("");
        editTextContrasenha.setText("");
        editTextContrasenhaConfirm.setText("");
    }
}

