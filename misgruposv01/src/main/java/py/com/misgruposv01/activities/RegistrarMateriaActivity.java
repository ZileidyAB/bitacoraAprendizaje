package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import py.com.misgruposv01.R;

public class RegistrarMateriaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_materia);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}