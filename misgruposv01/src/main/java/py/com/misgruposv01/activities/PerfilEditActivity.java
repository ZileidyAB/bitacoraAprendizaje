package py.com.misgruposv01.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;
import py.com.misgruposv01.utils.RequestCode;

public class PerfilEditActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    private boolean modoEdicion = false;
    EditText editTextCI;
    EditText editTextNombreApellido;
    EditText editTextEmail;
    EditText editTextContrasenha;
    EditText editTextContrasenhaConfirm;
    private int CI_usuario = -1;
    Button botton;
    private TextView CI;
    private TextView NombreApellido;
    private TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en CrearCuentaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil_edit);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario");
            Log.i(tag, "CI Usuario: " + CI_usuario);
        }

        editTextCI = (EditText) findViewById(R.id.CI);
        editTextNombreApellido = (EditText) findViewById(R.id.nombreApellido);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextContrasenha = (EditText) findViewById(R.id.contrasenha);
        editTextContrasenhaConfirm = (EditText) findViewById(R.id.contrasenhaConfirm);
        //  botton = (Button) findViewById(R.id.button1);

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI

        // Verificamos si nos llamaron para editar algun grupo


        if (unUsuario != null) {
            modoEdicion = true;
            editTextCI.setText(unUsuario.getCI());
            editTextNombreApellido.setText(unUsuario.getNombreApellido());
            editTextEmail.setText(unUsuario.getMail());
        }
    }

        public void editarUsuario  (){
        String CI = editTextCI.getText().toString();
        String nombreApellido = editTextNombreApellido.getText().toString();
        String email = editTextEmail.getText().toString();


        Log.i(tag, "CI: " + CI);
        Log.i(tag, "Nombre de usuario: " + nombreApellido);
        Log.i(tag, "Email: " + email);

        if (modoEdicion) {
            Usuario  unUsuario = GestionBitacora.usuarios.get(CI_usuario);
            unUsuario.setCI(CI);
            unUsuario.setNombreApellido(nombreApellido);
            unUsuario.setMail(email);

            Intent intent = new Intent();
            intent.putExtra("resultado", 1);
            setResult(RESULT_OK, intent);
            finish();
                }
            }

        public void actualizarVista(){

            String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
            Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
            Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL


            CI = (TextView) findViewById(R.id.id_numero_ci);
            CI.setText(unUsuario.getCI() );
            NombreApellido = (TextView) findViewById(R.id.id_nombre_apellido_usuario);
            NombreApellido.setText(unUsuario.getNombreApellido());
            Email = (TextView) findViewById(R.id.id_correo_usuario);
            Email.setText(unUsuario.getMail());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registrar_menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }


    public void desplegarMensajeEdicioUsuarioExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del usuario fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                editarUsuario();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void limpiarCampos() {
        editTextCI.setText("");
        editTextNombreApellido.setText("");
        editTextEmail.setText("");

    }
}


