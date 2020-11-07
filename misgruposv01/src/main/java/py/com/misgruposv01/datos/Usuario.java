package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Usuario {
    private int idUsuario;
    private String nombreApellido;
    private String mail;
    private String contrasenha;
    public ArrayList<Materia> listaMaterias;
    public static ArrayList<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("1234567", "Marina Acosta", "marina.com", "123"));
    }

    public Usuario(String CI, String nombreApellido, String mail, String contrasenha) {
        this.CI = CI;
        this.nombreApellido = nombreApellido;
        this.mail = mail;
        this.contrasenha = contrasenha;
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

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    private String CI;

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
}
