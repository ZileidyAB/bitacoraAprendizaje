package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import py.com.misgruposv01.R;

public class SubmenuItemActivity extends Activity {

    private String tag = "AppConoceme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_item);
    }

    public void lanzarVistaListarItem(View view){
        Intent i = new Intent(this, ListarItemActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

//    public void lanzarVistaRegistarItem(View view){
//        Intent i = new Intent(this, RegistrarItem.class);
//        //i.putExtra("id", (long)0);
//        startActivity(i);
//        }
}
