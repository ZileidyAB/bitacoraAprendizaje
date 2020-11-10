package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import py.com.misgruposv01.R;

public class RegistrarItemActivity extends Activity {
    private String tag = "AppConoceme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}