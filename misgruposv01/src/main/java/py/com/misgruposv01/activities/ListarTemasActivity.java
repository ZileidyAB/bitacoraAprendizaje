package py.com.misgruposv01.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.adapter.TemaAdapter;
import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Tema;

public class ListarTemasActivity extends ListActivity {
    private String tag = "AppConoceme";
    private ListView listview;
    private ArrayList<String> names;
    private ArrayList<String> fechas;
    private TextView nombreTema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarTemasActivity.onCreate");
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_listar_temas);
        setContentView(R.layout.activity_listar_temas);

        //********************************LISTVIEW*****************************************
        ArrayList<Tema> temas = Tema.getTemas();
        Log.d(tag, "Cantidad de temas: " + temas.size());

        setListAdapter(new TemaAdapter(this, temas));
    }

//        //Evento Click
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(ListarTemasActivity.this, "Has pulsado: " + names.get(position), Toast.LENGTH_LONG).show();
//            }
//        });
//        TemaAdapter myAdapter = new TemaAdapter(this, R.layout.activity_list_item, names, fechas);
//        listview.setAdapter(myAdapter);
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public void lanzarVistaRegistrarTema(View view) {
        //VER
        Intent i = new Intent(this, RegistrarTemaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaMenuTemasPrincipal(View view) {
        Log.i(tag, "ENTRA A MENU TEMA PRINCIPAL");
        Intent i = new Intent(this, MenuTemaPrincipalActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);

//        this.nombreTema = (TextView) findViewById(R.id.nombre_tema);
//        String nombreTema = this.nombreTema.getText().toString();
//        Log.i(tag, "Nombre:" + nombreTema); //Ver si trae el nombre
//
//        if (nombreTema.equals("")) {
//            Log.i(tag, "No existe el nombre del tema");
//        } else {
//            TextView nombreElemento = (TextView) view.findViewById(R.id.titulo_tema);
//            Log.i(tag, "Nombre:" + nombreElemento);
//
//            nombreElemento.setText(nombreTema);
//        }

    }
}
