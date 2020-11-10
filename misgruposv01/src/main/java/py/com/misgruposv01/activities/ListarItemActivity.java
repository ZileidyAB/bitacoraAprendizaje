package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.ItemAdapter;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Usuario;

public class ListarItemActivity extends ListActivity {
    private String tag = "AppConoceme";
    private ListView listview;
    private ArrayList<String> concepto;
    private ArrayList<String> descripcion;
    private ArrayList<String> dudas;
    // private ArrayList<String> aprendido;

    private int CI_usuario;
    private Materia unaMateria;
    private Tema unTema;
    private int idMateria = -1;
    private int idTema = -1;

    private CheckBox aprendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarItemActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_item);

        aprendido = ((CheckBox) findViewById(R.id.checkboxAprendido));


        //********************************RECIBIR CODIGO MATERIA*****************************************
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            idMateria = extras.getInt("posicionMateria");
            Log.i(tag, "codigoMateria EN LISTAR TEMAS: " + idMateria);
        }

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extrasCI = getIntent().getExtras();
        if (extrasCI != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }
        //********************************LISTVIEW*****************************************
        ArrayList<Item> items = new ArrayList<>();

        String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
        Usuario unUsuario = GestionBitacora.buscarUsuario(CI_usuario_string); // Traer el usuario ya por su CI
        Log.i(tag, "Usuario logueado: " + unUsuario.getNombreApellido()); //CONTROL
        unaMateria = unUsuario.getMaterias().get(idMateria);   //obtener materias
        Log.i(tag, "Materia seleccionada por id: " + unaMateria.getNombre()); //CONTROL
        unTema = unaMateria.getTemas().get(idMateria);
        items = unTema.getItems(); //obtener los temas de la materia
        Log.i(tag, "Items size: " + unTema.getItems().size()); //CONTROL
        Log.d(tag, "Cantidad de de Items: " + items.size()); //CONTROL
        Log.i(tag, "ITEMS: " + unTema.getItems()); //CONTROL


        setListAdapter(new ItemAdapter(this, items)); //llamar adaptador
    }


    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position + ". Id: " + id, Toast.LENGTH_SHORT).show();
    }

    public void loguearCheckbox(View v) {
        String s = "Estado: " + (aprendido.isChecked() ? "Marcado" : "No Marcado");
        Toast.makeText(this, "Marcado", Toast.LENGTH_LONG).show();
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean aprendido = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkboxAprendido:
                if (aprendido == true) {
                    // Put some meat on the sandwich
                    break;
                }
        }
    }
}


//        Log.i(tag, "ENTRA A ITEM ");
//        Intent i = new Intent(this, ListarItemActivity.class);
//        //Arreglar
//        i.putExtra("idMateria", Integer.parseInt("" + position));
//        i.putExtra("CI_usuario", Integer.parseInt("" + CI_usuario)); //Manda el codigo a ListarTemasActivity
//        startActivity(i);
//    }
//}


//VERRR
//    private void setListAdapter(ItemAdapter itemAdapter) {
//    }
//
//    public void onCheckboxClicked(View view) {
//        // Is the view now checked?
//
////        if (aprendido.setChecked(true)== {
////            Toast.makeText(this, "Marcado", Toast.LENGTH_LONG).show();
////        }
//        if (aprendido != null) {
//            CheckBox checkBox = (CheckBox) aprendido.findViewById(R.id.checkboxAprendido);
//            checkBox.setChecked(!checkBox.isChecked());
////        // Check which checkbox was clicked
////        switch (view.getId()) {
////            case R.id.checkboxAprendido:
////                if (aprendido) {
////                    // action
////                } else
////                    // action
////                    break;
////        }
////    }
//        }
//    }
//}
//    CheckBox checkbox=(CheckBox)findViewById(R.id.checkboxAprendido);
// buttonOrder.setOnClickListener(new View.OnClickListener(){
//        {
//        @Override
//        public void onClick(View v)
//        {
//            if (checkbox.isChecked())
//            {
//                Log.i(tag, "Debe rellenar TODOS los campos");//Perform action when you touch on checkbox and it change to selected state
//            }
//            else
//            { Log.i(tag, "Debe rellenar TODOS los campos");
//                //Perform action when you touch on checkbox and it change to unselected state
//            }
//        }
//    });
