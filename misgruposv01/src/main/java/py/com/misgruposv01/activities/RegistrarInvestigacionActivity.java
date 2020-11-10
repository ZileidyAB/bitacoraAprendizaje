package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

import py.com.misgruposv01.R;

public class RegistrarInvestigacionActivity extends Activity {
    private String tag = "RegistrarEjerciciosActivity";
    EditText editcodigoNuevaMateria;
    EditText editnombreNuevaMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ejercicio);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
