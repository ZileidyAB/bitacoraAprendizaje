package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Usuario;

public class RegistrarMateriaActivity extends Activity {
    EditText editcodigoNuevaMateria;
    EditText editnombreNuevaMateria;
    private int CI_usuario = -1;
    private String tag = "RegistrarMateria";
//    private int posicionMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en RegistrarMateriaActivity.onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_materia);

        editcodigoNuevaMateria = (EditText) findViewById(R.id.codigo_nueva_materia);
        editnombreNuevaMateria = (EditText) findViewById(R.id.nombre_nueva_materia);

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void crearMateria(View boton) {
        String codigo = editcodigoNuevaMateria.getText().toString();
        String nombre = editnombreNuevaMateria.getText().toString();
        Log.i(tag, "Codigo de nueva materia: " + codigo);
        Log.i(tag, "Nombre de nueva materia: " + nombre);

        if (codigo.equals("") || nombre.equals("")) {
            Log.i(tag, "Debe rellenar TODOS los campos");
            Toast.makeText(this, "Debe rellenar TODOS los campos", Toast.LENGTH_SHORT).show();
        } else {
            String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
            Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
            Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL

            Materia unaMateria = new Materia(codigo, nombre);
            if (unaMateria == null) {
                Log.i(tag, "unaMATERIA null. No se puede"); //CONTROL
            } else {
                GestionBitacora.agregarMateria(unUsuario, unaMateria);
                Log.i(tag, "Agregado"); //CONTROL
                Toast.makeText(this, "Materia agregada", Toast.LENGTH_SHORT).show();
                finish();
                Log.i(tag, "COMPROBAR" + unUsuario.getMaterias().size()); //NO FUNCIONA

                ;
            }
//            Intent i = new Intent( this, MenuMateriaPrincipalActivity.class ) ;
//            startActivity( i );
//            Intent intentMenuPricipal = new Intent(this, MenuMateriaPrincipalActivity.class);
//            intentMenuPricipal.putExtra("CI_usuario", Integer.parseInt(""+CI));
//            startActivity(intentMenuPricipal);
        }
    }
}