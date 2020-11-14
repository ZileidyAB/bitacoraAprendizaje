package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;
import py.com.misgruposv01.utils.LogUtils;

public class RegistrarItemActivity extends AppCompatActivity {
    private String tag = "RegistrarItemsActivity";
    EditText editCodigoItem;
    EditText editConceptoItem;
    EditText editDescripcionItem;
    EditText editDudaItem;

    CheckBox editAprendido; //VER

    private Materia unaMateria;
    private Tema unTema;
    private int CI_usuario = -1;
    private int idTema = -1;
    private int idMateria = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_item);

        editCodigoItem = (EditText) findViewById(R.id.codigo_registrar_item);
        editConceptoItem = (EditText) findViewById(R.id.concepto_registrar_item);
        editDescripcionItem = (EditText) findViewById(R.id.descripcion_registrar_item);
//     editAprendido = (CheckBox) findViewById(R.id.Aprendido_registrar_item); //VER
        editDudaItem = (EditText) findViewById(R.id.duda_registrar_item);

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
    public void RegistrarItem() { //
   // public void registrarItem(View boton) {
        String CodigoItem = editCodigoItem.getText().toString();
        String ConceptoItem = editConceptoItem.getText().toString();
        String DescripcionItem = editDescripcionItem.getText().toString();
        String DudaItem = editDudaItem.getText().toString();
        //TRATAR TEMA DE CHECKBOX
        //boolean AprendidoItem = Boolean.parseBoolean(editAprendido.getText().toString());
        //VER

        Log.i(tag, "Codigo Item: " + CodigoItem);
        Log.i(tag, "Concepto Item: " + ConceptoItem);
        Log.i(tag, "Descripcion Item: " + DescripcionItem);
//        Log.i(tag, "Aprendido: " + AprendidoItem);
        Log.i(tag, "Tiempo Dedicado Ejercicio: " + DudaItem);


//        if (codigoEjercicio.equals("") || experienciaEjercicio.equals("") || dudasEjercicio.equals("") || (AprendidoItem != null) || tiempoDedicado.equals("")) {
            if (CodigoItem.equals("") || ConceptoItem.equals("") || DescripcionItem.equals("") || DudaItem.equals("")) {

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

//                Ejercicio unEjercicio = new Ejercicio(codigoEjercicio, experienciaEjercicio, dudasEjercicio, tiempoDedicado, AprendidoItem);
                Item unItem = new Item(CodigoItem, ConceptoItem, DescripcionItem, DudaItem);
                GestionBitacora.agregarItem(unTema, unItem);
                Toast.makeText(this, "Ejercicio creado", Toast.LENGTH_SHORT).show();
                finish();

            }
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.item_guardar: {
                    Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                    RegistrarItem();
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
        editCodigoItem.setText("");
        editConceptoItem.setText("");
        editDescripcionItem.setText("");
        editDudaItem.setText("");
       // editAprendido.setChecked(true);

    }
}