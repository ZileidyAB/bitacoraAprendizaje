package py.com.misgruposv01.datos;

import android.util.Log;

import java.util.ArrayList;

public class GestionBitacora {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioLogueado;

    public static Usuario usuario1;
    public static Usuario usuario2;

    public static ArrayList<Materia> listadoMaterias1 = new ArrayList<>();
    public static ArrayList<Materia> listadoMaterias2 = new ArrayList<>();

    public static Materia materia1;
    public static Materia materia2;
    public static Materia materia3;

    public static Tema tema1;
    public static Tema tema2;
    public static Tema tema3;
    public static Tema tema4;
    public static Tema tema5;

    public static ArrayList<Tema> temas1 = new ArrayList<>();
    public static ArrayList<Tema> temas2 = new ArrayList<>();
    public static ArrayList<Tema> temas3 = new ArrayList<>();

    public static Item item1;
    public static Item item2;
    public static Item item3;

    public static ArrayList<Item> items1 = new ArrayList<>();
    public static ArrayList<Item> items2 = new ArrayList<>();


    public static Investigacion investigacion1;
    public static Investigacion investigacion2;
    public static Investigacion investigacion3;

    public static ArrayList<Investigacion> investigaciones1 = new ArrayList<>();
    public static ArrayList<Investigacion> investigaciones2 = new ArrayList<>();

    public static Ejercicio ejercicio1;
    public static Ejercicio ejercicio2;
    public static Ejercicio ejercicio3;
    public static ArrayList<Ejercicio> ejercicios1 = new ArrayList<>();
    public static ArrayList<Ejercicio> ejercicios2 = new ArrayList<>();


    private static final String tag = "AppConoceme";

    static {
        //Inicializar ejercicios
        ejercicio1 = new Ejercicio("ej1", "02:00", "Muchos ejercicios para una tarde", "¿Cómo sumar?", 65);
        ejercicio2 = new Ejercicio("ej2", "01:40", "Pocos ejercicios para fijar conocimientos", "Ninguna", 50);
        ejercicio3 = new Ejercicio("ej3", "00:30", "Excelentes ejercicios", "Ninguna", 100);

        ejercicios1.add(ejercicio1);
        ejercicios2.add(ejercicio2);
        ejercicios1.add(ejercicio3);
        ejercicios2.add(ejercicio1);

        //Inicializar investigaciones
        investigacion1 = new Investigacion("inv1", "Investigación I", "01:50", "Ninguna", 60, "Ninguna Duda");
        investigacion2 = new Investigacion("inv2", "Investigación II", "02:30", "Especificar nombre", 40, "Concepto");
        investigacion3 = new Investigacion("inv3", "Investigación III", "04:00", "Faltan indicadores", 70, "Muchas dudas");

        investigaciones1.add(investigacion1);
        investigaciones2.add(investigacion2);
        investigaciones2.add(investigacion3);
        investigaciones1.add(investigacion3);

        //Inicializar items (conocimientos)
        item1 = new Item("num1", "POO", "Significa Programacion Orientada a Objetos", "Ninguna", true);
        item2 = new Item("num2", "Lenguas", "Son un sistema de signos lingüísticos", "Ninguna", false);
        item3 = new Item("num3", "Radicales", "Es el proceso de hallar raíces de orden n de un número a", "Ninguna", false);

        items1.add(item1);
        items2.add(item2);
        items1.add(item3);
        items2.add(item1);

        //Inicializar temas
        tema1 = new Tema("poo", "Programación Orientada a Objetos", "15/06/2020", investigaciones1, items1, ejercicios1);
        tema2 = new Tema("mercado", "El mercadeo", "20/08/2020", investigaciones2, items2, ejercicios2);
        tema3 = new Tema("acentos", "Acentos", "15/03/2020", investigaciones1, items2, ejercicios1);
        tema4 = new Tema("tm4", "Tema 4", "04/10/2020", investigaciones2, items1, ejercicios2);
        tema5 = new Tema("tm5", "Tema 5", "25/12/2020", investigaciones1, items2, ejercicios2);

        temas1.add(tema1);
        temas1.add(tema2);
        temas1.add(tema3);
        temas2.add(tema4);
        temas3.add(tema5);

        //Inicializar materias
        materia1 = new Materia("proyTIC", "Proyecto TIC", temas1);
        materia2 = new Materia("mkt1", "Marketing", temas2);
        materia3 = new Materia("lengua", "Lengua extranjera II", temas3);

        listadoMaterias1.add(materia1);
        listadoMaterias2.add(materia2);
        listadoMaterias1.add(materia3);

        usuario1 = new Usuario("1234567", "Marina Acosta", "marina.com", "123", listadoMaterias1);
        usuario2 = new Usuario("1111111", "Carolina Barrios", "carola.com", "123", listadoMaterias2);
//        usuario1 = new Usuario("1234567", "Marina Acosta", "marina.com", "123", listadoMaterias2);

        usuarios.add(usuario1);
//        usuarios.add(usuario1);
        usuarios.add(usuario2);

        //Mensaje para saber el listado de materiasss
        Log.i(tag, "Listado 1 materias size: " + listadoMaterias1.size());
        Log.i(tag, "Listado 2 materias size: " + listadoMaterias2.size());

    }

    public static boolean comprobarCredenciales(String CI, String password) {

        for (Usuario usuario : usuarios) {
            if (CI.equals(usuario.getCI()) && password.equals(usuario.getContrasenha())) {
                return true;
            }
        }
        return false;
    }

    public static boolean comprobarCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (correo.equals(usuario.getMail())) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        GestionBitacora.usuarios = usuarios;
    }

    public static Usuario buscarUsuario(String CI) {
        Usuario unUsuario;
        for (int i = 0; i < usuarios.size(); i++) {
            unUsuario = usuarios.get(i);
            if (CI != null){
                if (CI.equals(unUsuario.getCI())) {
                    return unUsuario;
                }
            }else{
                Log.i(tag, "SUPER NULL usuario"); //Arroja este mensaje cuando esta recibiendo el codigo NULL
            }
        }
        return null;
    }

    public static void setUsuarioLogueado() {
        usuarioLogueado = usuario1;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static Usuario getUsuario(String email ) {
        for( Usuario usuario : usuarios) {
            if ( email.equals(usuario.getMail()) ){
                return usuario;
            }
        }
        // TODO se podria lanzar una excepcion al no encontrar el usuairo
        return null;
    }
    public static void agregarUsuario(Usuario usuario) {
        usuarios.add( usuario );
    }

//    public static void agregarMateria(Materia unaMateria) {
//        listadoMaterias1.add( unaMateria );
//    }

    public static void agregarMateria(Usuario unUsuario, Materia materia) {
        unUsuario.getMaterias().add(materia);
        Log.i(tag, "Materia nueva: "+materia.getNombre()); //Control
    }

    public static void agregarTema(Materia unaMateria, Tema unTema) {
        unaMateria.getTemas().add(unTema);
        Log.i(tag, "Tema nuevo: "+unTema.getNombre()); //Control
    }

    public static void agregarItem(Tema unTema, Item unItem) {
        unTema.getItems().add(unItem);
        Log.i(tag, "Ejercicio nuevo: "+unItem.getCodigo()); //Control
    }

    public static void agregarEjercicio(Tema unTema, Ejercicio unEjercicio) {
        unTema.getEjercicios().add(unEjercicio);
        Log.i(tag, "Ejercicio nuevo: "+unEjercicio.getCodigo()); //Control
    }

}