package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.ItemAdapter;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;

public class ListarItemActivity extends Activity {
    private String tag = "AppConoceme";
    private ListView listview;
    private ArrayList<String> concepto;
    private ArrayList<String> descripcion;
    private ArrayList<String> dudas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarItemActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_item);

        //Listado de Items (ListView)
        ArrayList<Item> items = Item.getItems();
        Log.d(tag, "Cantidad de items: "+items.size());

        setListAdapter(new ItemAdapter(this, items));

    }

    //VERRR
    private void setListAdapter(ItemAdapter itemAdapter) {
    }
}