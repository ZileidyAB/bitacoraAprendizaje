package py.com.misgruposv01.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean aprendido = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkboxAprendido:
                if (aprendido) {
                    // action
                } else
                    // action
                    break;
        }
    }
//    CheckBox checkbox=(CheckBox)findViewById(R.id.checkbox);
//checkbox.setOnClickListener(new View.OnClickListener()
//    {
//        @Override
//        public void onClick(View v)
//        {
//            if (checkbox.isChecked())
//            {
//                //Perform action when you touch on checkbox and it change to selected state
//            }
//            else
//            {
//                //Perform action when you touch on checkbox and it change to unselected state
//            }
//        }
//    });
}