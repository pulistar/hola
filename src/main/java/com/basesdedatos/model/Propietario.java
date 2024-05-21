package com.basesdedatos.model;

public class Propietario {
    private int idPropietario;
    private String nombre;
    private int numPropiedades;
    private String ocupacion;
    private String historialPropiedad;
    private String documentacionLegal;
    private String contacto;

    // Getters y Setters

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPropiedades() {
        return numPropiedades;
    }

    public void setNumPropiedades(int numPropiedades) {
        this.numPropiedades = numPropiedades;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getHistorialPropiedad() {
        return historialPropiedad;
    }

    public void setHistorialPropiedad(String historialPropiedad) {
        this.historialPropiedad = historialPropiedad;
    }

    public String getDocumentacionLegal() {
        return documentacionLegal;
    }

    public void setDocumentacionLegal(String documentacionLegal) {
        this.documentacionLegal = documentacionLegal;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "idPropietario=" + idPropietario +
                ", nombre='" + nombre + '\'' +
                ", numPropiedades=" + numPropiedades +
                ", ocupacion='" + ocupacion + '\'' +
                ", historialPropiedad='" + historialPropiedad + '\'' +
                ", documentacionLegal='" + documentacionLegal + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}

