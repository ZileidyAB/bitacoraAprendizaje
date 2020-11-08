package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adapter.MateriaAdapter;
import py.com.misgruposv01.datos.GestionBitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Usuario;


public class ListarMateriaActivity extends ListActivity {
    private String tag = "AppConoceme";
    private int CI_usuario = -1;
    private Usuario unUsuario;
    private TextView codigo;
    private String codigoString;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en ListarMateriaActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_materia);

        // Instancia del servicio LayoutInflater
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = getLayoutInflater();

        // elementos_listar_materia.xml layout cargado (inflado) como View.
        View view = inflater.inflate(R.layout.elementos_listar_materia, null, true);

        // Obtiene una referencia al TextView del otro layout, elementos_listar_materia.xml
        TextView codigo = (TextView) view.findViewById(R.id.codigo_materia);
        String codigoString = codigo.getText().toString();

        //Mensajes de verificacion en el LOG
        Log.i(tag, "CODIGO RARO DE MATERIA: " + codigo);
        Log.i(tag, "CODIGO NORMAL DE MATERIA: " + codigoString);

        //********************************RECIBIR CI USUARIO*****************************************
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CI_usuario = extras.getInt("CI_usuario", -1);
            Log.i(tag, "idUsuario recibido del usuario en LISTAR MATERIA: " + CI_usuario);
        }

        //********************************TABHOST*****************************************
        //Propiedades del control
        TabHost pestanha = (TabHost) findViewById(R.id.tabHost);
        pestanha.setup();

        //Pestaña 1
        TabHost.TabSpec spec = pestanha.newTabSpec("Pestaña 1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("MATERIAS");
        pestanha.addTab(spec);

        //Pestaña 2
        spec = pestanha.newTabSpec("Pestaña 2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("PENDIENTES");
        pestanha.addTab(spec);

        //Pestaña 3
        spec = pestanha.newTabSpec("Pestaña 3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PERFIL");
        pestanha.addTab(spec);

        pestanha.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);

            }
        });

        //********************************LISTVIEW*****************************************
        ArrayList<Materia> materias = new ArrayList<>();
        for (int i = 0; i < GestionBitacora.usuarios.size(); i++) { //recorrer lista de usuarios
            unUsuario = GestionBitacora.getUsuarios().get(i); //obtener usuarios
            Log.i(tag, "USUARIOS: " + GestionBitacora.usuarios);

            String CI_usuario_string = String.valueOf(CI_usuario); //Convertir int CI a String
            Log.i(tag, "CI CONVERTIDO: " + CI_usuario_string);
            Log.i(tag, "CI getID: " + unUsuario.getCI());

            if (CI_usuario_string.equals(unUsuario.getCI())) { //comparar CI que llegó con lo que vamos obteniendo en el array

//                materias = Materia.getMaterias();
                materias = unUsuario.getMaterias(); //Obtener las materias del usuario
                Log.i(tag, "Materias size: " + unUsuario.materias.size()); //CONTROL
                Log.d(tag, "Cantidad de materias: " + materias.size()); //CONTROL
                Log.i(tag, "MATERIAS: " + unUsuario.getMaterias()); //CONTROL

            } else {
                Log.i(tag, "NO ENTRA. NO HAY CI IGUAL");
            }
        }
        setListAdapter(new MateriaAdapter(this, materias)); //llamar al adaptador de Materia
    }

    public void lanzarVistaRegistrarMateria(View view) {
        //VER
        Intent i = new Intent(this, RegistrarMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaListarTemas(View view) {
        //VER
//        String codigoMateria = this.codigo.getText().toString(); //ESTE ESTA TRAYENDO VACIO Y YA HICE ARRIBA:(
        if (codigoString == null ) {
            Log.i(tag, "SUPER NULL materia"); //Arroja este mensaje cuando esta recibiendo el codigo NULL
        } else if (codigoString.equals("")) {
            Log.i(tag, "FALLAAAAAAAAAAAAAAAA"); //Arroja este mensaje cuando esta recibiendo el codigo vacio

        } else {
            Log.i(tag, "El codigo de la materia que se toma es: " + codigoString); //Muestra el codigo //CONTROL
        }

        Intent i = new Intent(this, ListarTemasActivity.class);
//        i.putExtra("codigoMateria", Integer.parseInt(""+codigoString));
        i.putExtra("codigoMateria", codigoString); //Manda el codigo a ListarTemasActivity
        i.putExtra("CI_usuario", Integer.parseInt(""+CI_usuario)); //Manda el codigo a ListarTemasActivity


        //i.putExtra("codigoMateria", "PRUEBA"); //INTENTE ENVIAR UN HOLA COMO CODIGO Y EL OTRO NO TOMA


        //INTENTOS DE OBTENER CODIGO DE LA MATERIA DE DIFERENTES FORMAS
//        String codigoMateria = this.codigo_materia.getText().toString();
//        Log.i(tag, "CODIGO MATERIA: " + codigoMateria);
//        i.putExtra("codigoMateria", ""+codigoMateria);

//               String codigo = materias.get(i).getCodigo();
//               Log.i(tag, "CODIGO: " + codigo);

//                String codigoMateria = unUsuario.getMaterias().get(i).getCodigo(); ERROR: IndexOutOfBoundsException
//                Log.i(tag, "CODIGO: " + codigoMateria);

//                this.codigo_materia = (TextView) findViewById(R.id.codigo_materia);
//                Log.i(tag, "CODIGO: " + codigo_materia);

//                this.codigo_materia = (TextView) findViewById(R.id.codigo_materia);
//                filtrarCodigoMateria();
//                setListAdapter(new MateriaAdapter(this, materias));

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



