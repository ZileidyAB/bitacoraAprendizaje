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
    public static Materia materia4;
    public static Materia materia5;

    public static Tema tema1;
    public static Tema tema2;
    public static Tema tema3;
    public static Tema tema4;
    public static Tema tema5;
    public static Tema tema6;
    public static Tema tema7;
    public static Tema tema8;
    public static Tema tema9;


    public static ArrayList<Tema> temas1 = new ArrayList<>();
    public static ArrayList<Tema> temas2 = new ArrayList<>();
    public static ArrayList<Tema> temas3 = new ArrayList<>();
    public static ArrayList<Tema> temas4 = new ArrayList<>();
    public static ArrayList<Tema> temas5 = new ArrayList<>();

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

    public GestionBitacora() {

    }

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
        investigacion1 = new Investigacion("inv1", "Investigación I", "Ninguna","Ninguna Duda", "01:50",  60.5);
        investigacion2 = new Investigacion("inv2", "Investigación II", "Especificar nombre","Concepto", "02:30",  40);
        investigacion3 = new Investigacion("inv3", "Investigación III", "Faltan indicadores", "Muchas dudas", "04:00", 70.5);

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
        tema1 = new Tema("poo", "POO", "15/06/2020", investigaciones1, items1, ejercicios1);
        tema2 = new Tema("listv", "ListView", "15/08/2020", investigaciones2, items2, ejercicios2);
        tema3 = new Tema("navig", "NavigationView", "11/12/2020", investigaciones2, items2, ejercicios2);
        tema4 = new Tema("mercado", "Mercados", "20/08/2020", investigaciones2, items2, ejercicios2);
        tema5 = new Tema("mktmix", "Marketing MIx", "15/05/2020", investigaciones1, items2, ejercicios1);
        tema6 = new Tema("acentos", "Acentos", "15/03/2020", investigaciones1, items2, ejercicios1);
        tema7 = new Tema("ort", "Ortografía", "04/10/2020", investigaciones2, items1, ejercicios2);
        tema8 = new Tema("suma", "Suma", "25/12/2020", investigaciones1, items2, ejercicios2);
        tema9 = new Tema("atomos", "Atomos", "25/12/2020", investigaciones1, items2, ejercicios2);

        temas1.add(tema1);
        temas1.add(tema2);
        temas1.add(tema3);
        temas2.add(tema4);
        temas2.add(tema5);
        temas3.add(tema6);
        temas3.add(tema7);
        temas4.add(tema8);
        temas5.add(tema9);

        //Inicializar materias
        materia1 = new Materia("proyTIC", "Proyecto TIC", temas1);
        materia2 = new Materia("mkt1", "Marketing", temas2);
        materia3 = new Materia("lengua", "Lengua extranjera II", temas3);
        materia4 = new Materia("mate", "Matemática", temas4);
        materia5 = new Materia("quimi", "Química", temas5);


        listadoMaterias1.add(materia1);
        listadoMaterias2.add(materia2);
        listadoMaterias1.add(materia3);
        listadoMaterias1.add(materia4);
        listadoMaterias2.add(materia5);

        usuario1 = new Usuario("1234567", "Marina Acosta", "marina.com", "123", listadoMaterias1);
        usuario2 = new Usuario("1111111", "Carolina Barrios", "carola.com", "123", listadoMaterias2);

        usuarios.add(usuario1);
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
            if (CI != null) {
                if (CI.equals(unUsuario.getCI())) {
                    return unUsuario;
                }
            } else {
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

    public static Usuario getUsuario(String email) {
        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail())) {
                return usuario;
            }
        }
        // TODO se podria lanzar una excepcion al no encontrar el usuairo
        return null;
    }

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

//    public static void agregarMateria(Materia unaMateria) {
//        listadoMaterias1.add( unaMateria );
//    }

    public static void agregarMateria(Usuario unUsuario, Materia materia) {
        Log.i(tag, "***Agregar materia***"); //CONTROL
        Log.i(tag, "Usuario: " + unUsuario.getNombreApellido()); //CONTROL
        Log.i(tag, "Materia: " + materia.getNombre()); //CONTROL
        if (unUsuario.getMaterias() == null) {
            Log.i(tag, "ENTRA EN EL NULL Y REGISTRA"); //CONTROL
//            ArrayList<Materia> materias1 = null;
            ArrayList<Materia> materias = new ArrayList<>();
            materias.add(materia);
            Log.i(tag, "Materia size: " + materias.size()); //CONTROL
            unUsuario.setMaterias(materias);
        } else {
            Log.i(tag, "NOO ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            Log.i(tag, "MATERIAS: " + unUsuario.getMaterias()); //CONTROL
            unUsuario.getMaterias().add(materia);
            Log.i(tag, "Materia nueva: " + materia.getNombre()); //Control
        }
    }

    public static void agregarTema(Materia unaMateria, Tema unTema) {
        Log.i(tag, "***Agregar Tema***"); //CONTROL
        Log.i(tag, "Nombre materia: " + unaMateria.getNombre()); //CONTROL
        Log.i(tag, "Nombre tema: " + unTema.getNombre()); //CONTROL
        if (unaMateria.getTemas() == null) {
            Log.i(tag, "ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            ArrayList<Tema> temas = new ArrayList<>();
            temas.add(unTema);
            unaMateria.setTemas(temas);
            Log.i(tag, "Temas size: " + temas.size()); //CONTROL
        } else {
            Log.i(tag, "NOO ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            Log.i(tag, "TEMAS: " + unaMateria.getTemas()); //CONTROL
            unaMateria.getTemas().add(unTema);
            Log.i(tag, "Tema nuevo: " + unTema.getNombre()); //Control
        }
    }

    public static void agregarItem(Tema unTema, Item unItem) {
        Log.i(tag, "***Agregar Item***"); //CONTROL
        Log.i(tag, "Nombre tema: " + unTema.getNombre()); //CONTROL
        Log.i(tag, "Nombre item: " + unItem.getCodigo()); //CONTROL
        if (unTema.getItems() == null) {
            Log.i(tag, "ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            ArrayList<Item> items = new ArrayList<>();
            items.add(unItem);
            unTema.setItems(items);
            Log.i(tag, "Items size: " + items.size()); //CONTROL
        } else {
            Log.i(tag, "NOO ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            Log.i(tag, "ITEMS: " + unTema.getItems()); //CONTROL
            unTema.getItems().add(unItem);
            Log.i(tag, "Item nuevo: " + unItem.getCodigo()); //Control
        }
    }

    public static void agregarEjercicio(Tema unTema, Ejercicio unEjercicio) {
        Log.i(tag, "***Agregar Ejercicio***"); //CONTROL
        Log.i(tag, "Nombre tema: " + unTema.getNombre()); //CONTROL
        Log.i(tag, "Nombre ejercicio: " + unEjercicio.getCodigo()); //CONTROL
        if (unTema.getEjercicios() == null) {
            Log.i(tag, "ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            ArrayList<Ejercicio> ejercicios = new ArrayList<>();
            ejercicios.add(unEjercicio);
            unTema.setEjercicios(ejercicios);
            Log.i(tag, "Ejercicios size: " + ejercicios.size()); //CONTROL
        } else {
            Log.i(tag, "NOO ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            Log.i(tag, "EJERCICIOS: " + unTema.getEjercicios()); //CONTROL
            unTema.getEjercicios().add(unEjercicio);
            Log.i(tag, "Ejercicio nuevo: " + unEjercicio.getCodigo()); //Control
        }
    }

    public static void agregarInvestigacion(Tema unTema, Investigacion unaInvestigacion) {
        Log.i(tag, "***Agregar Investigacion***"); //CONTROL
        Log.i(tag, "Nombre tema: " + unTema.getNombre()); //CONTROL
        Log.i(tag, "Nombre investigaicon: " + unaInvestigacion.getCodigo()); //CONTROL
        if (unTema.getInvestigaciones() == null) {
            Log.i(tag, "ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            ArrayList<Investigacion> investigaciones = new ArrayList<>();
            investigaciones.add(unaInvestigacion);
            unTema.setInvestigaciones(investigaciones);
            Log.i(tag, "Investigaciones size: " + investigaciones.size()); //CONTROL
        } else {
            Log.i(tag, "NOO ENTRA EN EL NULL Y REGISTRA"); //CONTROL
            Log.i(tag, "INVESTIGACIONES: " + unTema.getInvestigaciones()); //CONTROL
            unTema.getInvestigaciones().add(unaInvestigacion);
            Log.i(tag, "Investigacion nueva: " + unaInvestigacion.getCodigo()); //Control
        }
    }
}