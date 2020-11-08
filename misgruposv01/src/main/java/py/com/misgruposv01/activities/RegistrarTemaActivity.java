package py.com.misgruposv01.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import py.com.misgruposv01.R;


@RequiresApi(api = Build.VERSION_CODES.O)
public class RegistrarTemaActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText t1;
//se declara las variables
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en RegistrarTemaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tema);

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.editTextDate1);

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
}