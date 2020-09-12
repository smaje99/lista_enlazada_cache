package dato;

import java.util.Objects;

public class Persona {
    private double cedula;
    private String nombre;
    private String apellido;
    private boolean sexo;

    public Persona(double cedula, String nombre, String apellido, boolean sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void setNombreCompleto(String nombreCompleto) {
        String[] nombres = nombreCompleto.split(" ");
        nombre = nombres[0];
        apellido = nombres[1];
    }

    public String getSexo() {
        return sexo ? "Masculino" : "Femenino";
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase().equals("MASCULINO");
    }

    @Override
    public String toString() {
        return "Cedula :" + cedula + "\n" +
                "Nombre: " + getNombreCompleto() + "\n" +
                "Sexo: "+ getSexo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || String.class != o.getClass()) return false;
        String nombre = o.toString();
        return getNombreCompleto().toUpperCase().equals(nombre.toUpperCase());
    }
}
