package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class RegistrarEjercicioActivity extends Activity {
    private String tag = "RegistrarEjerciciosActivity";
    EditText editCodigoEjercicio;
    EditText editExperienciaEjercicio;
    EditText editDudasEjercicio;
    EditText editporcentajeLogrado; //VER
    EditText editTiempoDedidado;

    private Materia unaMateria;
    private Tema unTema;

    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ejercicio);

        editCodigoEjercicio = (EditText) findViewById(R.id.codigo_registrar_ejercicio);
        editExperienciaEjercicio = (EditText) findViewById(R.id.experiencia_registrar_ejercicio);
        editDudasEjercicio = (EditText) findViewById(R.id.dudas_registrar_ejercicio);
//        editporcentajeLogrado = (EditText) findViewById(R.id.seekBar); //VER
        editTiempoDedidado = (EditText) findViewById(R.id.tiempoDedicado_registrar_ejercicio);

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

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void registrarEjercicio(View boton) {
        String codigoEjercicio = editCodigoEjercicio.getText().toString();
        String experienciaEjercicio = editExperienciaEjercicio.getText().toString();
        String dudasEjercicio = editDudasEjercicio.getText().toString();
        //TRATAR TEMA DE PORCENTAJE LOGRADO
//        double porcentajeLogrado = editporcentajeLogrado.getText().toDouble();
        //VER
        String tiempoDedicado = editTiempoDedidado.getText().toString();

        Log.i(tag, "Codigo Ejercicio: " + codigoEjercicio);
        Log.i(tag, "Experiencia Ejercicio: " + experienciaEjercicio);
        Log.i(tag, "Duda Ejercicio: " + dudasEjercicio);
//        Log.i(tag, "% Logrado Ejercicio: " + porcentajeLogrado);
        Log.i(tag, "Tiempo Dedicado Ejercicio: " + tiempoDedicado);

//        if (codigoEjercicio.equals("") || experienciaEjercicio.equals("") || dudasEjercicio.equals("") || (porcentajeLogrado != null) || tiempoDedicado.equals("")) {
        if (codigoEjercicio.equals("") || experienciaEjercicio.equals("") || dudasEjercicio.equals("") || tiempoDedicado.equals("")) {

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

//                Ejercicio unEjercicio = new Ejercicio(codigoEjercicio, experienciaEjercicio, dudasEjercicio, tiempoDedicado, porcentajeLogrado);
            Ejercicio unEjercicio = new Ejercicio(codigoEjercicio, experienciaEjercicio, dudasEjercicio, tiempoDedicado);
            GestionBitacora.agregarEjercicio(unTema, unEjercicio);
            Toast.makeText(this, "Ejercicio creado", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}

