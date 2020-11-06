package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Ejercicio {
    private int id;
    private String codigo;
    private String tiempoDedicado;
    private String experiencia;
    private String dudas;
    private double porcLogrado;

    private static ArrayList<Ejercicio> ejercicios;

    static {
        ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("ej1", "02:00", "Muchos ejercicios para una tarde", "¿Cómo sumar?", 65));
        ejercicios.add(new Ejercicio("ej2", "01:40", "Pocos ejercicios para fijar conocimientos", "Ninguna", 50));
        ejercicios.add(new Ejercicio("ej3", "00:30", "Excelentes ejercicios", "Ninguna", 100));
    }

    public Ejercicio(String codigo, String tiempoDedicado, String experiencia, String dudas, double porcLogrado) {
        this.codigo = codigo;
        this.tiempoDedicado = tiempoDedicado;
        this.experiencia = experiencia;
        this.dudas = dudas;
        this.porcLogrado = porcLogrado;
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

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public double getPorcLogrado() {
        return porcLogrado;
    }

    public void setPorcLogrado(double porcLogrado) {
        this.porcLogrado = porcLogrado;
    }

    public static ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public static void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        Ejercicio.ejercicios = ejercicios;
    }
}
