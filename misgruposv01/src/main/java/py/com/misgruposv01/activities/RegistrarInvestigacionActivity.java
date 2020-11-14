package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;

public class RegistrarInvestigacionActivity extends AppCompatActivity {
    private String tag = "RegistrarInvestigacionActivity";
    //NOMBRAR DATOS

    EditText editCodigoInvestigacion;
    EditText editTemaInvestigado;
    EditText editComentariosInvestigacion;
    EditText editDudasInvestigacion;
    EditText editTiempoDedidadoInvestigacion;
    EditText editNivelComprension;

    private Materia unaMateria;
    private Tema unTema;

    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_investigacion);

        editCodigoInvestigacion = (EditText) findViewById(R.id.codigo_registrar_investigacion);
        editTemaInvestigado = (EditText) findViewById(R.id.tema_investigado);
        editComentariosInvestigacion = (EditText) findViewById(R.id.comentarios_registrar_investigacion);
        editDudasInvestigacion = (EditText) findViewById(R.id.dudas_registrar_investigacion);
        editTiempoDedidadoInvestigacion = (EditText) findViewById(R.id.tiempoDedicado_registrar_investigacion);
        editNivelComprension = (EditText) findViewById(R.id.nivel_comprension);

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

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.registrar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void RegistrarInvestigacion() { //
    //public void registrarInvestigacion(View boton) {
        String codigoInvestigacion = editCodigoInvestigacion.getText().toString();
        String temaInvestigacion = editTemaInvestigado.getText().toString();
        String comentariosInvestigacion = editComentariosInvestigacion.getText().toString();
        String dudasInvestigacion = editDudasInvestigacion.getText().toString();
        double tiempoDedicadoInvestigacion = 0;
        String text = editTiempoDedidadoInvestigacion.getText().toString();
        if (!text.isEmpty())
            try {
                tiempoDedicadoInvestigacion = Double.parseDouble(text);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        //double tiempoDedicadoInvestigacion = editTiempoDedidadoInvestigacion.getText().toDouble();
        String nivelComprensionInvestigacion = editNivelComprension.getText().toString();

        Log.i(tag, "Codigo Investigacion: " + codigoInvestigacion);
        Log.i(tag, "Tema Investigacion: " + temaInvestigacion);
        Log.i(tag, "Comentarios Investigacoin: " + comentariosInvestigacion);
        Log.i(tag, "Dudas Investigacion: " + dudasInvestigacion);
        Log.i(tag, "Tiempo Dedicado Investigacion: " + tiempoDedicadoInvestigacion);
        Log.i(tag, "Nivel comprension Investigacion: " + nivelComprensionInvestigacion);

        if (codigoInvestigacion.equals("") || temaInvestigacion.equals("") || comentariosInvestigacion.equals("") || dudasInvestigacion.equals("") || (tiempoDedicadoInvestigacion < 0) || nivelComprensionInvestigacion.equals("")) {
            Log.i(tag, "Debe rellenar TODOS los campos");
            Toast.makeText(this, "Debe rellenar TODOS los campos", Toast.LENGTH_SHORT).show();
        } else {
            String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
            Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
            Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL

            unaMateria = unUsuario.getMaterias().get(idMateria);   //obtener materias
            Log.i(tag, "Materia seleccionada por id: " + unaMateria.getNombre()); //CONTROL

            unTema = unaMateria.getTemas().get(idTema);   //obtener materias
            Log.i(tag, "Tema seleccionado por id: " + unTema.getNombre()); //CONTROL

            Investigacion unaInvestigacion = new Investigacion(codigoInvestigacion, temaInvestigacion, comentariosInvestigacion, dudasInvestigacion, tiempoDedicadoInvestigacion, nivelComprensionInvestigacion);
            GestionBitacora.agregarInvestigacion(unTema, unaInvestigacion);
            Toast.makeText(this, "Investigacion creado", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                RegistrarInvestigacion();
                break;
            }
            case R.id.item_limpiar: {
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void limpiarCampos() {
        editCodigoInvestigacion.setText("");
        editComentariosInvestigacion.setText("");
        editDudasInvestigacion.setText("");
        editTiempoDedidadoInvestigacion.setText("");
        editNivelComprension.setText("");

        // editAprendido.setChecked(true);

    }
}

