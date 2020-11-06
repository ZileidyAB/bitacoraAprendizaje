package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Investigacion {
    private int id;
    private String codigo;
    private String tiempoDedicado;
    private String temaInvestigado;
    private String comentarios;
    double nivelComprension;
    private String dudas;

    private static ArrayList<Investigacion> investigaciones;

    static {
        investigaciones = new ArrayList<>();
        investigaciones.add(new Investigacion("inv1", "Investigación I", "01:50", "Ninguna", 60, "Ninguna Duda"));
        investigaciones.add(new Investigacion("inv2", "Investigación II", "02:30", "Especificar nombre", 40, "Concepto"));
        investigaciones.add(new Investigacion("inv3", "Investigación III", "04:00", "Faltan indicadores", 70, "Muchas dudas"));
    }

    public Investigacion(String codigo, String tiempoDedicado, String temaInvestigado, String comentarios, double nivelComprension, String dudas) {
        this.codigo = codigo;
        this.tiempoDedicado = tiempoDedicado;
        this.temaInvestigado = temaInvestigado;
        this.comentarios = comentarios;
        this.nivelComprension = nivelComprension;
        this.dudas = dudas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTiempoDedicado() {
        return tiempoDedicado;
    }

    public void setTiempoDedicado(String tiempoDedicado) {
        this.tiempoDedicado = tiempoDedicado;
    }

    public String getTemaInvestigado() {
        return temaInvestigado;
    }

    public void setTemaInvestigado(String temaInvestigado) {
        this.temaInvestigado = temaInvestigado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public double getNivelComprension() {
        return nivelComprension;
    }

    public void setNivelComprension(double nivelComprension) {
        this.nivelComprension = nivelComprension;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public static ArrayList<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public static void setInvestigaciones(ArrayList<Investigacion> investigaciones) {
        Investigacion.investigaciones = investigaciones;
    }
}
