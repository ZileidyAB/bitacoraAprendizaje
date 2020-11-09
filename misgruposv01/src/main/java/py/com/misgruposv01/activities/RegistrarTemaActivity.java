package py.com.misgruposv01.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Tema;


@RequiresApi(api = Build.VERSION_CODES.O)
public class RegistrarTemaActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText t1;
    private EditText campoCodigo;
    private EditText campoNombre;
    private EditText campoFecha;
    private EditText campoNota;

    private int idTema = -1;
    private boolean modoEdicion = false;
//se declara las variables para fecha
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en RegistrarTemaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tema);
        campoCodigo = (EditText) findViewById(R.id.codigo);
        campoNombre = (EditText) findViewById(R.id.nombre_tema);
        campoFecha = (EditText) findViewById(R.id.fecha);
        campoNota = (EditText) findViewById(R.id.nota);
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.fecha);

        //********************************Editar*****************************************
        // Verificamos si nos llamaron para editar algun grupo
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idTema = extras.getInt("idTema", -1);
            if (idTema != -1) {
                modoEdicion = true;
                campoNombre.setText(GestionBitacora.temas1.get(idTema).getNombre());
                campoCodigo.setText(GestionBitacora.temas1.get(idTema).getCodigo());
                campoFecha.setText(GestionBitacora.temas1.get(idTema).getFecha());
                // campoNota.setText( GestionBitacora.temas1.get( idTema).getNota() );
                //boton.setText( "Editar Grupo" );
            }
        }
//********************************Esto creo no va acá*****************************************
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });

    }

    //Se reciben los parametros
    private void colocar_fecha() {
        t1.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
    }

    //se guardan los datos
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }

        //********************************Editar*****************************************
        // Verificamos si nos llamaron para editar algun grupo


        ///public void crearGrupo(View view) { // para boton
        public void crearGrupo() { // para boton
            String codigo = campoCodigo.getText().toString();
            String nombre = campoNombre.getText().toString();
            String fecha = campoFecha.getText().toString();


            if ( codigo.equals("") || nombre.equals("") || fecha.equals("") ) {
                desplegarMensajeCamposRequeridos();
            } else {
                if ( modoEdicion ) {
                    Tema tema = GestionBitacora.temas1.get(idTema);
                    tema.setNombre( nombre );
                    tema.setCodigo( codigo );
                    tema.setFecha( fecha );

                    Intent intent = new Intent();
                    intent.putExtra("resultado", 1);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Tema tema = new Tema ( nombre, codigo ,fecha);
                    Tema.agregarTema( tema );
                    desplegarMensajeResgistroExitoso();

                    Intent intent = new Intent();
                    intent.putExtra("resultado", 10);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }

        public void desplegarMensajeCamposRequeridos() {
            Toast toast = Toast.makeText( this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
            toast.show();
        }

        public void desplegarMensajeResgistroExitoso() {
            Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
            toast.show();
        }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.tema_menu, menu);
//        //return true;
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch(item.getItemId()){
//            case R.id.item_guardar: {
//                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
//                crearGrupo();
//                break;
//            }case R.id.item_limpiar:{
//                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
//                limpiarCampos();
//            }
//        }
//        return true;
//    }
//
//    public void limpiarCampos(){
//        campoNombre.setText("");
//        campoCodigo.setText("");
//        campoFecha.setText("");
//    }
}
//********************************Calendario*****************************************




    //Metodo bindView para asociar una tarea a un layout
//    public void bindView (View view, Context context, Cursor cursor){
//    TextView codigoTema = (TextView) view.findViewById(R.id.codigo_tema);
//        nombreElemento.setText(lista.get(posicion).getCodigo());
//
//    TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_tema);
//        //nombreElemento.setText(lista.get(posicion).getNombre());
//nombreElemento.setText((cursor.getString(cursor.getColumnIntex ("nombre_tema"));
////    TextView fechaTema = (TextView) view.findViewById(R.id.fecha);
////        fechaTema.setText(""+lista.get(posicion).getFecha());
//        String dateString = cursor.getString (cursor.getColumnIndex ("fecha_tema");
//
//        LocalDate date=LocalDate.parse(dateString.substring (0, 10));
//
//
//DateTimeFormatter formato = DateTimeFormat.forPattern ("dd/MM/yyyy");
//TextView dateView = (textView) view.findViewById(R.id.fecha);
//fechaTema.setText (date.toString(fecha));
//    }


